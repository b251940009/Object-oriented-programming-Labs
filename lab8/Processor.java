package lab8;

public class Processor {
    private String brand;
    private int cores;
    private double speed;
    private int cache;

    public Processor(String brand, int cores, double speed, int cache) {
        this.brand = brand;
        this.cores = cores;
        this.speed = speed;
        this.cache = cache;
    }

    public void printInfo() {
        System.out.println("Processor");
        System.out.println("Brand: " + brand);
        System.out.println("Cores: " + cores);
        System.out.println("Speed: " + speed + " GHz");
        System.out.println("Cache: " + cache + " MB");
    }
}