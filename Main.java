import java.util.*;

class Student {
    int id;
    String name, email, phoneNumber;

    Student(int id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

interface StudentOperations {
    void addStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(int id, String name, String email, String phoneNumber);
    void displayStudents();
}

class StudentService implements StudentOperations {
    List<Student> students = new ArrayList<>();
    Set<Integer> studentIds = new HashSet<>();

    public void addStudent(Student student) {
        if (!studentIds.add(student.id)) {
            System.out.println("Error: ID " + student.id + " already exists. Choose a unique ID.");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void deleteStudent(int id) {
        if (studentIds.contains(id)) {
            students.removeIf(student -> student.id == id);
            studentIds.remove(id);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    public void updateStudent(int id, String name, String email, String phoneNumber) {
        for (Student student : students) {
            if (student.id == id) {
                student.name = name;
                student.email = email;
                student.phoneNumber = phoneNumber;
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student.id + " " + student.name + " " + student.email + " " + student.phoneNumber);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        
        service.addStudent(new Student(1, "Abhishek", "ak@gmail.com", "1234567890"));
        service.addStudent(new Student(2, "Abhi", "ak1@gmail.com", "2345678901"));
        service.addStudent(new Student(3, "Rahul", "ak2@gmail.com", "3456789012"));
        service.addStudent(new Student(4, "Arun", "ak3@gmail.com", "4567890123"));

        while (true) {
            System.out.println("\n1. Add Student  2. Update  3. Delete  4. Display  5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    service.addStudent(new Student(id, name, email, phone));
                    break;
                case 2:
                    System.out.print("ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("New Phone: ");
                    String newPhone = sc.nextLine();
                    service.updateStudent(updateId, newName, newEmail, newPhone);
                    break;
                case 3:
                    System.out.print("ID to delete: ");
                    service.deleteStudent(sc.nextInt());
                    break;
                case 4:
                    service.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
