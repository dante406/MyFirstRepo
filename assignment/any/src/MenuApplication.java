import java.util.ArrayList;
import java.util.Scanner;

class Faculty {
    private int facultyId;
    private String facultyName;
    private String facultyPosition;

    public Faculty(int facultyId, String facultyName, String facultyPosition) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPosition = facultyPosition;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyPosition() {
        return facultyPosition;
    }
}

class Course {
    private String courseId;
    private String courseTitle;
    private double credit;
    private ArrayList<Student> studentList = new ArrayList<>();
    private Faculty courseFaculty;

    public Course(String courseId, String courseTitle, double credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setFaculty(Faculty faculty) {
        this.courseFaculty = faculty;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        student.enrollInCourse(this); // Automatically update student's course list
    }

    public void printCourseDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Credit: " + credit);
        if (courseFaculty != null) {
            System.out.println("Faculty Assigned: " + courseFaculty.getFacultyName() + " (" + courseFaculty.getFacultyPosition() + ")");
        } else {
            System.out.println("No faculty assigned to this course.");
        }

        System.out.println("Students enrolled in this course:");
        if (studentList.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            for (Student student : studentList) {
                System.out.println("  " + student.getStudentName());
            }
        }
    }
}

class Student {
    private int studentId;
    private String studentName;
    private double studentCGPA;
    private ArrayList<Course> courseList = new ArrayList<>();

