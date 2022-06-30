package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;


public class Main {
    public static ArrayList<Bag> readBags(FileReader file1) {
        Scanner sc1 = new Scanner(file1);
        ArrayList<Bag> bags = new ArrayList<>();
        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            String[] words = line.split(";");
            String[] date = words[4].split("\\.");
            bags.add(new Bag(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                    words[2], Integer.parseInt(words[3]), new Date(date)));
        }
        return bags;
    }


    public static ArrayList<Priority> readPriorities(FileReader file4) {
        Scanner sc4 = new Scanner(file4);
        ArrayList<Priority> priorities = new ArrayList<>();
        while (sc4.hasNextLine()) {
            String line = sc4.nextLine();
            String[] words = line.split(";");
            priorities.add(new Priority(Integer.parseInt(words[0]), words[1], priorities.size() + 1));
        }
        return priorities;
    }


    public static ArrayList<Information> readInformation(FileReader file3) {
        Scanner sc4 = new Scanner(file3);
        ArrayList<Information> information = new ArrayList<>();
        Scanner sc3 = new Scanner(file3);
        while (sc3.hasNextLine()) {
            String line = sc3.nextLine();
            String[] words = line.split(";");
            information.add(new Information(Integer.parseInt(words[0]), Integer.parseInt(words[1])));
        }
        return information;
    }


    public static void firstTask(ArrayList<Bag> bags, ArrayList<Priority> priorities, String priority) {
        int searchable_id = 0;
        for (Priority i : priorities) {
            if (i.getPriority().equals(priority)) {
                searchable_id = i.getPriority_id();
            }
        }
        for (Bag i : bags) {
            if (i.getPriority_id() == searchable_id) {
                System.out.println(i.getBug_title());
            }
        }
    }


    public static String SearchPriority(int priority_id, ArrayList<Priority> priorities) {
        for (Priority i : priorities) {
            if (i.getPriority_id() == priority_id) {
                return i.getPriority();
            }
        }
        return "";
    }

    public static Priority SPriority(int priority_id, ArrayList<Priority> priorities) {
        for (Priority i : priorities) {
            if (i.getPriority_id() == priority_id) {
                return i;
            }
        }
        return null;
    }

    public static void secondTask(ArrayList<Bag> bags, ArrayList<Priority> priorities) {
        Collections.sort(bags, new Comparator<Bag>() {
            @Override
            public int compare(Bag o1, Bag o2) {
                return Integer.compare(SPriority(o1.getPriority_id(), priorities).getWeight(), SPriority(o2.getPriority_id(), priorities).getWeight());
            }
        });
        for (Bag i : bags) {
            System.out.println(i.getBug_title() + ";" + SearchPriority(i.getPriority_id(), priorities));
        }
    }


    public static void SearchBugTitle(int bug_id, ArrayList<Bag> bags) {
        for (Bag j : bags) {
            if (j.getBug_id() == bug_id) {
                System.out.println(j.getBug_title());
            }
        }
    }


    public static void thirdTask(ArrayList<Information> information, int searchable_qa, ArrayList<Bag> bags) {
        for (Information i : information) {
            if (i.getQa_id() == searchable_qa) {
                SearchBugTitle(i.getBug_id(), bags);
            }
        }
    }


    public static Bag SearchBag(int searchable_bag_id, ArrayList<Bag> bags) {
        for (Bag i : bags) {
            if (i.getBug_id() == searchable_bag_id) {
                return i;
            }
        }
        return null;
    }


    public static ArrayList<Integer> SearchBugId(int qa_id, ArrayList<Information> information) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Information i : information) {
            if (i.getQa_id() == qa_id) {
                ids.add(i.getBug_id());
            }
        }
        return ids;
    }


    public static void fourthTask(int searchable_qa_id, ArrayList<Bag> bags, ArrayList<Information> information) {
        ArrayList<Bag> bags_qa = new ArrayList<>();
        ArrayList<Integer> ids = SearchBugId(searchable_qa_id, information);
        for (Integer i : ids) {
            for (Bag j : bags) {
                if (j.getBug_id() == i) {
                    bags_qa.add(j);
                }
            }
        }
        Collections.sort(bags_qa, new Comparator<Bag>() {
            @Override
            public int compare(Bag o1, Bag o2) {
                if (o1.getReport_date().getYear() != o2.getReport_date().getYear()) {
                    return Integer.compare(o2.getReport_date().getYear(), o1.getReport_date().getYear());
                }
                else if (o1.getReport_date().getMonth() != o2.getReport_date().getMonth()) {
                    return Integer.compare(o2.getReport_date().getMonth(), o1.getReport_date().getMonth());
                }
                else {
                    return Integer.compare(o2.getReport_date().getDay(), o1.getReport_date().getDay());
                }
            }
        });
        for (Bag i : bags_qa) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
	FileReader file_1 = new FileReader("input1.txt");
    FileReader file_2 = new FileReader("input2.txt");
    FileReader file_3 = new FileReader("input3.txt");
    FileReader file_4 = new FileReader("input4.txt");
    FileReader file_5 = new FileReader("input5.txt");
    FileReader file_6 = new FileReader("input6.txt");
    ArrayList<Bag> bags = readBags(file_1);
    ArrayList<Priority> priorities = readPriorities(file_4);
    ArrayList<Information> information = readInformation(file_3);
    Scanner sc5 = new Scanner(file_5);
    String searchable_priority = sc5.next();
   // firstTask(bags, priorities, searchable_priority);
    secondTask(bags, priorities);
//    Scanner sc6 = new Scanner(file_6);
//    int searchable_qa_id = sc6.nextInt();
//    thirdTask(information, searchable_qa_id, bags);
//    fourthTask(searchable_qa_id, bags, information);
    }
}
