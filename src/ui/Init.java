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
        cll.registerReminders("Title1PQ","ProrityDescription1","ProrityDeadline1",4,121441);
        cll.registerReminders("Title2PQ","ProrityDescription2","ProrityDeadline2",2,151513);
        cll.registerReminders("Title3PQ","ProrityDescription3","ProrityDeadline3",3,116515);
        cll.registerReminders("Title4PQ","ProrityDescription4","ProrityDeadline4",5,151354);
        cll.registerReminders("Title5PQ","ProrityDescription5","ProrityDeadline5",1,153514);
        //151513
        cll.registerReminders("Title6NPQ","NonPriorityDescription6","NonPriorityDeadline6",0,412341);
        cll.registerReminders("Title7NPQ","NonPriorityDescription7","NonPriorityDeadline7",0,634566);
        cll.registerReminders("Title8NPQ","NonPriorityDescription8","NonPriorityDeadline8",0,856788);

        return cll;
    }
}
