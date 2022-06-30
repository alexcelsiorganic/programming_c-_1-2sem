package com.company;

public class Information {
    private int bug_id;
    private int qa_id;

    public Information(int bug_id, int qa_id) {
        this.bug_id = bug_id;
        this.qa_id = qa_id;
    }

    public int getBug_id() {
        return bug_id;
    }

    public void setBug_id(int bug_id) {
        this.bug_id = bug_id;
    }

    public int getQa_id() {
        return qa_id;
    }

    public void setQa_id(int qa_id) {
        this.qa_id = qa_id;
    }
}
