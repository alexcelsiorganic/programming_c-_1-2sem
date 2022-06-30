package com.company;

import java.text.ParseException;

public class Employee {
    private int empl_id;
    private String empl_surname;
    private String empl_name;
    private MyDate start_date;
    private MyDate end_date;
    private int vacations_days;
    private int compensatory_days;

    public Employee(int empl_id, String empl_surname, String empl_name, MyDate start_date,
                    MyDate end_date, int vacations_days, int compensatory_days) {
        this.empl_id = empl_id;
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.vacations_days = vacations_days;
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

    public int getVacations_days() {
        return vacations_days;
    }

    public void setVacations_days(int vacations_days) {
        this.vacations_days = vacations_days;
    }

    public int getCompensatory_days() {
        return compensatory_days;
    }

    public void setCompensatory_days(int compensatory_days) {
        this.compensatory_days = compensatory_days;
    }
    public int getDays() throws ParseException {
        int days = start_date.subDays(end_date);
        return days;
    }
    @Override
    public String toString() {
        try {
            return empl_surname +";" + empl_name + ";" + this.getDays();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
