package test;
import model.*;
import junit.framework.TestCase;



public class ReminderTest extends TestCase {

    private Controller controller;
    private ChainigHashTable<Integer, Reminder> hash;
    private Queue<Reminder> queue;
    private PriorityQueue<Reminder> pQueue;
    private Stack<Action> stack;


    private void setUpStage1(){
        controller = new Controller();
        hash = new ChainigHashTable<>();
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
        stack = new Stack<>();
    }

    private void setUpStage2(){
        hash = new ChainigHashTable<>();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        try {
            hash.hashInsert(123456,reminder);
        } catch (Exception e) {
            System.out.println("There is no reminder with that key");
        }
    }


    private void setUpStage3(){
        queue = new Queue<>();
        Reminder reminder1 = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",0,1234567);
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",0,1414234);
        Reminder reminder3 = new Reminder("TestTitleS3","TestDescriptionS3","TestDeadlineS3",0,2341234);
        try {
            queue.enQueue(reminder1);
            queue.enQueue(reminder2);
            queue.enQueue(reminder3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setUpStage4(){
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
        Reminder reminder1 = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",0,1234567);
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,1414234);
        queue.enQueue(reminder1);
        pQueue.insert(reminder2.getPriority(),reminder2);
    }

    public void setUpStage5(){
        pQueue = new PriorityQueue<>();
        Reminder reminder1 = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",0,1234567);
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,1414234);
        pQueue.insert(reminder2.getPriority(),reminder2);
    }

    public void setUpStage6(){
        pQueue = new PriorityQueue<>();
        Reminder reminder1 = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",2,1234567);
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,1414234);
        pQueue.insert(reminder1.getPriority(),reminder1);
        pQueue.insert(reminder2.getPriority(),reminder2);
    }


