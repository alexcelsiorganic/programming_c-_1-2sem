package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;


public class Vacancy {
    private int vacancy_id;
    private String primary_skill;
    private String title;
    private String priority;

    public Vacancy(int vacancy_id, String primary_skill, String title, String priority) {
        this.vacancy_id = vacancy_id;
        this.primary_skill = primary_skill;
        this.title = title;
        this.priority = priority;
    }

    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public String getPrimary_skill() {
        return primary_skill;
    }

    public void setPrimary_skill(String primary_skill) {
        this.primary_skill = primary_skill;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return  vacancy_id + ";" + title + ";" + priority;
    }
}
