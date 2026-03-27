package lab8;

public class SoundCard {
    private int channels;
    private int sampleRate;
    private String brand;
    private String interfaceType;

    public SoundCard(int channels, int sampleRate, String brand, String interfaceType) {
        this.channels = channels;
        this.sampleRate = sampleRate;
        this.brand = brand;
        this.interfaceType = interfaceType;
    }

    public void printInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Channels: " + channels + ".1");
        System.out.println("Sample Rate: " + sampleRate + " kHz");
        System.out.println("Interface: " + interfaceType);
    }
}