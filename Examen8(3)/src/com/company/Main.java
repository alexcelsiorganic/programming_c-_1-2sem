package com.company;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void firstTask(ArrayList<Employee> e, ArrayList<Request> r) {
        ArrayList<Request> vacations  = new ArrayList<>();
        for (Request i : r) {
            if (i.getDaysoff_id() == 1) {
                vacations.add(i);
            }
        }
        for (Request i : vacations) {
            for (Employee j : e) {
                if (i.getEmpl_id() == j.getEmpl_id()) {
                    if (i.getDays() > j.getVacations_days()) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
    public static void secondTask(ArrayList<Employee> e, int vac_days) {
        ArrayList<Employee> lot_days = new ArrayList<>();
        for (Employee i : e) {
            if (i.getVacations_days() >= vac_days) {
                lot_days.add(i);
            }
        }
        Collections.sort(lot_days, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getEmpl_surname().compareTo(o2.getEmpl_surname());
            }
        });
        for (Employee i : lot_days) {
            System.out.println(i);
        }
    }
    public static void thirdTask(ArrayList<Employee> e) {
        Collections.sort(e, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                try {
                    if (o1.getDays() != o2.getDays()) {
                        return Integer.compare(o2.getDays(), o1.getDays());
                    }
                    else {
                        return o1.getEmpl_surname().compareTo(o2.getEmpl_surname());
                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                return 0;
            }
        });
        for (Employee i : e) {
            System.out.println(i);
        }
    }
    public static int subMonth(MyDate date1, MyDate date2) {
        String str1 = date1.toString();
        String str2 = date2.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(str1, formatter);
        LocalDate endDate = LocalDate.parse(str2, formatter);
        Period period = Period.between(startDate, endDate);
        return period.getMonths();
    }
    public static void fourthTask(ArrayList<Employee> e, int id) {
       int sum = 0;
       for (Employee i : e) {
           if (i.getEmpl_id() == id) {
                int sDays = subMonth(new MyDate(19, 1, 2022), i.getEnd_date()) * 2;
                int comp_days = i.getCompensatory_days() - sDays;
                if (comp_days >= 0) {
                    System.out.println(comp_days);
                }
                else {
                    System.out.println(-1);
                }
           }
       }
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file1 = new FileReader("input1.txt");
        FileReader file2 = new FileReader("input2.txt");
        FileReader file3 = new FileReader("input3.txt");
        FileReader file4 = new FileReader("input4.txt");
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc1 = new Scanner(file1);
        while(sc1.hasNextLine()) {
            String line = sc1.nextLine();
            String[] words = line.split(";");
            String[] date_1 = words[3].split("\\.");
            String[] date_2 = words[4].split("\\.");
            employees.add(new Employee(Integer.parseInt(words[0]), words[1], words[2], new MyDate(date_1),
                    new MyDate(date_2), Integer.parseInt(words[5]), Integer.parseInt(words[6])));
        }
        ArrayList<Request> requests = new ArrayList<>();
        Scanner sc2 = new Scanner(file2);
        while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            String[] words = line.split(";");
            requests.add(new Request(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                    Integer.parseInt(words[2]), Integer.parseInt(words[3])));
        }
        firstTask(employees, requests);
        Scanner sc3 = new Scanner(file3);
        int vac_days = sc3.nextInt();
        secondTask(employees, vac_days);
        thirdTask(employees);
        Scanner sc4 = new Scanner(file4);
        int id = sc4.nextInt();
        fourthTask(employees, id);
    }
}
