package lab11;

public class sector implements Shape {

    double radius;
    double angle; 

    public sector(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius * (angle / 360);
    }

    @Override
    public void display() {
        System.out.printf("Sector area (S = π * r^2 * angle/360) = %.2f\n", calculateArea());
    }
}