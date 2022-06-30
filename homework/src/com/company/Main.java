package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


class Zachet {
    private boolean success;
    private String nameOfExam;
    String nameOfTeacher;

    public Zachet(boolean success, String nameOfTeacher, String nameOfExam) {
        this.success = success;
        this.nameOfExam = nameOfExam;
        this.nameOfTeacher = nameOfTeacher;
    }
}


class Examen {
    private int score;
    private String nameOfExam;
    private String nameOfTeacher;
    public Examen(int score, String nameOfTeacher, String nameOfExam) {
        this.nameOfExam = nameOfExam;
        this.score = score;
        this.nameOfTeacher = nameOfTeacher;
    }
}



class examStatement {
    private String nameOfTeacher;
    private String nameOfExam;
    private int numOfGroup;
    private int countGroup;
    private ArrayList<Integer> scores;
    private ArrayList<String> surnames;
    public examStatement(Scanner sc1) {
        nameOfTeacher = sc1.next();
        nameOfExam = sc1.next();
        numOfGroup = sc1.nextInt();
        countGroup = sc1.nextInt();
        this.scores = new ArrayList<>();
        this.surnames = new ArrayList<>();
        int count = 0;
        while (count < countGroup) {
            surnames.add(sc1.next());
            scores.add(sc1.nextInt());
            count += 1;
        }
    }
    public String getNameOfTeacher() {
        return this.nameOfTeacher;
    }
    public ArrayList<String> getSurnames() {
        return this.surnames;
    }
    public ArrayList<Integer> getScores() {
        return this.scores;
    }
    public String getNameOfExam() {
        return this.nameOfExam;
    }
}


class zachetStatement {
    private String nameOfTeacher;
    private String nameOfZachet;
    private int numOfGroup;
    private int countGroup;
    private ArrayList<Boolean> successes;
    private ArrayList<String> surnames;
    public zachetStatement(Scanner sc1) {
        nameOfZachet = sc1.next();
        nameOfTeacher = sc1.next();
        numOfGroup = sc1.nextInt();
        countGroup = sc1.nextInt();
        this.successes = new ArrayList<>();
        this.surnames = new ArrayList<>();
        int count = 0;
        while (count < countGroup) {
            surnames.add(sc1.next());
            String suc = sc1.next();
            if (suc.equals("+")) {
                successes.add(Boolean.TRUE);
            }
            else {
                successes.add(Boolean.FALSE);
            }
            count += 1;
        }
    }
    public ArrayList<String> getSurnames() {
        return this.surnames;
    }
    public ArrayList<Boolean> getSuccesses() {
        return this.successes;
    }
    public String getNameOfZachet() {
        return this.nameOfZachet;
    }
    public String getNameOfTeacher() {
        return this.nameOfTeacher;
    }
}


class Session {
    private int countExam;
    private int countZachet;
    private ArrayList<zachetStatement> zachets;
    private ArrayList<examStatement> examens;
    public Session(Scanner sc1) {
        this.countExam = sc1.nextInt();
        this.countZachet = sc1.nextInt();
        this.zachets = new ArrayList();
        this.examens = new ArrayList();
        for (int i = 0; i < countExam; i++)  {
            examens.add(new examStatement(sc1));
        }
        for (int i = 0; i < countZachet; i++)  {
            zachets.add(new zachetStatement(sc1));
        }
    }
    public ArrayList<zachetStatement> getZachets()  {
        return this.zachets;
    }
    public ArrayList<examStatement> getExamens()  {
        return this.examens;
    }
}


class Zachet_book {
    private String studentName;
    private int numberOfBook;
    private int start_of_education;
    private int currentSem;
    private ArrayList<Zachet> zachts;
    private ArrayList<Examen> examens;
    private ArrayList<Session> sessions;
    public Zachet_book(Scanner s) throws FileNotFoundException {
        zachts = new ArrayList<>();
        examens = new ArrayList<>();
        sessions = new ArrayList<>();
        for (int i = 0; i < currentSem; i++) {
            sessions.add(new Session(s));
        }
        for (Session session : sessions)  {
            for (zachetStatement z : session.getZachets()) {
                int index = z.getSurnames().indexOf(studentName);
                zachts.add(new Zachet(z.getSuccesses().get(index),
                        z.getNameOfTeacher(), z.getNameOfZachet()));
            }
            for (examStatement z : session.getExamens()) {
                int index = z.getSurnames().indexOf(studentName);
                examens.add(new Examen(z.getScores().get(index),
                        z.getNameOfTeacher(), z.getNameOfExam()));
            }
        }
    }
}
class Group {
    private int groupCount;
    private ArrayList<String> surnames;
    private ArrayList<Integer> numsOfZachs;
    private int group;
    private int startOfEducation;
    private int currentSem;
    public Group(FileReader filename) throws FileNotFoundException {
        Scanner sc1 = new Scanner(filename);
        surnames = new ArrayList<>();
        numsOfZachs = new ArrayList<>();
        this.groupCount = sc1.nextInt();
        this.group = sc1.nextInt();
        this.currentSem = sc1.nextInt();
        if (this.groupCount != 0) {
            for (int i = 0; i < this.groupCount; i++) {
                surnames.add(sc1.next());
                numsOfZachs.add(sc1.nextInt());
            }
        }
    }
    public int getGroupCount() {
        return this.groupCount;
    }
    public int getGroup() {
        return this.group;
    }
    public int getCurrent() {
        return this.currentSem;
    }
    public String getSurname(int index) {
        return this.surnames.get(index);
    }
    public int getNumOfZach(int index) {
        return this.numsOfZachs.get(index);
    }

}

class Student {
    private String surname;
    private int group;
    private int course;
    private Zachet_book zachetka;
    public Student(String name, int group, int course, int numZ, FileReader sessions) throws FileNotFoundException {
        Scanner sc1 = new Scanner(sessions);
        this.surname = sc1.next();
        this.group = group;
        this.course = course;
        this.zachetka = new Zachet_book(sc1);
    }
}

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader file_sessions = new FileReader("sessions.txt");
        FileReader file_surnames = new FileReader("students.txt");
        Scanner surnames_scanner = new Scanner("students.txt");
        Scanner sessions_scanner = new Scanner("sessions.txt");
        ArrayList<Student> students = new ArrayList();
        Group myGroup = new Group(file_surnames);
        for (int i = 0; i < myGroup.getGroupCount(); i++) {
            students.add(new Student(myGroup.getSurname(i),
                    myGroup.getGroup(), myGroup.getCurrent(),
                    myGroup.getNumOfZach(i), file_sessions));
        }
    }
}
