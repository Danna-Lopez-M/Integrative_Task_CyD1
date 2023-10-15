package model;
import collections.Prioritizeable;

public class Reminder implements Comparable<Reminder>, Prioritizeable {

    private String title;

    private String description;

    private String deadline;

    private int priority;

    private int key;

    public Reminder(String title, String description, String deadline, int priority, int key) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String toString() {
        String out = "**** Reminder Content ****\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "DeadLine: " + deadline + "\n" +
                "Key: " + key + "\n";


        if (priority == 1) {
            out += "Priority 1: The reminder is very important";
        } else if (priority == 2) {
            out += "Priority 2: The reminder is important";
        } else if (priority == 3) {
            out += "Priority 3: The reminder is considerable";
        } else if (priority == 4) {
            out += "Priority 4: The reminder is less important";
        } else if (priority == 5) {
            out += "Priority 5: The reminder not very important";
        } else {
            out += "The reminder has no priority()";
        }


        return out;
    }

    @Override
    public int compareTo(Reminder o) {

        if(priority>o.getPriority()){
            return 1;
        }
        else if(priority<getPriority()){
            return -1;
        }
        else{
            return 0;
        }
    }
}