package com.company;

public class Qa {
    private int qa_id;
    private String qa_surname;
    private String qa_name;

    public Qa(int qa_id, String qa_surname, String qa_name) {
        this.qa_id = qa_id;
        this.qa_surname = qa_surname;
        this.qa_name = qa_name;
    }

    public int getQa_id() {
        return qa_id;
    }

    public void setQa_id(int qa_id) {
        this.qa_id = qa_id;
    }

    public String getQa_surname() {
        return qa_surname;
    }

    public void setQa_surname(String qa_surname) {
        this.qa_surname = qa_surname;
    }

    public String getQa_name() {
        return qa_name;
    }

    public void setQa_name(String qa_name) {
        this.qa_name = qa_name;
    }
}
