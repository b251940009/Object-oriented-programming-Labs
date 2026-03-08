package javha;

import java.util.Scanner;

public class geriinbus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        System.out.print("geriin rad (R): ");
        double radius = input.nextDouble();

        double busluur = 2 * Math.PI * radius*3 ;

        System.out.printf("geriin bvlsvvriin urt: %.2f meter bn.", busluur);

        input.close();
    }
}