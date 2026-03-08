package lab5;

import java.util.Scanner;

public class lab5 {

    public static double mean(double a, double b) {
        return (a + b) / 2.0;
    }
    
    public static double mean(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
    
    public static double mean(double a, double b, double c, double d) {
        return (a + b + c + d) / 4.0;
    }
    
    public static double mean(double a, double b, double c, double d, double e) {
        return (a + b + c + d + e) / 5.0;
    }

    public static double stdDev(double a, double b) {
        double m = mean(a, b);
        return Math.sqrt((Math.pow(a - m, 2) + Math.pow(b - m, 2)) / 2.0);
    }
    
    public static double stdDev(double a, double b, double c) {
        double m = mean(a, b, c);
        return Math.sqrt((Math.pow(a - m, 2) + Math.pow(b - m, 2) + Math.pow(c - m, 2)) / 3.0);
    }
    
    public static double stdDev(double a, double b, double c, double d) {
        double m = mean(a, b, c, d);
        return Math.sqrt((Math.pow(a - m, 2) + Math.pow(b - m, 2) + Math.pow(c - m, 2) + Math.pow(d - m, 2)) / 4.0);
    }
    
    public static double stdDev(double a, double b, double c, double d, double e) {
        double m = mean(a, b, c, d, e);
        return Math.sqrt((Math.pow(a - m, 2) + Math.pow(b - m, 2) + Math.pow(c - m, 2) + 
                          Math.pow(d - m, 2) + Math.pow(e - m, 2)) / 5.0);
    }

    public static double meanVarargs(double... numbers) {
        if (numbers.length == 0) return 0.0;
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    public static double stdDevVarargs(double... numbers) {
        if (numbers.length == 0) return 0.0;
        double m = meanVarargs(numbers);
        double sumSq = 0;
        for (double num : numbers) {
            sumSq += Math.pow(num - m, 2);
        }
        return Math.sqrt(sumSq / numbers.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Heden toon deer statistic uildel guitsetgeh we? ");
        int n = sc.nextInt();

        if (n < 2 || n > 5) {
            System.out.println("Aldaa: 2-oos 5 hurtelh too oruulna uu.");
            sc.close();
            return;
        }

        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("%d-r toog oruul: ", i + 1);
            a[i] = sc.nextDouble();
        }

        double overloadedMean = 0;
        double overloadedStdDev = 0;

        switch (n) {
            case 2:
                overloadedMean = mean(a[0], a[1]);
                overloadedStdDev = stdDev(a[0], a[1]);
                break;
            case 3:
                overloadedMean = mean(a[0], a[1], a[2]);
                overloadedStdDev = stdDev(a[0], a[1], a[2]);
                break;
            case 4:
                overloadedMean = mean(a[0], a[1], a[2], a[3]);
                overloadedStdDev = stdDev(a[0], a[1], a[2], a[3]);
                break;
            case 5:
                overloadedMean = mean(a[0], a[1], a[2], a[3], a[4]);
                overloadedStdDev = stdDev(a[0], a[1], a[2], a[3], a[4]);
                break;
        }

        double varargsMean = meanVarargs(a);
        double varargsStdDev = stdDevVarargs(a);

        System.out.println("\n--- Ur dun (Overloaded Method) ---");
        System.out.printf("Dundaj (Mean): %.4f\n", overloadedMean);
        System.out.printf("Standart hazailt (StdDev): %.4f\n", overloadedStdDev);

        System.out.println("\n--- Ur dun (Varargs Method) ---");
        System.out.printf("Dundaj (Mean): %.4f\n", varargsMean);
        System.out.printf("Standart hazailt (StdDev): %.4f\n", varargsStdDev);

        sc.close();
    }
}