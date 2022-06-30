package com.company;

public class Rule {
    private String priority;
    private int days;
    private int bonus;

    public Rule(String priority, int days, int bonus) {
        this.priority = priority;
        this.days = days;
        this.bonus = bonus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
