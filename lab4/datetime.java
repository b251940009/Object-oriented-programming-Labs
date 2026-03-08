package datetime;

import java.util.Scanner;

public class datetime {

    private int year;
    private int month;
    private int day;


    public datetime(String dt) {

        String[] values = dt.split("[-./]");
        if (values.length == 3) {
            this.year = Integer.parseInt(values[0].trim());
            this.month = Integer.parseInt(values[1].trim());
            this.day = Integer.parseInt(values[2].trim());
        }
    }


    private int getyearcode(int year) {
        int lastTwoDigits = year % 100;
        return (lastTwoDigits + (lastTwoDigits / 4)) % 7;
    }

    private int getmonthcode(int month) {
        int[] monthCodes = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        return monthCodes[month - 1];
    }

    private int getcenturycode(int century) {
        switch (century) {
            case 17: return 4;
            case 18: return 2;
            case 19: return 0;
            case 20: return 6;
            case 21: return 4;
            case 22: return 2;
            case 23: return 0;
            default: return 0;
        }
    }

    private int getleapyearcode(int year, int month) {
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeap && (month == 1 || month == 2)) {
            return 1;
        }
        return 0;
    }

    private int dayofweek() {
        int yearCode = getyearcode(this.year);
        int monthCode = getmonthcode(this.month);
        int centuryCode = getcenturycode(this.year / 100);
        int leapYearCode = getleapyearcode(this.year, this.month);
        

        int result = (yearCode + monthCode + centuryCode + this.day - leapYearCode) % 7;
        return (result + 7) % 7;
    }

    public void printdayofweek() {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int code = dayofweek();
        System.out.println(this.year + " onii " + this.month + "-r sariin " + this.day + " bol " + days[code]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ognoo oruulna uu (YYYY.MM.DD): ");
        if (sc.hasNextLine()) {
            String input = sc.nextLine();
            
            datetime dtObj = new datetime(input);
            
            dtObj.printdayofweek();
        }
        
        sc.close();
    }
}
