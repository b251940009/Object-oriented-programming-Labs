package lab11;

public class ellipse implements Shape {

    double a; 
    double b; 

    public ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return Math.PI * a * b;
    }

    @Override
    public void display() {
        System.out.printf("Ellipse area (S = π * a * b) = %.2f\n", calculateArea());
    }
}