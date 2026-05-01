package lab11;

public class rectangle implements Shape {
	 double a;
 double b;
	double s;
	
	public rectangle(double a, double b, double s) {
		this.a = a;
		this.b = b;
		 this.s = s;	
	}
	public void area() {
		s = (a*b);
	}
	
	public void info() {
		System.out.printf("Tegsh untsugt gurvaljnii talbai <s=(a*b)> = ", + s);
	}
}
