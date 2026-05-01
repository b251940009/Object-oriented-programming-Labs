package lab11;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    	
    	        Scanner sc = new Scanner(System.in);

    	        System.out.println("Dursii nner: ");
    	        String type = sc.nextLine().toLowerCase();

    	        Shape shape = null;

    	        switch (type) {

    	            
    	            case "square":
    	           
    	                System.out.print("taliin urt: ");
    	                double s = sc.nextDouble();
    	                shape = new square(s);
    	                break;

    	            
    	            case "rectangle":
    	           
    	                System.out.print("urt: ");
    	                double w = sc.nextDouble();
    	                System.out.print("urgun: ");
    	                double h = sc.nextDouble();
    	                shape = new rectangle(w, h);
    	                break;

    	            
    	            case "triangle":
    	           
    	                System.out.print("suuri: ");
    	                double b = sc.nextDouble();
    	                System.out.print("undur: ");
    	                double th = sc.nextDouble();
    	                shape = new traingle(b, th);
    	                break;

    	          
    	            case "trapezoid":
    	         
    	                System.out.print("a tal: ");
    	                double a = sc.nextDouble();
    	                System.out.print("b tal: ");
    	                double bb = sc.nextDouble();
    	                System.out.print("undur: ");
    	                double hh = sc.nextDouble();
    	                shape = new trapezoid(a, bb, hh);
    	                break;

    	         
    	            case "circle":
    	            
    	                System.out.print("radius: ");
    	                double r = sc.nextDouble();
    	                shape = new circle(r);
    	                break;

    	          
    	            case "sector":
    	            
    	                System.out.print("radius: ");
    	                double sr = sc.nextDouble();
    	                System.out.print("untsug: ");
    	                double ang = sc.nextDouble();
    	                shape = new sector(sr, ang);
    	                break;

    	           
    	            case "ellipse":

    	                System.out.print("a: ");
    	                double ea = sc.nextDouble();
    	                System.out.print("b: ");
    	                double eb = sc.nextDouble();
    	                shape = new ellipse(ea, eb);
    	                break;

    	         
    	            case "parallelogram":
    	           
    	                System.out.print("suuri: ");
    	                double pb = sc.nextDouble();
    	                System.out.print("undur: ");
    	                double ph = sc.nextDouble();
    	                shape = new prallelogram(pb, ph);
    	                break;

    	            default:
    	                System.out.println("Iim durs algadaa");
    	                return;
    	        }

    	    
    	        System.out.println("durs: " + type);
    	        System.out.println("talbai: " + shape.calculateArea());

    	        sc.close();
    	    }
    	
    	}
   
