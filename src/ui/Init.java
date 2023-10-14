package ui;
import model.Controller;

public class Init {
    private Controller cll;


    public Init() {
        cll = new Controller();
    }

    public Controller testKeys(){

        cll.testKeys(121441);
        cll.testKeys(151513);
        cll.testKeys(116515);
        cll.testKeys(151354);
        cll.testKeys(153514);
//        cll.registerReminders("Title1","Description1","Deadline1",4,121441);
//        cll.registerReminders("Title2","Description2","Deadline2",2,151513);
//        cll.registerReminders("Title3","Description3","Deadline3",3,116515);
//        cll.registerReminders("Title4","Description4","Deadline4",5,151354);
//        cll.registerReminders("Title5","Description5","Deadline5",1,153514);
        //151513
        cll.registerReminders("Title1","Description1","Deadline1",0,121441);
        cll.registerReminders("Title2","Description2","Deadline2",0,151513);
        cll.registerReminders("Title3","Description3","Deadline3",0,116515);
        cll.registerReminders("Title4","Description4","Deadline4",0,151354);
        cll.registerReminders("Title5","Description5","Deadline5",0,153514);

        return cll;
    }
}
