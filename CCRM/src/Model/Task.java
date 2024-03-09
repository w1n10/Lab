
package Model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private static int currentId = 1;
    private int id;
    private String name;
    private String type;
    private Date day;
    private float time;
    private String assignee;
    private String reviewer;

    public Task(String name, String type, Date day, float time, String assignee, String reviewer) {
        this.id = currentId++;
        this.name = name;
        this.type = type;
        this.day = day;
        this.time = time;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%d\t%-10s\t%-10s\t%s\t%.1f\t\t%s\t\t\t%s",
                id, name, type, dateFormat.format(day), time, assignee, reviewer);
    }
}