import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private double studentCGPA;
    private ArrayList<Course> courseList = new ArrayList<>();

    public Student() {}

    public Student(int studentId, String studentName, double studentCGPA) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCGPA = studentCGPA;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setStudentCgpa(double studentCGPA){
        this.studentCGPA = studentCGPA;
    }

    public int getStudentId() {
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    
    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void dropCourse(Course course) {
        courseList.remove(course);
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student CGPA: " + studentCGPA);
    }

    public void printCourseList() {
        System.out.println("Courses taken by " + studentName + ":");
        for (Course course : courseList) {
            System.out.println(course.getCourseTitle());
        }
    }
}

class Course {
    private String courseId;
    private String courseTitle;
    private double credit;
    private ArrayList<Student> studentList = new ArrayList<>();
    private Faculty faculty;

    public Course() {}

    public Course(String courseId, String courseTitle, double credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
    }

    public String getCourseId() {
        return courseId;
    }
    public Faculty getFaculty() {
        return faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    public String getCourseTitle() {
        return courseTitle;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void dropStudent(int studentId) {
        studentList.removeIf(student -> student.getStudentId() == studentId);
    }

    public void addFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    
   
    
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    
    
    public double getCredit() {
        return credit;
    }
    
    public void setCredit(double credit) {
        this.credit = credit;
    }
    public void dropFaculty() {
        this.faculty = null;
    }

    public void printStudentList() {
        System.out.println("Students enrolled in " + courseTitle + ":");
        for (Student student : studentList) {
            System.out.println(student.getStudentId() + " - " + student.getStudentName());
        }
    }

    public void display() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Credit: " + credit);
        if (faculty != null) {
            System.out.println("Faculty: " + faculty.getFacultyName());
        }
        else System.out.println("No Faculty has been assigned yet");
    }
}

class Faculty {
    private int facultyId;
    private String facultyName;
    private String facultyPosition;

    public Faculty() {}

    public Faculty(int facultyId, String facultyName, String facultyPosition) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPosition = facultyPosition;
    }
    public int getFacultyId() {
        return facultyId;
    }
    
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
    
 
    public String getFacultyName() {
        return facultyName;
    }
    
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    
    // Getter and Setter for facultyPosition
    public String getFacultyPosition() {
        return facultyPosition;
    }
    
    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }
    public void display() {
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Faculty Name: " + facultyName);
        System.out.println("Faculty Position: " + facultyPosition);
    }
}

public class MenuApplication {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Faculty> faculties = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("a. Add");
            System.out.println("b. Delete");
            System.out.println("c. Update");
            System.out.println("d. Print");
            System.out.println("e. Search");
            System.out.println("f. Exit");
            System.out.print("Choose an option: ");
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
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
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
                courses.add(new Course(courseId, courseTitle, credit));
                System.out.println("Course added successfully.");
                break;
            case "c":
                System.out.print("Enter Faculty ID: ");
                int facultyId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Faculty Name: ");
                String facultyName = scanner.nextLine();
                System.out.print("Enter Faculty Position: ");
                String facultyPosition = scanner.nextLine();
                faculties.add(new Faculty(facultyId, facultyName, facultyPosition));
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
                int studentId = Integer.parseInt(scanner.nextLine());
                students.removeIf(student -> student.getStudentId() == studentId);
                System.out.println("Student deleted successfully.");
                break;
            case "b":
                System.out.print("Enter Course ID to delete: ");
                String courseId = scanner.nextLine();
                courses.removeIf(course -> course.getCourseId().equals(courseId));
                System.out.println("Course deleted successfully.");
                break;
            case "c":
                System.out.print("Enter Faculty ID to delete: ");
                int facultyId = Integer.parseInt(scanner.nextLine());
                faculties.removeIf(faculty -> faculty.getFacultyName().equals(String.valueOf(facultyId)));
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
                boolean studentFound = false;
                for(Student student : students){
                    if(student.getStudentId() == studentIdToUpdate){
                        studentFound = true;
                        System.out.print("Enter updated Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter Student CGPA: ");
                        double studentCGPA = Double.parseDouble(scanner.nextLine());
                        student.setStudentName(studentName);
                        student.setStudentCgpa(studentCGPA);
                        System.out.println("Student information updated successfully.");
                    }
                    else System.out.println("Couldn't found the student");
                }
                break;
     
            case "b":
                // System.out.print("Enter Course ID: ");
                // String courseId = scanner.nextLine();
                // System.out.print("Enter Course Title: ");
                // String courseTitle = scanner.nextLine();
                // System.out.print("Enter Course Credit: ");
                // double credit = Double.parseDouble(scanner.nextLine());
                // courses.add(new Course(courseId, courseTitle, credit));
                // System.out.println("Course added successfully.");
                
                
            System.out.print("Enter Course ID: ");
            String courseIdToUpdate = scanner.nextLine();
            boolean courseFound = false;

            for (Course course : courses) {
                if (course.getCourseId().equals(courseIdToUpdate)) {
                    courseFound = true;

            System.out.print("Enter updated Course Title: ");
            String courseTitle = scanner.nextLine();

            System.out.print("Enter updated Credit: ");
            double credit = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter updated Faculty ID for this course: ");
            int facultyId = Integer.parseInt(scanner.nextLine());
            Faculty assignedFaculty = null;

            for (Faculty faculty : faculties) {
                if (faculty.getFacultyId() == facultyId) {
                    assignedFaculty = faculty;
                    break;
                }
            }

            if (assignedFaculty == null) {
                System.out.println("Faculty with ID " + facultyId + " not found.");
            } else {
                course.setCourseTitle(courseTitle);
                course.setCredit(credit);
                course.setFaculty(assignedFaculty);

                System.out.println("Course information updated successfully.");
            }
            break; // Exit the loop once the course is found and updated
                 }
        }   

    if (!courseFound) {
        System.out.println("Course with ID " + courseIdToUpdate + " not found.");
    }
    break;


                
            case "c":
                // System.out.print("Enter Faculty ID: ");
                // int facultyId = Integer.parseInt(scanner.nextLine());
                // System.out.print("Enter Faculty Name: ");
                // String facultyName = scanner.nextLine();
                // System.out.print("Enter Faculty Position: ");
                // String facultyPosition = scanner.nextLine();
                // faculties.add(new Faculty(facultyId, facultyName, facultyPosition));
                // System.out.println("Faculty added successfully.");
                System.out.print("Enter Faculty ID: ");
                int facultyIdToUpdate = Integer.parseInt(scanner.nextLine());
                boolean facultyFound = false;

                for (Faculty faculty : faculties) {
                    if (faculty.getFacultyId() == facultyIdToUpdate) {
                         facultyFound = true;

                System.out.print("Enter updated Faculty Name: ");
                String facultyName = scanner.nextLine();

                System.out.print("Enter updated Faculty Position: ");
                String facultyPosition = scanner.nextLine();

                faculty.setFacultyName(facultyName);
                faculty.setFacultyPosition(facultyPosition);

            System.out.println("Faculty information updated successfully.");
            break; // Exit the loop once the faculty is found and updated
        }
    }

    if (!facultyFound) {
        System.out.println("Faculty with ID " + facultyIdToUpdate + " not found.");
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
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                for (Student student : students) {
                    student.display();
                }
                break;
            case "b":
                for (Course course : courses) {
                    course.display();
                }
                break;
            case "c":
                for (Faculty faculty : faculties) {
                    faculty.display();
                }
                break;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }

    private static void searchEntity() {
        System.out.println("Search is not implemented yet.");
    }
}