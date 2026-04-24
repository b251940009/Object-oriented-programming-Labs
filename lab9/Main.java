package lab9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Clock myClock = new Clock();

        System.out.println("--- Цагны систем ---");
        System.out.println("1. Автоматаар тохируулах");
        System.out.println("2. Гараар тохируулах");
        System.out.print("Сонголт: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            myClock.autoSetClock();
        } else {
            System.out.print("Жил, Сар, Өдөр, Цаг, Минут, Секунд (зайгаар тусгаарлан бич): ");
            myClock.setClock(sc.nextInt(), sc.nextInt(), sc.nextInt(), 
                             sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        System.out.println("\n1. Үндсэн хугацаа (1000 сек)");
        System.out.println("2. Өөрийнхөөрөө (tick)");
        System.out.print("Сонголт: ");
        int tickChoice = sc.nextInt();

        if (tickChoice == 1) {
            myClock.tickClock();
        } else {
            System.out.print("Хэдэн секунд ажиллуулах вэ?: ");
            int seconds = sc.nextInt();
            myClock.tickClock(seconds);
        }
        
        sc.close();
    }
}