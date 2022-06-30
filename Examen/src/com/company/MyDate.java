
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(String[] k) {
        if (k[0].charAt(0) == '0') {
            this.day = Integer.parseInt(String.valueOf(k[0].charAt(1)));
        }
        else {
            this.day = Integer.parseInt(k[0]);
        }
        if (k[1].charAt(0) == '0') {
            this.month = Integer.parseInt(String.valueOf(k[1].charAt(1)));
        }
        else {
            this.month = Integer.parseInt(k[1]);
        }
        this.year = Integer.parseInt(k[2]);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String d = String.valueOf(day);
        if (day < 10) {
            d = "0" + d;
        }
        String m = String.valueOf(month);
        if (month < 10) {
            m = "0" + m;
        }
        String y = String.valueOf(year);
        return  d + "." + m + "." + y;
    }

    public int subMonth(MyDate date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(this.toString(), formatter);
        LocalDate endDate = LocalDate.parse(date2.toString(), formatter);
        Period period = Period.between(startDate, endDate);
        return period.getMonths();
    }

    public int subDay(MyDate date2) throws ParseException {
        String str1 = this.toString();
        String str2 = date2.toString();
        Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(str1);
        Date endDate = new SimpleDateFormat("dd.MM.yyyy").parse(str2);
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTimeInMillis(startDate.getTime());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTimeInMillis(endDate.getTime());
        long difference = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
        long days = difference /(24* 60 * 60 * 1000);
        return Math.toIntExact(days);
    }
}
