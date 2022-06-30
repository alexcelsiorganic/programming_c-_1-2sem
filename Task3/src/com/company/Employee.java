package com.company;

public class Employee {
    private int empl_id;
    private String empl_surname;
    private String empl_name;
    private MyDate start_date;
    private MyDate end_date;
    private int vacation_days;
    private int compensatory_days;

    public Employee(int empl_id, String empl_surname, String empl_name, MyDate start_date,
                    MyDate end_date, int vacation_days, int compensatory_days) {
        this.empl_id = empl_id;
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.vacation_days = vacation_days;
        this.compensatory_days = compensatory_days;
    }

    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public String getEmpl_surname() {
        return empl_surname;
    }

    public void setEmpl_surname(String empl_surname) {
        this.empl_surname = empl_surname;
    }

    public String getEmpl_name() {
        return empl_name;
    }

    public void setEmpl_name(String empl_name) {
        this.empl_name = empl_name;
    }

    public MyDate getStart_date() {
        return start_date;
    }

    public void setStart_date(MyDate start_date) {
        this.start_date = start_date;
    }

    public MyDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(MyDate end_date) {
        this.end_date = end_date;
    }

    public int getVacation_days() {
        return vacation_days;
    }

    public void setVacation_days(int vacation_days) {
        this.vacation_days = vacation_days;
    }

    public int getCompensatory_days() {
        return compensatory_days;
    }

    public void setCompensatory_days(int compensatory_days) {
        this.compensatory_days = compensatory_days;
    }

    @Override
    public String toString() {
        return empl_id +
                ";" + empl_surname +
                ";" + empl_name +
                ";" + start_date +
                ";" + end_date +
                ";" + vacation_days +
                ";" + compensatory_days;
    }
}
