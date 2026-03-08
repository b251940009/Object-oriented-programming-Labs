package savings; 

import java.util.Scanner; // 1. Утга унших багажийг импортлох

public class savings {

    private String randombank;
    private String MNT;
    private double hvv;
    private int sar; 
    private double ehniih;

    public savings(String randombank, String MNT, double hvv, int sar, double ehniih) {
        this.randombank = randombank;
        this.MNT = MNT;
        this.hvv = hvv;
        this.sar = sar; 
        this.ehniih = ehniih;
    }

    private double savingscalcaccrued() {
        return ehniih * (hvv / 12.0) * sar / 100;
    }

    private double savingscalc() {
        return ehniih + savingscalcaccrued();
    }

    public void savingsreport() {
        System.out.printf("Та \"%s\"-д %,.1f %s-ийг %d sariin hugatsaatai hadalgaluulval:%n", 
                          randombank, ehniih, MNT, sar);
        System.out.printf("bodson hvv: %,.1f %s%n", savingscalcaccrued(), MNT);
        System.out.printf("niit dvn: %,.1f %s%n", savingscalc(), MNT);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("hadgalamj ner");
        String name = scanner.nextLine();

        System.out.print("valyut");
        String currency = scanner.next();

        System.out.print("jiliin hvv ");
        double rate = scanner.nextDouble();

        System.out.print("hugatsaa");
        int months = scanner.nextInt();

        System.out.print("ehnii dvn: ");
        double balance = scanner.nextDouble();

        savings userAcc = new savings(name, currency, rate, months, balance);
        
        userAcc.savingsreport();

        scanner.close(); 
    }
}