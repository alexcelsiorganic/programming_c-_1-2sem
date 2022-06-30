package com.company;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String[] k) {
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

    public Date(int day, int month, int year) {
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

    public boolean ninetyDays(Date day2) {
        int subY = (day2.getYear() - this.getYear()) * 12;
        return (day2.getDay() - this.getDay()) + (day2.getMonth() + subY  - this.getMonth()) * 30 > 90;
    }
}

