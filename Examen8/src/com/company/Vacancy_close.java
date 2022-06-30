package com.company;

public class Vacancy_close {
    private int vacancy_id;
    private MyDate data_open;
    private MyDate data_close;
    private int recruter_id;
    public Vacancy_close(int vacancy_id, MyDate data_open, MyDate data_close, int recruter_id) {
        this.vacancy_id = vacancy_id;
        this.data_open = data_open;
        this.data_close = data_close;
        this.recruter_id = recruter_id;
    }

    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public MyDate getData_open() {
        return data_open;
    }

    public void setData_open(MyDate data_open) {
        this.data_open = data_open;
    }

    public MyDate getData_close() {
        return data_close;
    }

    public void setData_close(MyDate data_close) {
        this.data_close = data_close;
    }

    public int getRecruter_id() {
        return recruter_id;
    }

    public void setRecruter_id(int recruter_id) {
        this.recruter_id = recruter_id;
    }

    @Override
    public String toString() {
        return vacancy_id + ";" + data_open;
    }
}
