package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class Zachet implements Serializable{
    private String success;
    private String nameOfExam;
    String nameOfTeacher;
    private int numberSession;


    public Zachet(String success, String nameOfTeacher, String nameOfExam, int num) {
        this.success = success;
        this.nameOfExam = nameOfExam;
        this.nameOfTeacher = nameOfTeacher;
        this.numberSession = num;
    }


    public String getSuccess() {
        return this.success;
    }


    public String toString() {
        return String.valueOf(this.numberSession) + '\n' +  this.nameOfExam + " " +  this.nameOfTeacher +  " " + String.valueOf(this.success) + '\n';
    }


    public int getNumberSession() {
        return this.numberSession;
    }
}


class Examen implements Serializable{
    private int score;
    private String nameOfExam;
    private String nameOfTeacher;
    private int numSession;


    public Examen(int score, String nameOfTeacher, String nameOfExam, int num) {
        this.nameOfExam = nameOfExam;
        this.score = score;
        this.nameOfTeacher = nameOfTeacher;
        this.numSession = num;

    }


    public String toString() {
        return  String.valueOf(this.numSession) + '\n' + this.nameOfExam + " " +  this.nameOfTeacher +  " " + String.valueOf(this.score) + '\n';
    }


    public int getScore() {
        return this.score;
    }


    public int getNumSession() {
        return this.numSession;
    }
}



class examStatement implements Serializable{
    private int numOfSession;
    private String nameOfTeacher;
    private String nameOfExam;
    private int numOfGroup;
    private int countGroup;
    private ArrayList<Integer> scores;
    private ArrayList<String> surnames;


    public examStatement(File filename) throws FileNotFoundException {
        Scanner sc1 = new Scanner(filename);
        this.numOfSession = sc1.nextInt();
        this.nameOfTeacher = sc1.next();
        this.nameOfExam = sc1.next();
        this.numOfGroup = sc1.nextInt();
        this.countGroup = sc1.nextInt();
        this.scores = new ArrayList<>();
        this.surnames = new ArrayList<>();
        for (int i = 0; i < countGroup; i++) {
            surnames.add(sc1.next());
            scores.add(sc1.nextInt());
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


class zachetStatement implements Serializable {
    private int numOfSession;
    private String nameOfTeacher;
    private String nameOfZachet;
    private int numOfGroup;
    private int countGroup;
    private ArrayList<String> successes;
    private ArrayList<String> surnames;


    public zachetStatement(Scanner sc1) {
        this.numOfSession = sc1.nextInt();
        this.nameOfTeacher = sc1.next();
        this.nameOfZachet = sc1.next();
        this.numOfGroup = sc1.nextInt();
        this.countGroup = sc1.nextInt();
        this.successes = new ArrayList<>();
        this.surnames = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < countGroup; i++) {
            surnames.add(sc1.next());
            String suc = sc1.next();
            if (suc.equals("+")) {
                successes.add("зачтено");
            }
            else {
                successes.add("не зачтено");
            }
        }
    }


    public ArrayList<String> getSurnames() {
        return this.surnames;
    }


    public ArrayList<String> getSuccesses() {
        return this.successes;
    }


    public String getNameOfZachet() {
        return this.nameOfZachet;
    }


    public String getNameOfTeacher() {
        return this.nameOfTeacher;
    }
}


class Session implements Serializable {
    private int numSession;
    private ArrayList<zachetStatement> zachets;
    private ArrayList<examStatement> examens;


    public Session() {
        this.zachets = new ArrayList();
        this.examens = new ArrayList();
    }


    public ArrayList<zachetStatement> getZachets()  {
        return this.zachets;
    }


    public ArrayList<examStatement> getExamens()  {
        return this.examens;
    }
}


class Zachet_book  implements Serializable {
    private String studentName;
    private int numberOfBook;
    private int start_of_education;
    private ArrayList<Zachet> zachts;
    private ArrayList<Examen> examens;
    private ArrayList<Session> sessions;


    public void addExamStatement(int numSession, File filename) throws FileNotFoundException {
        Scanner sc1 = new Scanner(filename);
        examStatement ex = new examStatement(filename);
        sessions.get(numSession).getExamens().add(ex);
        int index = ex.getSurnames().indexOf(studentName);
        this.examens.add(new Examen(ex.getScores().get(index),
                ex.getNameOfTeacher(), ex.getNameOfExam(), numSession));
        Collections.sort(this.examens, new Comparator<Examen>() {
                    @Override
                    public int compare(Examen o1, Examen o2) {
                        return o1.getNumSession() - o2.getNumSession();
                    }
                });
                sc1.close();
    }


    public void addZachetStatement(int numSession, File filename) throws FileNotFoundException {
        Scanner sc1 = new Scanner(filename);
        zachetStatement z = new zachetStatement(sc1);
        sessions.get(numSession).getZachets().add(z);
        int index = z.getSurnames().indexOf(studentName);
        this.zachts.add(new Zachet(z.getSuccesses().get(index),
                z.getNameOfTeacher(), z.getNameOfZachet(), numSession));
        Collections.sort(this.zachts, new Comparator<Zachet>() {
            @Override
            public int compare(Zachet o1, Zachet o2) {
                return o1.getNumberSession() - o2.getNumberSession();
            }
        });
        sc1.close();
    }


    public Zachet_book(String studentName, int numberOfBook) throws IOException {
        this.studentName = studentName;
        this.numberOfBook = numberOfBook;
        zachts = new ArrayList<>();
        examens = new ArrayList<>();
        sessions = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            sessions.add(new Session());
        }
    }


    public boolean checkRedDiploma() {
        for (Zachet z : this.zachts) {
            if (z.getSuccess().equals("не зачтено")) {
                return false;
            }
        }
        for (Examen z : this.examens) {
            if (z.getScore() <= 8) {
                return false;
            }
        }
        return true;
    }


    public ArrayList<Examen> getExamens() {
        return this.examens;
    }


    public ArrayList<Zachet> getZachets() {
        return this.zachts;
    }


    public int getNumberOfBook() {
        return numberOfBook;
    }


    @Override
    public String toString() {
        StringBuilder all = new StringBuilder("");
        for (Zachet z : this.zachts) {
            all.append(z.toString());
        }
        for (Examen z : this.examens) {
            all.append(z.toString());
        }
        return String.valueOf(this.numberOfBook) + '\n' +  all.toString() + '\n';

    }
}


class StudentList implements Serializable {
    private int groupCount;
    private ArrayList<String> surnames;
    private ArrayList<Integer> numsOfZachs;
    private ArrayList<Integer> groups;
    private ArrayList<Integer> courses;



