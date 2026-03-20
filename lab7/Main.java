package lab7; 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager(); 
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("1. oyutan nemeh");
            System.out.println("2. oyutan ustgah");
            System.out.println("3. oyutan haih");
            System.out.println("4. erembleh");
            System.out.println("5. buh oyutanii medelel hrah");
            System.out.println("6. garah");
            System.out.print("songolt: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ner: ");
                    String name = scanner.nextLine();
                    System.out.print("nas: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("oyutanii code: ");
                    String studentId = scanner.nextLine();

                    Student s = new Student(name, age, studentId);
                    manager.addStudent(s);
                    break;

                case 2:
                    System.out.print("oyutanii code oor ustgah: ");
                    String idToRemove = scanner.nextLine();
                    manager.removeStudent(idToRemove);
                    break;

                case 3:
                    System.out.print("oyutaniii code oor haih: ");
                    String idToFind = scanner.nextLine();
                    Student found = manager.findStudent(idToFind);
                    if (found != null) {
                        System.out.println("oldsn: " + found);
                    } else {
                        System.out.println("oyutan oldsongui.");
                    }
                    break;

                case 4:
                    manager.sortByName();
                    break;

                case 5:
                    manager.printAllStudents();
                    break;

                case 6:
                    System.out.println("garah");
                    break;

                default:
                    System.out.println("buruu songolt");
            }
        } while (choice != 6);

        scanner.close();
    }
}