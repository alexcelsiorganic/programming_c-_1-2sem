package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class Main {
    public static ArrayList<Vacancy> firstTask(FileReader file1) {
        Scanner sc_file1 = new Scanner(file1);
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        while (sc_file1.hasNextLine()) {
            String line = sc_file1.nextLine();
            String[] words = line.split(";");
            vacancies.add(new Vacancy(Integer.parseInt(words[0]), words[1], words[2], words[3]));
        }
        Collections.sort(vacancies, new Comparator<Vacancy>() {
            @Override
            public int compare(Vacancy o1, Vacancy o2) {
                return o1.getPriority().compareTo(o2.getPriority());
            }
        });
        for (Vacancy i : vacancies) {
            System.out.println(i);
        }
        return vacancies;
    }
    public static boolean ninetyDays(MyDate date1) throws ParseException {
        MyDate today = new MyDate(17, 1, 2022);
        String str1 = date1.toString();
        String str2 = today.toString();
        Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(str1);
        Date endDate = new SimpleDateFormat("dd.MM.yyyy").parse(str2);
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTimeInMillis(startDate.getTime());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTimeInMillis(endDate.getTime());
        long difference = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
        long days = difference /(24* 60 * 60 * 1000);
        return (int)days > 90;
    }

    public static ArrayList<ArrayList<Vacancy_close>> secondTask(FileReader file4) throws ParseException {
        Scanner sc_file2 = new Scanner(file4);
        ArrayList<Vacancy_close> vacancies_closes = new ArrayList<>();
        while (sc_file2.hasNextLine()) {
            String line = sc_file2.nextLine();
            String[] words = line.split(";");
            String[] k = words[2].split("\\.");
            if (Integer.parseInt(k[0]) == 0) {
                String[] k_1 = words[1].split("\\.");
                MyDate date1 = new MyDate(k_1);
                vacancies_closes.add(new Vacancy_close(Integer.parseInt(words[0]),
                        date1, new MyDate(0, 0, 0), Integer.parseInt(words[3])));
            }
            else  {
                String[] k_1 = words[1].split("\\.");
                MyDate date1 = new MyDate(k_1);
                String[] k_2 = words[2].split("\\.");
                MyDate date2 = new MyDate(k_2);
                vacancies_closes.add(new Vacancy_close(Integer.parseInt(words[0]),
                        date1, date2, Integer.parseInt(words[3])));
                }
            }
        ArrayList<Vacancy_close> vacancies_failed = new ArrayList<>();
        for (Vacancy_close i : vacancies_closes) {
            if (ninetyDays(i.getData_open())) {
                vacancies_failed.add(i);
            }
            else if (i.getData_close().getDay() == 0) {
                vacancies_failed.add(i);
            }
        }
        Collections.sort(vacancies_failed, new Comparator<Vacancy_close>() {
            @Override
            public int compare(Vacancy_close o1, Vacancy_close o2) {
                return Integer.compare(o1.getVacancy_id(), o2.getVacancy_id());
            }
        });
        for (Vacancy_close i : vacancies_failed) {
            System.out.println(i);
        }
        ArrayList<ArrayList<Vacancy_close>> arr = new ArrayList<>();
        arr.add(vacancies_closes);
        arr.add(vacancies_failed);
        return arr;
    }
    public static Vacancy SearchVacancy(int vacancy_id, ArrayList<Vacancy> v) {
        for (Vacancy i : v) {
            if (vacancy_id == i.getVacancy_id()) {
                return i;
            }
        }
        return null;
    }
    public static Recruter SearchInRectuters(int recruter_id, ArrayList<Recruter> recturers) {
        for (Recruter i : recturers) {
            if (recruter_id == i.getRecruter_id()) {
                return i;
            }
        }
        return null;
    }
    public static Vacancy_close SearchInVacancies(int recruter_id, ArrayList<Vacancy_close> v) {
        for (Vacancy_close i : v) {
            if (recruter_id == i.getRecruter_id() && i.getData_close().getDay() != 0) {
                return i;
            }
        }
        return null;
    }
    public static void thirdTask(FileReader file2, ArrayList<Vacancy_close> vacancies_failed) {
        HashSet<Integer> ids = new HashSet<>();
        for (Vacancy_close i : vacancies_failed) {
            ids.add(i.getRecruter_id());
        }
        Scanner sc_file2 = new Scanner(file2);
        ArrayList<Recruter> recruters = new ArrayList<>();
        while (sc_file2.hasNextLine()) {
            String line = sc_file2.nextLine();
            String[] words = line.split(";");
            recruters.add(new Recruter(Integer.parseInt(words[0]), words[1], words[2]));
        }
        ArrayList<Recruter> failed_recruters = new ArrayList<>();
        for (Integer i : ids) {
            failed_recruters.add(SearchInRectuters(i, recruters));
        }
        Collections.sort(failed_recruters, new Comparator<Recruter>() {
            @Override
            public int compare(Recruter o1, Recruter o2) {
                return Integer.compare(o1.getRecruter_id(), o2.getRecruter_id());
            }
        });
        for (Recruter i : failed_recruters) {
            System.out.println(i);
        }
    }
    public static int SearchRule(String priority, int days, ArrayList<Rule> rules) {
        for (Rule rule : rules) {
            if (priority.equals(rule.getPriority()) && days <= rule.getDays()) {
                return rule.getBonus();
            }
        }
        return 0;
    }
    public static int subDays(MyDate date1, MyDate date2) throws ParseException {
        String str1 = date1.toString();
        String str2 = date2.toString();
        Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(str1);
        Date endDate = new SimpleDateFormat("dd.MM.yyyy").parse(str2);
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTimeInMillis(startDate.getTime());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTimeInMillis(endDate.getTime());
        long difference = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
        long days = difference /(24* 60 * 60 * 1000);
        return (int)days;
    }

     public static void fourthTask(FileReader file5, FileReader file3, ArrayList<Vacancy_close> v, ArrayList<Vacancy> vacs) throws ParseException {
        Scanner sc_file5 = new Scanner(file5);
        int searchable_recruter = sc_file5.nextInt();
        Scanner sc_file3 = new Scanner(file3);
        ArrayList<Rule> rules = new ArrayList<>();
        while (sc_file3.hasNextLine()) {
            String line = sc_file3.nextLine();
            String[] words = line.split(";");
            rules.add(new Rule(words[0], Integer.parseInt(words[1]),
                    Integer.parseInt(words[2])));
        }
        int sum = 0;
        while (SearchInVacancies(searchable_recruter, v) != null) {
            Vacancy_close founded = SearchInVacancies(searchable_recruter, v);
            int subD = subDays(founded.getData_open(), founded.getData_close());
            Vacancy vacancy = SearchVacancy(founded.getVacancy_id(), vacs);
            String priority = vacancy.getPriority();
            sum += SearchRule(priority, subD, rules);
            v.remove(founded);
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        FileReader file1 = new FileReader("input1.txt");
        FileReader file2 = new FileReader("input2.txt");
        FileReader file3 = new FileReader("input3.txt");
        FileReader file4 = new FileReader("input4.txt");
        FileReader file5 = new FileReader("input5.txt");


//        ArrayList<Vacancy> vacs = firstTask(file1);
        ArrayList<ArrayList<Vacancy_close>> v = secondTask(file4);
//        thirdTask(file2, v.get(1));
//        fourthTask(file5, file3, v.get(0), vacs);


    }
}

