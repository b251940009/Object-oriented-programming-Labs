package lab6;

import java.util.Scanner;

class MatrixCalculator {
    private int[][] operand1;
    private int[][] operand2;
    private String operator;

    public MatrixCalculator(int[][] operand1, int[][] operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    private int[][] addition(int[][] op1, int[][] op2) {
        int r = op1.length;
        int c = op1[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = op1[i][j] + op2[i][j];
        return res;
    }

    private int[][] subtraction(int[][] op1, int[][] op2) {
        int r = op1.length;
        int c = op1[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = op1[i][j] - op2[i][j];
        return res;
    }

    private int[][] multipliction(int[][] op1, int[][] op2) {
        int r1 = op1.length;
        int c1 = op1[0].length;
        int c2 = op2[0].length;
        int[][] res = new int[r1][c2];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    res[i][j] += op1[i][k] * op2[k][j];
        return res;
    }

    public int[][] chooseoperation() {
        int[][] result = null;
        String opName = "";
        
        switch (this.operator) {
            case "+": 
                result = addition(operand1, operand2); 
                opName = "Addition";
                break;
            case "-": 
                result = subtraction(operand1, operand2); 
                opName = "Subtraction";
                break;
            case "*": 
                result = multipliction(operand1, operand2); 
                opName = "Multipliction";
                break;
        }
        
        if (result != null) {
            System.out.println(opName + " Matrix is: Size(" + result.length + "x" + result[0].length + ")");
            printmatrix(result);
        }
        return result;
    }

    private void printmatrix(int[][] pmatrix) {
        for (int i = 0; i < pmatrix.length; i++) {
            for (int j = 0; j < pmatrix[0].length; j++) {
                System.out.print(pmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose an operation:");
        String op = sc.next();

        System.out.println("Insert the Size of 1st Matrix:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println("Enter the elements of the 1st Matrix: Size (" + r1 + "x" + c1 + ")");
        int[][] m1 = new int[r1][c1];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1; j++)
                m1[i][j] = sc.nextInt();

        int r2, c2;
        while (true) {
            System.out.println("Insert the Size of 2st Matrix:");
            r2 = sc.nextInt();
            c2 = sc.nextInt();

            if (op.equals("*")) {
                if (c1 == r2) break;
                System.out.println("Invalid dimensions for multiplication! (Col1 must equal Row2)");
            } else {
                if (r1 == r2 && c1 == c2) break;
                System.out.println("Invalid dimensions! (Matrices must be same size)");
            }
        }

        System.out.println("Enter the elements of the 2st Matrix: Size (" + r2 + "x" + c2 + ")");
        int[][] m2 = new int[r2][c2];
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                m2[i][j] = sc.nextInt();

        MatrixCalculator calc = new MatrixCalculator(m1, m2, op);
        calc.chooseoperation();
        
        sc.close();
    }
}