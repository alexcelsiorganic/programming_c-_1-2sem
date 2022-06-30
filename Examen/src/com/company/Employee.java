

public class Employee {
    private int empl_id;
    private String empl_surname;
    private String empl_name;
    private String skill;
    private int workload_sum;

    public Employee(int empl_id, String empl_surname, String empl_name, String skill) {
        this.empl_id = empl_id;
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.skill = skill;
        this.workload_sum = 0;
    }


    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public int getWorkload_sum() {
        return workload_sum;
    }

    public void setWorkload_sum(int workload_sum) {
        this.workload_sum = workload_sum;
    }

    public String getEmpl_surname() {
        return empl_surname;
    }

    public void setEmpl_surname(String empl_surname) {
        this.empl_surname = empl_surname;
    }

    public String getEmpl_name() {
        return empl_name;
    }

    public void setEmpl_name(String empl_name) {
        this.empl_name = empl_name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empl_id=" + empl_id +
                ", empl_surname='" + empl_surname + '\'' +
                ", empl_name='" + empl_name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
