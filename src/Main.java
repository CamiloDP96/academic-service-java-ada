import com.model.Course;
import com.model.Professor;
import com.model.Student;
import com.service.AcademicService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AcademicService academicService = new AcademicService();

        Scanner scanner = new Scanner(System.in);
        int option = showOptionsMenuAndCaptureOption(scanner);

        while (option != 9) {

            switch (option) {
                case 1 -> registerNewProfessor(scanner,academicService);
                case 2 -> registerNewCourse(scanner,academicService);
                case 3 -> registerNewStudent(scanner,academicService);
                case 4 -> enrollStudentToCourse(scanner,academicService);
                case 5 -> findAProfessor(scanner,academicService);
                case 6 -> findAStudent(scanner,academicService);
                case 7 -> findACourse(scanner,academicService);
                case 8 -> enrollProfessorToCourse(scanner,academicService);

            }
            option = showOptionsMenuAndCaptureOption(scanner);
        }
    }

    private static void findAProfessor(Scanner scanner, AcademicService academicService) {
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        Optional<Professor> professorOptional = academicService.findProfessorById(id);
        if (professorOptional.isPresent()) {
            System.out.println(professorOptional.get());
        } else {
            System.out.println("Professor with id: " + id + " not found");
        }
    }

    private static void findAStudent(Scanner scanner, AcademicService academicService) {
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        Optional<Student> studentOptional = academicService.findStudentById(id);
        if (studentOptional.isPresent()) {
            System.out.println(studentOptional.get());
        } else {
            System.out.println("Student with id: " + id + " not found");
        }
    }

    private static void findACourse(Scanner scanner, AcademicService academicService) {
        System.out.println("Enter the course code: ");
        String code = scanner.nextLine();
        Optional<Course> courseOptional = academicService.findCourseByCode(code);
        if (courseOptional.isPresent()) {
            System.out.println(courseOptional.get());
        } else {
            System.out.println("Course with code: " + code + " not found");
        }
    }

    private static void enrollStudentToCourse(Scanner scanner, AcademicService academicService) {
        System.out.println("Enter the student's ID: ");
        String idStudent = scanner.nextLine();
        System.out.println("Enter the course code: ");
        String codeCourse = scanner.nextLine();
        academicService.enrollStudent(idStudent, codeCourse);
        System.out.println("Student with ID " + idStudent + " enrolled in the course with code " + codeCourse);
    }

    private static void enrollProfessorToCourse(Scanner scanner, AcademicService academicService) {
        try {
            System.out.println("Enter the Professor's ID: ");
            String idProfesor = scanner.nextLine();
            System.out.println("Enter the course code: ");
            String codeCourse = scanner.nextLine();
            academicService.enrollProfessor(idProfesor, codeCourse);
            System.out.println("Student with ID " + idProfesor + " enrolled in the course with code " + codeCourse);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void registerNewStudent(Scanner scanner, AcademicService academicService) {
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Student student = new Student(id, name, email, phoneNumber);
        academicService.addStudent(student);
    }

    private static void registerNewCourse(Scanner scanner, AcademicService academicService) {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the code: ");
        String code = scanner.nextLine();
        System.out.println("Enter the credits: ");
        int credits = scanner.nextInt();
        Course course = new Course(name, code, credits);
        academicService.addCourse(course);
    }

    private static void registerNewProfessor(Scanner scanner, AcademicService academicService) {
        //String id, String name, String email, String phoneNumber
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Professor professor = new Professor(id, name, email, phoneNumber);
        academicService.addProfessor(professor);
    }

    private static int showOptionsMenuAndCaptureOption(Scanner scanner) {
        System.out.println("*----------------------------------------------*");
        System.out.println("| Please select one of the following options:  |");
        System.out.println("| 1. Register a new Professor                  |");
        System.out.println("| 2. Register a new Course                     |");
        System.out.println("| 3. Register a new Student                    |");
        System.out.println("| 4. Enroll Student to Course                  |");
        System.out.println("| 5. Find  a  Professor                        |");
        System.out.println("| 6. Find  a  Student                          |");
        System.out.println("| 7. Find  a  Course                           |");
        System.out.println("| 8. Enroll Professor to Course                |");
        System.out.println("| 9. Exit                                      |");
        System.out.println("*----------------------------------------------*");
        int option = 0;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 9) {
                System.out.println("| The Option selected is not valid. Please try again |");
                showOptionsMenuAndCaptureOption(scanner);
            }
        } catch (Exception e) {
            System.out.println("| The Option selected is not valid. Please try again |");
            showOptionsMenuAndCaptureOption(scanner);
        }
        return option;
    }
}