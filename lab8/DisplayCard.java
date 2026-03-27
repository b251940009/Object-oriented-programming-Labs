package lab8;

public class DisplayCard {
    private int memory;
    private String chipset;
    private String brand;
    private int clockSpeed;

    public DisplayCard(int memory, String chipset, String brand, int clockSpeed) {
        this.memory = memory;
        this.chipset = chipset;
        this.brand = brand;
        this.clockSpeed = clockSpeed;
    }

    public void printInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Chipset: " + chipset);
        System.out.println("Memory: " + memory + " GB");
        System.out.println("Clock Speed: " + clockSpeed + " MHz");
    }
}