    public void setUpStage7(){
        stack = new Stack<>();
        Reminder reminder1 = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        ActionType type1 = ActionType.ADD;
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,1414234);
        ActionType type2 = ActionType.DELETE;
        Action action1 = new Action(reminder1,null, type1);
        Action action2 = new Action(reminder2,null, type2);
        stack.push(action1);
        stack.push(action2);
    }

    public void setUpStage8(){
        controller = new Controller();
        hash = new ChainigHashTable<>();
        controller.registerReminders("Title1","Description1","Deadline1",4,121441);
        controller.registerReminders("Title2","Description2","Deadline2",2,151513);
        controller.registerReminders("Title3","Description3","Deadline3",0,445345);
    }



    //-------------------------------------------\\



    //---------------------------HashTable------------------------------\\

    public void test1HashInsert(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitle2","TestDescription2","TestDeadline2",1,123456);
        try {
            hash.hashInsert(123456,reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(reminder,hash.hashSearch(123456));
    }

    public void test2HashInsert(){
        setUpStage1();
        Reminder reminder1 = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,654321);
        try {
            hash.hashInsert(123456,reminder1);
            hash.hashInsert(654321,reminder2);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotSame(reminder1,reminder2);
    }

    public void test3HashInsert(){

    }

    //----------------------------------------------------------\\

    public void test1HashSearch(){
        setUpStage2();
        Reminder object = null;
        try {
            object = hash.hashSearch(123456);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotNull(object);
    }

    public void test2HashSearch(){
        setUpStage2();
        Reminder object = null;
        try {
            object = hash.hashSearch(1414141);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(object);
    }

    public void test3HashSearch(){

    }

    //----------------------------------------------------------\\

    public void test1HashDelete(){
        setUpStage2();
        try {
            hash.hashDelete(123456);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(0,hash.size());
    }

    public void test2HashDelete(){
        setUpStage2();
        try {
            hash.hashDelete(123456);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(hash.hashSearch(123456));
    }


    public void test3HashDelete(){
        setUpStage2();
        try {
            hash.hashDelete(123654);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotNull(hash.hashSearch(123456));
    }


    //----------------------------Queue------------------------------\\


    public void test1QueueEnQueue(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        try {
            queue.enQueue(reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertFalse(queue.isEmpty());
    }

    public void test2QueueEnQueue(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",0,123456);
        queue.enQueue(reminder);
        try {
            queue.deQueue();
            assertNull(queue.front());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3QueueEnQueue(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        queue.enQueue(reminder);
        try {
            assertSame(reminder,queue.front());
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //----------------------------------------------------------\\

    public void test1QueueDeQueue(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        queue.enQueue(reminder);
        try {
            queue.deQueue();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertTrue(queue.isEmpty());
    }

    public void test2QueueDeQueue(){
        setUpStage3();
        try {
            queue.deQueue();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertFalse(queue.isEmpty());
    }

    public void test3QueueDeQueue(){
        setUpStage3();
        Reminder reminder = queue.deQueue();
        try {
            assertNotSame(queue.front(),reminder);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //----------------------------------------------------------\\

    public void test1QueueFront(){
        setUpStage3();
        Reminder reminder = null;
        try {
            reminder = queue.front();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotNull(reminder);
    }

    public void test2QueueFront(){
        setUpStage1();
        Reminder reminder = null;
        try {
            reminder = queue.front();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(reminder);
    }


    public void test3QueueFront(){
        setUpStage3();
        Reminder reminder1 = queue.deQueue();
        try {
            assertNotSame(reminder1, queue.front());
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //----------------------------Stack------------------------------\\

    public void test1StackPush(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        ActionType type =ActionType.ADD;
        try{
            Action action = new Action(reminder,null, type);
            stack.push(action);
            assertFalse(stack.isEmpty());
        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    public void test2StackPush(){
        setUpStage7();
        Reminder reminder1 = new Reminder("TestTitleS3","TestDescriptionS3","TestDeadlineS3",0,2341234);
        try{
            ActionType type1 = ActionType.DELETE;
            Action action1 = new Action(reminder1,null, type1);
            stack.push(action1);
            assertSame(action1,stack.top());
        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    public void test3StackPush(){
        setUpStage1();
        Action action = null;
        try{
            stack.push(action);
            assertNull(stack.top());
        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    //----------------------------------------------------------\\


    public void test1StackPop(){
        setUpStage7();
        Action action = null;
        try{
            action = stack.top();
            assertNotNull(action);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2StackPop(){
        setUpStage1();
        Action action = null;
        try{
            action = stack.pop();
            assertNull(action);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3StackPop(){
        setUpStage7();
        Action action1 = null;
        Action action2 = null;
        try{
            action2 = stack.top();
            action1 = stack.pop();
            assertSame(action1,action2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //----------------------------------------------------------\\

    public void test1StackTop(){
        setUpStage1();
        Action action = null;
        try{
            action = stack.top();
            assertNull(action);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2StackTop(){
        setUpStage7();
        Action action = null;
        try{
            action = stack.top();
            assertNotNull(action);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void test3StackTop(){
        setUpStage7();
        Action action2 = null;
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        ActionType type =ActionType.ADD;
        try{
            action2 = stack.pop();
            Action action = new Action(reminder,null, type);
            stack.push(action);
            assertNotSame(action2,stack.top());
        } catch (Exception e) {
            System.out.println(e);;
        }
    }



    //----------------------------------------------------------\\


    //----------------------------PriorityQueue------------------------------\\

    public void test1PriorityQueueMaximun(){
//        setUpStage5();
        Reminder reminder2 = new Reminder("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,1414234);
        pQueue = new PriorityQueue<>();
        Reminder reminder = null;
        pQueue.insert(reminder2.getPriority(),reminder2);
        try{
            reminder = pQueue.maximun();
            assertEquals(reminder,reminder2);
        }catch (Exception e){
            System.out.println(e);
            fail();
        }
    }

    public void test2PriorityQueueMaximun(){
        setUpStage1();
        Reminder reminder = null;
        try{
            reminder = pQueue.maximun();
        }catch (Exception e){
            System.out.println(e);
        }
        assertNull(reminder);
    }

    public void test3PriorityQueueMaximun(){
        setUpStage4();
        Reminder reminder1 = null;
        Reminder reminder2 = null;
        try {
            reminder1 = queue.front();
            reminder2 = pQueue.maximun();
        }catch (Exception e){
            System.out.println(e);
        }
        assertNotSame(reminder1,reminder2);
    }


    //----------------------------------------------------------\\


    public void test1PriorityQueueExtract(){
        setUpStage1();
        try{
            Reminder reminder = pQueue.extractMax();
            assertNull(reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2PriorityQueueExtract(){
        setUpStage6();
        try{
            Reminder reminder = pQueue.extractMax();
            assertNotSame(pQueue.maximun(),reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3PriorityQueueExtract(){
        setUpStage6();
        Reminder reminder3 = new Reminder("TestTitleS3","TestDescriptionS3","TestDeadlineS3",1,4575748);
        try {
            Reminder reminder = pQueue.maximun();
            pQueue.insert(reminder3.getPriority(),reminder3);
            pQueue.increaseKey(2,5);
            assertNotSame(reminder,pQueue.maximun());
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //----------------------------------------------------------\\


    public void test1PriorityQueueInsert(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        try{
            pQueue.insert(reminder.getPriority(),reminder);
            assertEquals(1, pQueue.size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2PriorityQueueInsert(){
        setUpStage1();
        Reminder reminder = null;
        try{
            reminder = pQueue.maximun();
            assertNull(reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3PriorityQueueInsert(){
        setUpStage6();
        try {
            Reminder reminder2 = new Reminder("TestTitleS3","TestDescriptionS3","TestDeadlineS3",5,4575748);
            pQueue.insert(reminder2.getPriority(),reminder2);
            assertEquals(5,pQueue.maximun().getPriority());
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //----------------------------------------------------------\\


    public void test1PriorityQueueIncreaseKey(){
        setUpStage6();
        Reminder reminder1 = null;
        Reminder reminder2 = null;
        try{
            reminder1 = pQueue.maximun();
            pQueue.increaseKey(1,5);
            reminder2 = pQueue.maximun();
            assertNotSame(reminder1,reminder2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2PriorityQueueIncreaseKey(){
        setUpStage1();
        Reminder reminder = new Reminder("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
        PNode<Reminder> reminderPnode = new PNode<>(reminder.getPriority(),reminder);
        try{
            pQueue.insert(reminder.getPriority(),reminder);
            pQueue.increaseKey(0,10);
            PNode<Reminder> reminderPnode2 = new PNode<>(pQueue.maximun().getPriority(),pQueue.maximun());
            assertEquals(1,reminderPnode2.getPriority());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3PriorityQueueIncreaseKey(){
        setUpStage6();
        Reminder reminder1 = null;
        Reminder reminder2 = null;
        try{
            reminder1 = pQueue.maximun();
            pQueue.increaseKey(0,-1);
            reminder2 = pQueue.maximun();
            assertSame(reminder2,pQueue.maximun());
        } catch (Exception e) {
            System.out.println(e);
        }

    }



    //----------------------------------------------------------\\


    //----------------------------Controller------------------------------\\

    public void test1RegisterReminder(){
        setUpStage1();
        Reminder reminder1 = null;
        Reminder reminder2 = null;
        try {
            controller.registerReminders("TestTitleS1","TestDescriptionS1","TestDeadlineS1",0,123456);
            reminder1 = hash.hashSearch(123456);
            reminder2 = queue.front();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertSame(reminder2,reminder1);
    }

    public void test2RegisterReminder(){
        setUpStage1();
        Reminder reminder = null;
        try {
            controller.registerReminders("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
            reminder = queue.front();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(reminder);
    }

    public void test3RegisterReminder(){
        setUpStage1();
        try{
            controller.registerReminders("TestTitleS1","TestDescriptionS1","TestDeadlineS1",0,1234567);
            //controller.registerReminders("TestTitleS2","TestDescriptionS2","TestDeadlineS2",1,1414234);
        } catch (Exception e){
            System.out.println(e);
        }
        try{
            assertNotSame(queue.front(),pQueue.maximun());
        } catch (Exception e){
            System.out.println(e);
        }
    }

    //----------------------------------------------------------\\

    public void test1DeleteReminder(){
        setUpStage1();
        Reminder reminder = null;
        try {
            controller.registerReminders("TestTitleS1","TestDescriptionS1","TestDeadlineS1",1,123456);
            controller.deleteReminders(123456);
            reminder = hash.hashSearch(123456);
            assertNull(reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void test2DeleteReminder(){
        setUpStage8();
        Reminder reminder = null;
        try {
            controller.deleteReminders(121441);
            reminder = pQueue.maximun();
            assertNotNull(reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3DeleteReminder(){
        setUpStage8();
        Reminder reminder = null;
        try {
            controller.deleteReminders(595346);
            reminder = queue.front();
            assertNotNull(reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //----------------------------------------------------------\\


    public void test1ModifyReminder(){
        setUpStage8();
        Reminder reminder1 = null;
        Reminder reminder2 = null;
        try {
            reminder1 = hash.hashSearch(121441);
            controller.modifyReminders("DifferentT","DifferentD","DifferentD",0,121441);
            reminder2 = hash.hashSearch(121441);
            assertSame(reminder1,reminder2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2ModifyReminder(){
        setUpStage8();
        Reminder reminder = null;
        try {
            controller.modifyReminders("DifferentT","DifferentD","DifferentD",5,121441);
            reminder = hash.hashSearch(121441);
            assertEquals(5,reminder.getPriority());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test3ModifyReminder(){
        setUpStage8();
        Reminder reminder = null;
        try {
            controller.deleteReminders(121441);
            controller.modifyReminders("DifferentT","DifferentD","DifferentD",5,121441);
            assertNull(hash.hashSearch(121441));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //----------------------------------------------------------\\



//
//    private  void addReminderTest2(){
//        setUpStage1();
//        try {
//            controller.registerReminders("TestTitle","TestDescription","TestDate",4,1111111);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        assertEquals(1,hash.size());
//    }
//
//    private  void addReminderTest3(){
//        setUpStage1();
//        try {
//            controller.registerReminders("TestTitle","TestDescription","TestDate",4,1111111);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        assertEquals(1,hash.size());
//    }




}