    public StudentList(FileReader filename) throws FileNotFoundException {
        Scanner sc1 = new Scanner(filename);
        surnames = new ArrayList<>();
        numsOfZachs = new ArrayList<>();
        groups = new ArrayList<>();
        courses = new ArrayList<>();
        if (!filename.equals(null)) {
            while(sc1.hasNextLine()) {
                surnames.add(sc1.next());
                groups.add(sc1.nextInt());
                numsOfZachs.add(sc1.nextInt());
                courses.add(sc1.nextInt());
            }
        }
        else {
            System.out.println("Students not found");
        }
    }


    public int getGroupCount() {
        return this.surnames.size();
    }


    public int getCourse(int index) {
        return this.courses.get(index);
    }


    public int getGroup(int index) {
        return this.groups.get(index);
    }


    public String getSurname(int index) {
        return this.surnames.get(index);
    }


    public int getNumOfZach(int index) {
        return this.numsOfZachs.get(index);
    }

}


class Student implements Serializable{
    private String surname;
    private int group;
    private int course;
    private Zachet_book zachetka;


    public Student(String name, int group, int course, int numZ) throws IOException {
        this.surname = name;
        this.group = group;
        this.course = course;
        this.zachetka = new Zachet_book(name, numZ);
    }


    public Zachet_book getZachetka() {
        return this.zachetka;
    }


