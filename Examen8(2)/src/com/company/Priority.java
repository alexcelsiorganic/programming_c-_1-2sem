package com.company;

public class Priority {
    private int priority_id;
    private String priority;
    private int weight;


    public Priority(int priority_id, String priority, int weight) {
        this.priority_id = priority_id;
        this.priority = priority;
        this.weight = weight;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