    public Student(int studentId, String studentName, double studentCGPA) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCGPA = studentCGPA;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudentCgpa() {
        return studentCGPA;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentCgpa(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    public void enrollInCourse(Course course) {
        courseList.add(course);
    }

    public void dropCourse(Course course) {
        courseList.remove(course);
    }

    public void printCourses() {
        System.out.println("Courses taken by " + studentName + ":");
        if (courseList.isEmpty()) {
            System.out.println("  No courses enrolled.");
        } else {
            for (Course course : courseList) {
                System.out.println("  " + course.getCourseTitle() + " (Course ID: " + course.getCourseId() + ")");
            }
        }
    }
}

public class MenuApplication {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Faculty> faculties = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "a":
                    addEntity();
                    break;
                case "b":
                    deleteEntity();
                    break;
                case "c":
                    updateEntity();
                    break;
                case "d":
                    printEntity();
                    break;
                case "e":
                    searchEntity();
                    break;
                case "f":
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("a. Add");
        System.out.println("b. Delete");
        System.out.println("c. Update");
        System.out.println("d. Print");
        System.out.println("e. Search");
        System.out.println("f. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addEntity() {
        System.out.println("Add:");
        System.out.println("a. Add a Student");
        System.out.println("b. Add a Course");
        System.out.println("c. Add a Faculty");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                System.out.print("Enter Student ID: ");
                int studentId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Student Name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter Student CGPA: ");
                double studentCGPA = Double.parseDouble(scanner.nextLine());
                students.add(new Student(studentId, studentName, studentCGPA));
                System.out.println("Student added successfully.");
                break;
            case "b":
                System.out.print("Enter Course ID: ");
                String courseId = scanner.nextLine();
                System.out.print("Enter Course Title: ");
                String courseTitle = scanner.nextLine();
                System.out.print("Enter Course Credit: ");
                double credit = Double.parseDouble(scanner.nextLine());
                Course newCourse = new Course(courseId, courseTitle, credit);

                // Add Faculty to Course
                System.out.print("Enter Faculty ID to assign: ");
                int facultyId = Integer.parseInt(scanner.nextLine());
                Faculty assignedFaculty = null;
                for (Faculty faculty : faculties) {
                    if (faculty.getFacultyId() == facultyId) {
                        assignedFaculty = faculty;
                        break;
                    }
                }
                if (assignedFaculty != null) {
                    newCourse.setFaculty(assignedFaculty);
                } else {
                    System.out.println("No faculty found with ID " + facultyId);
                }

                // Enroll Students to Course
                System.out.print("Enter number of students to enroll in this course: ");
                int numStudents = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < numStudents; i++) {
                    System.out.print("Enter Student ID to enroll: ");
                    int studentIdToEnroll = Integer.parseInt(scanner.nextLine());
                    Student enrolledStudent = null;
                    for (Student student : students) {
                        if (student.getStudentId() == studentIdToEnroll) {
                            enrolledStudent = student;
                            break;
                        }
                    }
                    if (enrolledStudent != null) {
                        newCourse.addStudent(enrolledStudent);
                    } else {
                        System.out.println("No student found with ID " + studentIdToEnroll);
                    }
                }

                courses.add(newCourse);
                System.out.println("Course added successfully.");
                break;
            case "c":
                System.out.print("Enter Faculty ID: ");
                int facultyIdToAdd = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Faculty Name: ");
                String facultyName = scanner.nextLine();
                System.out.print("Enter Faculty Position: ");
                String facultyPosition = scanner.nextLine();
                faculties.add(new Faculty(facultyIdToAdd, facultyName, facultyPosition));
                System.out.println("Faculty added successfully.");
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }

    private static void deleteEntity() {
        System.out.println("Delete:");
        System.out.println("a. Delete a Student");
        System.out.println("b. Delete a Course");
        System.out.println("c. Delete a Faculty");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                System.out.print("Enter Student ID to delete: ");
                int studentIdToDelete = Integer.parseInt(scanner.nextLine());
                students.removeIf(student -> student.getStudentId() == studentIdToDelete);
                System.out.println("Student deleted successfully.");
                break;
            case "b":
                System.out.print("Enter Course ID to delete: ");
                String courseIdToDelete = scanner.nextLine();
                courses.removeIf(course -> course.getCourseId().equals(courseIdToDelete));
                System.out.println("Course deleted successfully.");
                break;
            case "c":
                System.out.print("Enter Faculty ID to delete: ");
                int facultyIdToDelete = Integer.parseInt(scanner.nextLine());
                faculties.removeIf(faculty -> faculty.getFacultyId() == facultyIdToDelete);
                System.out.println("Faculty deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }

    private static void updateEntity() {
        System.out.println("Update:");
        System.out.println("a. Update a Student");
        System.out.println("b. Update a Course");
        System.out.println("c. Update a Faculty");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                System.out.print("Enter Student ID: ");
                int studentIdToUpdate = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new name: ");
                String studentNameToUpdate = scanner.nextLine();
                System.out.print("Enter new CGPA: ");
                double studentCGPAtoUpdate = Double.parseDouble(scanner.nextLine());
                for (Student student : students) {
                    if (student.getStudentId() == studentIdToUpdate) {
                        student.setStudentName(studentNameToUpdate);
                        student.setStudentCgpa(studentCGPAtoUpdate);
                        System.out.println("Student updated successfully.");
                    }
                }
                break;
            case "b":
                System.out.print("Enter Course ID: ");
                String courseIdToUpdate = scanner.nextLine();
                System.out.print("Enter new Course Title: ");
                String courseTitleToUpdate = scanner.nextLine();
                System.out.print("Enter new Credit: ");
                double courseCreditToUpdate = Double.parseDouble(scanner.nextLine());
                for (Course course : courses) {
                    if (course.getCourseId().equals(courseIdToUpdate)) {
                        course.setFaculty(null); // Remove current faculty
                        System.out.print("Enter Faculty ID to assign: ");
                        int facultyIdToAssign = Integer.parseInt(scanner.nextLine());
                        Faculty assignedFaculty = null;
                        for (Faculty faculty : faculties) {
                            if (faculty.getFacultyId() == facultyIdToAssign) {
                                assignedFaculty = faculty;
                                break;
                            }
                        }
                        if (assignedFaculty != null) {
                            course.setFaculty(assignedFaculty);
                        } else {
                            System.out.println("No faculty found with ID " + facultyIdToAssign);
                        }
                        System.out.println("Course updated successfully.");
                    }
                }
                break;
            case "c":
                System.out.print("Enter Faculty ID to update: ");
                int facultyIdToUpdate = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new Faculty Name: ");
                String facultyNameToUpdate = scanner.nextLine();
                System.out.print("Enter new Faculty Position: ");
                String facultyPositionToUpdate = scanner.nextLine();
                for (Faculty faculty : faculties) {
                    if (faculty.getFacultyId() == facultyIdToUpdate) {
                        faculty = new Faculty(facultyIdToUpdate, facultyNameToUpdate, facultyPositionToUpdate);
                        System.out.println("Faculty updated successfully.");
                    }
                }
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }

    private static void printEntity() {
        System.out.println("Print:");
        System.out.println("a. Print all students");
        System.out.println("b. Print all courses");
        System.out.println("c. Print all faculties");
        System.out.println("d. Print Student Information");
        System.out.println("e. Print Faculty Information");
        System.out.println("f. Print Student list and info of course");
        System.out.println("g. Print Student list and Faculty information of course");
        System.out.println("h. Print Courses taken by a student");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                System.out.println("All Students:");
                for (Student student : students) {
                    System.out.println("  " + student.getStudentName() + " (ID: " + student.getStudentId() + ")");
                }
                break;
            case "b":
                System.out.println("All Courses:");
                for (Course course : courses) {
                    System.out.println("  " + course.getCourseTitle() + " (Course ID: " + course.getCourseId() + ")");
                }
                break;
            case "c":
                System.out.println("All Faculties:");
                for (Faculty faculty : faculties) {
                    System.out.println("  " + faculty.getFacultyName() + " (ID: " + faculty.getFacultyId() + ")");
                }
                break;
            case "d":
                System.out.print("Enter Student ID: ");
                int studentIdToPrint = Integer.parseInt(scanner.nextLine());
                for (Student student : students) {
                    if (student.getStudentId() == studentIdToPrint) {
                        System.out.println("Student Information:");
                        System.out.println("  Name: " + student.getStudentName());
                        System.out.println("  CGPA: " + student.getStudentCgpa());
                    }
                }
                break;
            case "e":
                System.out.print("Enter Faculty ID: ");
                int facultyIdToPrint = Integer.parseInt(scanner.nextLine());
                for (Faculty faculty : faculties) {
                    if (faculty.getFacultyId() == facultyIdToPrint) {
                        System.out.println("Faculty Information:");
                        System.out.println("  Name: " + faculty.getFacultyName());
                        System.out.println("  Position: " + faculty.getFacultyPosition());
                    }
                }
                break;
            case "f":
                System.out.print("Enter Course ID: ");
                String courseIdToPrint = scanner.nextLine();
                boolean courseFound = false;
                for (Course course : courses) {
                    if (course.getCourseId().equals(courseIdToPrint)) {
                        courseFound = true;
                        course.printCourseDetails(); // Print student list and faculty info
                        break;
                    }
                }
                if (!courseFound) {
                    System.out.println("Course with ID " + courseIdToPrint + " not found.");
                }
                break;
            case "g":
                System.out.print("Enter the Course ID: ");
                String courseIdToPrintG = scanner.nextLine();
                boolean foundCourse = false;
                for (Course course : courses) {
                    if (course.getCourseId().equals(courseIdToPrintG)) {
                        foundCourse = true;
                        course.printCourseDetails();  // Will print student list and faculty info
                        break;
                    }
                }
                if (!foundCourse) {
                    System.out.println("Course not found.");
                }
                break;
            case "h":
                System.out.print("Enter Student ID: ");
                int studentIdToPrintH = Integer.parseInt(scanner.nextLine());
                boolean foundStudent = false;
                for (Student student : students) {
                    if (student.getStudentId() == studentIdToPrintH) {
                        foundStudent = true;
                        student.printCourses();  // Print the courses for the student
                        break;
                    }
                }
                if (!foundStudent) {
                    System.out.println("Student not found.");
                }
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }

    private static void searchEntity() {
        System.out.println("Search:");
        System.out.println("a. Search a Student");
        System.out.println("b. Search a Course");
        System.out.println("c. Search a Faculty");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                System.out.print("Enter Student ID to search: ");
                int studentIdToSearch = Integer.parseInt(scanner.nextLine());
                for (Student student : students) {
                    if (student.getStudentId() == studentIdToSearch) {
                        System.out.println("Student found: " + student.getStudentName());
                    }
                }
                break;
            case "b":
                System.out.print("Enter Course ID to search: ");
                String courseIdToSearch = scanner.nextLine();
                for (Course course : courses) {
                    if (course.getCourseId().equals(courseIdToSearch)) {
                        System.out.println("Course found: " + course.getCourseTitle());
                    }
                }
                break;
            case "c":
                System.out.print("Enter Faculty ID to search: ");
                int facultyIdToSearch = Integer.parseInt(scanner.nextLine());
                for (Faculty faculty : faculties) {
                    if (faculty.getFacultyId() == facultyIdToSearch) {
                        System.out.println("Faculty found: " + faculty.getFacultyName());
                    }
                }
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }
}
