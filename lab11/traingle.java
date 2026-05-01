package lab11;

public class traingle implements Shape {

    double base;
    double height;

    public traingle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void display() {
        System.out.printf("Triangle area (S = 1/2 * base * height) = %.2f\n", calculateArea());
    }
}