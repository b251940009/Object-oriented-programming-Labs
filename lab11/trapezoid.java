package lab11;

public class trapezoid implements Shape {

    double a;
    double b;
    double h;

    public trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return ((a + b) / 2) * h;
    }

    @Override
    public void display() {
        System.out.printf("Trapezoid area (S = (a + b)/2 * h) = %.2f\n", calculateArea());
    }
}