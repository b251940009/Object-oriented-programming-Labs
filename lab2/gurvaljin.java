package javha; 

import java.util.Scanner;

public class gurvaljin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double ax, ay, bx, by, cx, cy, a, b, c , p, talbai;
        ; 
        System.out.println("A coord (ax ay): ");
        ax = input.nextDouble();
        ay = input.nextDouble();

        System.out.println("B coord (bx by): ");
        bx = input.nextDouble();
        by = input.nextDouble();

        System.out.println("C coord (cx cy): ");
        cx = input.nextDouble();
        cy = input.nextDouble();

        c = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
        a = Math.sqrt(Math.pow(cx - bx, 2) + Math.pow(cy - by, 2)); 
        b = Math.sqrt(Math.pow(cx - ax, 2) + Math.pow(cy - ay, 2)); 

        p = (a + b + c) / 2;
        talbai = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.printf("gurvaljin taluud: a=%.2f, b=%.2f, c=%.2f%n", a, b, c);
        System.out.printf("gurvaljin talbai: %.4f%n", talbai);

        input.close();
    }
}