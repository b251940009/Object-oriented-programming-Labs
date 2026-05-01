package lab11;

public class prallelogram implements Shape {

    double base;
    double height;

    public prallelogram(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height;
    }

    @Override
    public void display() {
        System.out.printf("Parallelogram area (S = base * height) = %.2f\n", calculateArea());
    }
}