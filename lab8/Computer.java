package lab8;

public class Computer {
    private Processor processor;
    private Memory memory;
    private DisplayCard displayCard;
    private SoundCard soundCard;

    public Computer() {
        this.processor = new Processor("Intel Core i9", 16, 5.2, 24);
        this.memory = new Memory(32, "DDR5", 5600, "Kingston");
        this.displayCard = new DisplayCard(12, "RTX 4070", "ASUS", 2475);
        this.soundCard = new SoundCard(7, 192, "Creative Sound Blaster", "PCIe");
    }

    public void showInfo() {
        System.out.println("vzvvlelt");
        processor.printInfo();
        memory.printInfo();
        displayCard.printInfo();
        soundCard.printInfo();

    }
}