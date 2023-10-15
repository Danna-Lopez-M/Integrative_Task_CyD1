package model;

public class Action implements Comparable<Action> {

    private Reminder reminder1;

    private Reminder reminder2;

    private ActionType type;

    public Action(Reminder reminder1, Reminder reminder2, ActionType type) {
        this.reminder1 = reminder1;
        this.reminder2 = reminder2;
        this.type = type;
    }



    public Reminder getReminder1() {
        return reminder1;
    }

    public void setReminder1(Reminder reminder1) {
        this.reminder1 = reminder1;
    }

    public Reminder getReminder2() {
        return reminder2;
    }

    public void setReminder2(Reminder reminder2) {
        this.reminder2 = reminder2;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Action o) {
        return 0;
    }
}
