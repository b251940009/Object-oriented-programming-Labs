package lab11;

public class circle implements Shape {

    double radius;

    public circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.printf("Circle area (S = π * r^2) = %.2f\n", calculateArea());
    }
}