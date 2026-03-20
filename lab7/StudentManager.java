package lab7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        if (findStudent(s.getStudentId()) != null) {
            System.out.println("ene code toi oyutan ali hediin bvrtgeltei baina.");
            return;
        }
        students.add(s);
        System.out.println("oyutan nemegdelee.");
    }

    public void removeStudent(String studentId) {
        Student found = findStudent(studentId);
        if (found == null) {
            System.out.println("oldsongui.");
            return;
        }
        students.remove(found);
        System.out.println("oyutan ustalaa.");
    }

    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }
        return null;
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("oyutan baihgui");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("nereeer eremblelee.");
    }
}