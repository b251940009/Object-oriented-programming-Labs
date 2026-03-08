package javha;

import java.util.Scanner;

public class dundaj {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("ehnii too: ");
        double a = input.nextDouble();       
        System.out.print("hoyrdoh too: ");
        double b = input.nextDouble();        
        double arhi = (a + b) / 2;
        
        double geo = Math.sqrt(a * b);

        System.out.printf("Арифметик: %.2f%n", arhi);
        System.out.printf("Геометр:   %.2f%n", geo);

        input.close();
    }
}