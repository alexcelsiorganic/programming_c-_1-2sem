package com.company;

public class Request {
    private int request_id;
    private int empl_id;
    private int daysoff_id;
    private int days;

    public Request(int request_id, int empl_id, int daysoff_id, int days) {
        this.request_id = request_id;
        this.empl_id = empl_id;
        this.daysoff_id = daysoff_id;
        this.days = days;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public int getDaysoff_id() {
        return daysoff_id;
    }

    public void setDaysoff_id(int daysoff_id) {
        this.daysoff_id = daysoff_id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return request_id + ";" + empl_id + ";" + daysoff_id + ";" + days;
    }
}
