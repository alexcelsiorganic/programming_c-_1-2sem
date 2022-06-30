

public class Project {
    private int project_id;
    private String project_title;
    private int open_positions;

    public Project(int project_id, String project_title) {
        this.project_id = project_id;
        this.project_title = project_title;
        this.open_positions = 0;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public int getOpen_positions() {
        return open_positions;
    }

    public void setOpen_positions(int open_positions) {
        this.open_positions = open_positions;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_title='" + project_title + '\'' +
                '}';
    }
}