    public String getSurname() {
        return this.surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public int getGroup() {
        return this.group;
    }


    public int returnAverage() {
        if (this.zachetka.getExamens().size() != 0) {
            int sum = 0;
            for (Examen e : this.zachetka.getExamens()) {
                sum += e.getScore();
            }
            return (sum / this.zachetka.getExamens().size());
        }
        else {
            return -1;
        }
    }


    public boolean wasFailure() {
        if (this.zachetka.getZachets().size() != 0) {
            for (Zachet e : this.zachetka.getZachets()) {
                if (e.getSuccess().equals("не зачтено")) {
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }


    public boolean redDiploma() {
        if (this.getZachetka().checkRedDiploma()) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return this.surname + " " + String.valueOf(this.group) + " " + this.zachetka.toString();
    }
}



public class Main extends JFrame {
    private ArrayList<Student> students;


    public Main(String title, ArrayList<Student> students) {
        super(title);
        this.students = students;
        Container c = getContentPane();
        JTextField tf = new JTextField("",50);
        c.add(tf, BorderLayout.NORTH);
//        JTextField tf2 = new JTextField("");
//        tf2.setBounds(500, 5, 50, 20);
//        c.add(tf2);
        JTextArea ta = new JTextArea(10,10);
        ta.setLineWrap (true);
        ta.setWrapStyleWord (true);
        ta.setEditable(false);
        c.add(ta);
        JPanel p = new JPanel();
        c.add(p, BorderLayout.SOUTH);
        JButton b_1 = new JButton("Добавить экзаменнационную ведомость");
        ActionListener actionListener_1 = new B1ActionListener(this.students, tf, ta);
        b_1.addActionListener(actionListener_1);
        JButton b_2 = new JButton("Добавить зачетную ведомость");
        ActionListener actionListener_2 = new B2ActionListener(this.students, tf, ta);
        b_2.addActionListener(actionListener_2);
        JButton b_3 = new JButton("Может ли претендовать на красный диплом");
        ActionListener actionListener_3 = new B3ActionListener(this.students, tf, ta);
        b_3.addActionListener(actionListener_3);
        JButton b_4 = new JButton("Отобразить");
        ActionListener actionListener_4 = new B4ActionListener(tf, ta, students);
        b_4.addActionListener(actionListener_4);
        JButton b_5  = new JButton("Вычислить средний балл по группе №: ");
        ActionListener actionListener_5 = new B5ActionListener(this.students, tf, ta);
        b_5.addActionListener(actionListener_5);
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(b_4);
        p.add(b_5);
        setSize(1000,1000);
        setVisible(true);
    }




    public class B1ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Student> sts;


        B1ActionListener(ArrayList<Student> students, JTextField tf, JTextArea ta) {
            sts = students;
            this.tf = tf;
            this.ta = ta;
        }


        public static void SaveSer(ArrayList<Student> students) throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream("output.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Student a : students) {
                objectOutputStream.writeObject(a);
            }
        }

        public void actionPerformed(ActionEvent e) {
            this.ta.setText("");
            String filename = tf.getText();
            File file = new File(filename);
            Scanner sc1 = null;
            try {
                sc1 = new Scanner(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            int numSession = sc1.nextInt();
            String name = sc1.next();
            String pr = sc1.next();
            int numGroup = sc1.nextInt();
            for (Student dude : this.sts) {
                try {
                    if (dude.getGroup() == numGroup) {
                        dude.getZachetka().addExamStatement(numSession, file);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                SaveSer(sts);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            for (Student dude : this.sts) {
//                ta.append(dude.toString());
//            }
        }
    }


    public class B2ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Student> sts;


        B2ActionListener(ArrayList<Student> students, JTextField tf, JTextArea ta) {
            sts = students;
            this.tf = tf;
            this.ta = ta;
        }

        public static void SaveSer(ArrayList<Student> students) throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream("output.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Student a : students) {
                objectOutputStream.writeObject(a);
            }
        }

        public void actionPerformed(ActionEvent e) {
            this.ta.setText("");
            String filename = tf.getText();
            File file = new File(filename);
            Scanner sc1 = null;
            try {
                sc1 = new Scanner(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            int numSession = sc1.nextInt();
            String name = sc1.next();
            String pr = sc1.next();
            int numGroup = sc1.nextInt();
            for (Student dude : this.sts) {
                try {
                    if (dude.getGroup() == numGroup) {
                        dude.getZachetka().addZachetStatement(numSession, new File(filename));
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                SaveSer(sts);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            for (Student dude : this.sts) {
//                ta.append(dude.toString());
//            }
        }
    }


    public class B3ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Student> sts;


        B3ActionListener(ArrayList<Student> students, JTextField tf, JTextArea ta) {
            sts = students;
            this.tf = tf;
            this.ta = ta;
        }


        public void actionPerformed(ActionEvent e) {
            ta.setText("");
            for (Student dude : sts) {
                if (dude.getZachetka().getNumberOfBook() == Integer.parseInt(tf.getText())) {
                    if (dude.redDiploma()) {
                        ta.setText("Yes");
                    }
                    else {
                        ta.setText("No");
                    }
                }
            }
        }
    }


    public class B4ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Student> sts;

        B4ActionListener(JTextField tf, JTextArea ta, ArrayList<Student> a) {
            this.tf = tf;
            this.ta = ta;
            sts = a;
        }


        public void actionPerformed(ActionEvent e) {
            this.ta.setText("");
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("output.dat");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            int counter = 0;
            ArrayList<Student> dudes = new ArrayList<>();
            while(counter < sts.size()) {
                try {
                    dudes.add((Student)objectInputStream.readObject());
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                counter += 1;
            }

            for (Student dude : dudes) {
                ta.append(dude.toString());
            }
        }
    }

    public class B5ActionListener implements ActionListener {
        private JTextField tf1;
        private JTextArea ta;
        private ArrayList<Student> sts;


        public static ArrayList<Integer> groupAverage(int numGroup, ArrayList<Student> students) {
            ArrayList<Integer> answer = new ArrayList<>();
            for (Student s : students) {
                if (s.getGroup() == numGroup) {
                    answer.add(s.returnAverage());
                }
                System.out.println("A");
            }
            return answer;
        }

        B5ActionListener(ArrayList<Student> students, JTextField tf, JTextArea ta) {
            sts = students;
            this.tf1 = tf;
            this.ta = ta;
        }


        public void actionPerformed(ActionEvent e) {
            int numGroup = Integer.parseInt(this.tf1.getText());
            this.ta.setText("");
            ArrayList<Integer> groupAvg = new ArrayList<>();
            groupAvg = groupAverage(numGroup, sts);
            for (Integer item : groupAvg) {
                ta.append(String.valueOf(item) + " ");
            }
        }
    }




    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileReader file_surnames = new FileReader("students.txt");

        FileInputStream fileInputStream = new FileInputStream("output.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Student> students = new ArrayList<Student>();
        StudentList myList = new StudentList(file_surnames);
        for (int i = 0; i < myList.getGroupCount(); i++) {
            students.add(new Student(myList.getSurname(i), myList.getGroup(i),
                    myList.getCourse(i), myList.getNumOfZach(i)));
        }

        JFrame f = new Main("MyNote", students);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
