package lab9;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class Clock {
    private int year, month, day, hour, minute, second;
    private LocalDateTime ldt;
    private DateTimeFormatter formatter;

    public Clock() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void setClock(int y, int mon, int d, int h, int min, int s) {
        this.ldt = LocalDateTime.of(y, mon, d, h, min, s);
        updateFields();
    }

    public void autoSetClock() {
        this.ldt = LocalDateTime.now();
        updateFields();
    }

    private void updateFields() {
        this.year = ldt.getYear();
        this.month = ldt.getMonthValue();
        this.day = ldt.getDayOfMonth();
        this.hour = ldt.getHour();
        this.minute = ldt.getMinute();
        this.second = ldt.getSecond();
    }

    public void tickClock() {
        tickClock(1000);
    }
    public void tickClock(int tick) {
        System.out.println("Цаг ажиллаж эхэллээ...");
        for (int i = 0; i < tick; i++) {
            try {
                System.out.println(ldt.format(formatter));
                ldt = ldt.plusSeconds(1); 
                updateFields();
                TimeUnit.SECONDS.sleep(1); 
            } catch (InterruptedException e) {
                System.out.println("Алдаа гарлаа: " + e.getMessage());
            }
        }
        System.out.println("Цаг зогслоо.");
    }
}