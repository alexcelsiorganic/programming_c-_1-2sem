package com.company;

public class Bag {
    private int bug_id;
    private int page;
    private String bug_title;
    private int priority_id;
    private Date report_date;


    public Bag(int bug_id, int page, String bug_title, int priority_id, Date report_date) {
        this.bug_id = bug_id;
        this.page = page;
        this.bug_title = bug_title;
        this.priority_id = priority_id;
        this.report_date = report_date;
    }

    public int getBug_id() {
        return bug_id;
    }

    public void setBug_id(int bug_id) {
        this.bug_id = bug_id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBug_title() {
        return bug_title;
    }

    public void setBug_title(String bug_title) {
        this.bug_title = bug_title;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bug_id=" + bug_id +
                ", page=" + page +
                ", bug_title='" + bug_title + '\'' +
                ", priority_id=" + priority_id +
                ", report_date=" + report_date +
                '}';
    }
}
