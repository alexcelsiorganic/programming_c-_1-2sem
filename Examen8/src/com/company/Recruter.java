package com.company;

public class Recruter {
    private int recruter_id;
    private String recruter_surname;
    private String recruter_name;

    public Recruter(int recruter_id, String recruter_surname, String recruter_name) {
        this.recruter_id = recruter_id;
        this.recruter_surname = recruter_surname;
        this.recruter_name = recruter_name;
    }

    public int getRecruter_id() {
        return recruter_id;
    }

    public void setRecruter_id(int recruter_id) {
        this.recruter_id = recruter_id;
    }

    public String getRecruter_surname() {
        return recruter_surname;
    }

    public void setRecruter_surname(String recruter_surname) {
        this.recruter_surname = recruter_surname;
    }

    public String getRecruter_name() {
        return recruter_name;
    }

    public void setRecruter_name(String recruter_name) {
        this.recruter_name = recruter_name;
    }

    @Override
    public String toString() {
        return recruter_surname + ";" + recruter_name;
    }
}
