
public class Open_Position {
   private int  project_id;
   private int position_id;
   private MyDate open_date;

    public Open_Position(int project_id, int position_id, MyDate open_date) {
        this.project_id = project_id;
        this.position_id = position_id;
        this.open_date = open_date;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public MyDate getOpen_date() {
        return open_date;
    }

    public void setOpen_date(MyDate open_date) {
        this.open_date = open_date;
    }

    @Override
    public String toString() {
        return "Open_Position{" +
                "project_id=" + project_id +
                ", position_id=" + position_id +
                ", open_date=" + open_date +
                '}';
    }
}
