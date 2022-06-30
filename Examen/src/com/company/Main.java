

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static ArrayList<Employee> readEmployees(File file) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        try (Scanner sc1 = new Scanner(new FileReader(file))) {
            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                String[] words = line.split(";");
                employees.add(new Employee(Integer.parseInt(words[0]),
                        words[1], words[2], words[3]));
            }
        }
        return employees;
    }

    public static ArrayList<Project> readProjects(File file) throws FileNotFoundException {
        ArrayList<Project> projects = new ArrayList<>();
        try (Scanner sc2 = new Scanner(new FileReader(file))) {
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                String[] words = line.split(";");
                projects.add(new Project(Integer.parseInt(words[0]), words[1]));
            }
        }
        return projects;
    }


    public static ArrayList<Position> readPositions(File file) throws FileNotFoundException {
        ArrayList<Position> positions = new ArrayList<>();
        try (Scanner sc3 = new Scanner(new FileReader(file))) {
            while (sc3.hasNextLine()) {
                String line = sc3.nextLine();
                String[] words = line.split(";");
                positions.add(new Position(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                        Integer.parseInt(words[2]), Integer.parseInt(words[3]), words[4]));
            }
        }
        return positions;
    }

    public static ArrayList<Open_Position> readOpen_Positions(File file) throws FileNotFoundException {
        ArrayList<Open_Position> open_positions = new ArrayList<>();
        try (Scanner sc4 = new Scanner(new FileReader(file))) {
            while (sc4.hasNextLine()) {
                String line = sc4.nextLine();
                String[] words = line.split(";");
                String[] date = words[2].split("\\.");
               open_positions.add(new Open_Position(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                        new MyDate(date)));
            }
        }
        return open_positions;
    }

    public static void firstTask(ArrayList<Employee> e, ArrayList<Position> p) throws IOException {
        FileWriter writer = new FileWriter("output1.txt");
        ArrayList<Employee> empls_work = new ArrayList<>();
        for (Employee i : e) {
            for (Position j : p) {
                if (j.getEmpl_id() == i.getEmpl_id()) {
                    int workload = i.getWorkload_sum() + j.getWorkload();
                    i.setWorkload_sum(workload);
                }
            }
            if (i.getWorkload_sum() > 100) {
                empls_work.add(i);
            }
        }
        Collections.sort(empls_work, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o2.getWorkload_sum(), o1.getWorkload_sum());
            }
        });

        if (empls_work.size() > 0) {
            writer.write(empls_work.get(0).getEmpl_id() + ";" + empls_work.get(0).getEmpl_surname()
                    + ";" + empls_work.get(0).getEmpl_name() + ";" + empls_work.get(0).getWorkload_sum());
        }
        for (int i = 1; i < empls_work.size(); i++) {
            writer.write("\n" +  empls_work.get(i).getEmpl_id() + ";" + empls_work.get(i).getEmpl_surname()
                    + ";" + empls_work.get(i).getEmpl_name() + ";" +empls_work.get(i).getWorkload_sum());
        }
        writer.close();
    }

    public static Employee SearchEmpl(int id, ArrayList<Employee> e) {
        for (Employee i : e) {
            if (i.getEmpl_id() == id) {
                return i;
            }
        }
        return null;
    }


    public static void secondTask(ArrayList<Employee> e, ArrayList<Position> p, int project_id) throws IOException {
        FileWriter writer = new FileWriter("output2.txt");
        ArrayList<Employee> empls = new ArrayList<>();
        for (Position i : p) {
            if (i.getPrject_id() == project_id) {
                empls.add(SearchEmpl(i.getEmpl_id(), e));
            }
        }
        Collections.sort(empls, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getEmpl_id(), o2.getEmpl_id());
            }
        });
        if (empls.size() > 0) {
            writer.write(empls.get(0).getEmpl_id() + ";" + empls.get(0).getEmpl_surname()
                    + ";" + empls.get(0).getEmpl_name());
        }
        for (int i = 1; i < empls.size(); i++) {
            writer.write("\n" +  empls.get(i).getEmpl_id() + ";" + empls.get(i).getEmpl_surname()
                    + ";" + empls.get(i).getEmpl_name());
        }
        writer.close();
    }

    public static Open_Position SearchOP(int project_id, ArrayList<Open_Position> o) {
    for (Open_Position i : o) {
        if (i.getProject_id() == project_id) {
            return i;
        }
    }
    return null;
    }

    public static Project SearchProject(int project_id, ArrayList<Project> o) {
        for (Project i : o) {
            if (i.getProject_id() == project_id) {
                return i;
            }
        }
        return null;
    }
    public static void thirdTask(ArrayList<Open_Position> op, int project_id, MyDate date1, MyDate date2, ArrayList<Project> p) throws IOException, ParseException {
        FileWriter writer = new FileWriter("output3.txt");
        ArrayList<Project> ps = new ArrayList<>();
        Project a = SearchProject(project_id, p);
        for (Open_Position i : op) {
            if (i.getProject_id() == project_id) {
                if (i.getOpen_date().subDay(date1) <= 0 && i.getOpen_date().subDay(date2) >= 0) {
                    a.setOpen_positions(a.getOpen_positions() + 1);
                }
            }
        }
        writer.write(a.getProject_title() + ";" + a.getOpen_positions());
        writer.close();
    }
   public static ArrayList<Integer> check4(Map<String, Integer> m, int[] a) {
        int counter = 0;
        boolean check = true;
        ArrayList<Integer> k = new ArrayList<>();
       for (Map.Entry<String, Integer> entry : m.entrySet()) {
           if (entry.getValue() > a[counter]) {
               check =  false;
               k.add(counter);
           }
           else {
               counter += 1;
           }
       }
       if (check == true) {
           return null;
       }
       else {
           return k;
       }
   }
    public static void fourthTask(ArrayList<Position> op, ArrayList<Employee> e, File file5) throws IOException, ParseException {
        FileWriter writer = new FileWriter("output4.txt");
        Scanner sc5 = new Scanner(file5);
        Map<String, Integer> req = new LinkedHashMap<>();
        while (sc5.hasNextLine()) {
            String line = sc5.nextLine();
            String[] words = line.split(";");
            req.put(words[0], Integer.parseInt(words[1]));
        }
        ArrayList<Position> non_billable = new ArrayList<>();
        for (Position i : op) {
            if (i.getBilling_type().equals("non-billable")) {
             non_billable.add(i);
            }
        }
        int[] workload = new int[req.size()];
        int counter = 0;
        for (Map.Entry<String, Integer> entry : req.entrySet()) {
            for (Position i : non_billable) {
                Employee emp = SearchEmpl(i.getEmpl_id(), e);
                if (emp.getSkill().equals(entry.getKey())) {
                    workload[counter] += i.getWorkload();
                }
            }
            counter += 1;
        }
        if (check4(req, workload) == null) {
            writer.write("Yes");
        }
        else {
            writer.write("No" + '\n');
            int counter_ = 0;
            for (Integer i : check4(req, workload)) {
                for (Map.Entry<String, Integer> entry : req.entrySet()) {
                    if (counter == i) {
                        writer.write(entry.getKey() + '\n');
                        break;
                    }
                        counter_++;
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException, ParseException {
        File file_1 = new File("input1.txt");
        ArrayList<Employee> employees = readEmployees(file_1);
        File file_2 = new File("input2.txt");
        ArrayList<Project> projects = readProjects(file_2);
        File file_3 = new File("input3.txt");
        ArrayList<Position> positions = readPositions(file_3);
        File file4 = new File("input4.txt");
        ArrayList<Open_Position> open_positions = readOpen_Positions(file4);
        FileReader file8 = new FileReader("input8.txt");
        firstTask(employees, positions);
        Scanner sc8 = new Scanner(file8);
        int project_id = sc8.nextInt();
        secondTask(employees, positions, project_id);
        FileReader file6 = new FileReader("input6.txt");
        Scanner sc6 = new Scanner(file6);
        String line = sc6.nextLine();
        String[] dates = line.split(";");
        MyDate date_1 = new MyDate(dates[0].split("\\."));
        MyDate date_2 = new MyDate(dates[1].split("\\."));
        FileReader file7 = new FileReader("input7.txt");
        Scanner sc7 = new Scanner(file7);
        int project3_id = sc7.nextInt();
        thirdTask(open_positions, project3_id, date_1, date_2, projects);
        File file_5 = new File("input5.txt");
        fourthTask(positions, employees, file_5);
    }
}
