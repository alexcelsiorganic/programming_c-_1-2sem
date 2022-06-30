
public class Position {

   private int  position_id;
   private int prject_id;
   private int empl_id;
   private int workload;
   private String billing_type;

    public Position(int position_id, int prject_id, int empl_id, int workload, String billing_type) {
        this.position_id = position_id;
        this.prject_id = prject_id;
        this.empl_id = empl_id;
        this.workload = workload;
        this.billing_type = billing_type;
    }



    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getPrject_id() {
        return prject_id;
    }

    public void setPrject_id(int prject_id) {
        this.prject_id = prject_id;
    }

    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String getBilling_type() {
        return billing_type;
    }

    public void setBilling_type(String billing_type) {
        this.billing_type = billing_type;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position_id=" + position_id +
                ", prject_id=" + prject_id +
                ", empl_id=" + empl_id +
                ", workload=" + workload +
                ", billing_type='" + billing_type + '\'' +
                '}';
    }
}
