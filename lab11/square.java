package lab11;

public class square implements Shape {

    double a;

    public square(double a) {
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public void display() {
        System.out.printf("Square area (s = a * a) = %.2f\n", calculateArea());
    }
}