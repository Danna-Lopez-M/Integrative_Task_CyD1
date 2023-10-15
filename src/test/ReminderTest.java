package test;
import model.*;
import junit.framework.TestCase;


public class ReminderTest extends TestCase {

    private Controller controller;
    private ChainigHashTable<Integer, Reminder> hash;
    private Queue<Reminder> queue;
    private PriorityQueue<Reminder> pQueue;


    private void setUpStage1() {
        controller = new Controller();
        hash = new ChainigHashTable<>();
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
    }

    private void setUpStage2() {
        hash = new ChainigHashTable<>();
        Reminder reminder = new Reminder("TestTitleS1", "TestDescriptionS1", "TestDeadlineS1", 1, 123456);
        try {
            hash.hashInsert(123456, reminder);
        } catch (Exception e) {
            System.out.println("There is no reminder with that key");
        }
    }


    private void setUpStage3() {
        queue = new Queue<>();
        Reminder reminder1 = new Reminder("TestTitleS1", "TestDescriptionS1", "TestDeadlineS1", 0, 1234567);
        Reminder reminder2 = new Reminder("TestTitleS2", "TestDescriptionS2", "TestDeadlineS2", 0, 1414234);
        Reminder reminder3 = new Reminder("TestTitleS3", "TestDescriptionS3", "TestDeadlineS3", 0, 2341234);
        try {
            queue.enQueue(reminder1);
            queue.enQueue(reminder2);
            queue.enQueue(reminder3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setUpStage4() {
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
        Reminder reminder1 = new Reminder("TestTitleS1", "TestDescriptionS1", "TestDeadlineS1", 0, 1234567);
        Reminder reminder2 = new Reminder("TestTitleS2", "TestDescriptionS2", "TestDeadlineS2", 1, 1414234);
        queue.enQueue(reminder1);
        pQueue.insert(reminder2.getPriority(), reminder2);
    }

    public void setUpStage5() {
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
        Reminder reminder2 = new Reminder("TestTitleS2", "TestDescriptionS2", "TestDeadlineS2", 1, 1414234);
        pQueue.insert(reminder2.getPriority(), reminder2);
    }


    //-------------------------------------------\\



    //---------------------------HashTable------------------------------\\

    public void test1HashInsert() {
        setUpStage1();
        Reminder reminder = new Reminder("TestTitle2", "TestDescription2", "TestDeadline2", 1, 123456);
        try {
            hash.hashInsert(123456, reminder);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(reminder, hash.hashSearch(123456));
    }

    public void test2HashInsert() {
        setUpStage1();
        Reminder reminder1 = new Reminder("TestTitleS1", "TestDescriptionS1", "TestDeadlineS1", 1, 123456);
        Reminder reminder2 = new Reminder("TestTitleS2", "TestDescriptionS2", "TestDeadlineS2", 1, 654321);
        try {
            hash.hashInsert(123456, reminder1);
            hash.hashInsert(654321, reminder2);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotSame(reminder1, reminder2);
    }

    public void test3HashInsert() {

    }

    //----------------------------------------------------------\\

    public void test1HashSearch() {
        setUpStage2();
        Reminder object = null;
        try {
            object = hash.hashSearch(123456);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotNull(object);
    }

    public void test2HashSearch() {
        setUpStage2();
        Reminder object = null;
        try {
            object = hash.hashSearch(1414141);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(object);
    }

    public void test3HashSearch() {

    }

    //----------------------------------------------------------\\

    public void test1HashDelete() {
        setUpStage2();
        try {
            hash.hashDelete(123456);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(0, hash.size());
    }

    public void test2HashDelete() {
        setUpStage2();
        try {
            hash.hashDelete(123456);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNull(hash.hashSearch(123456));
    }


    public void test3HashDelete() {
        setUpStage2();
        try {
            hash.hashDelete(123654);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertNotNull(hash.hashSearch(123456));
    }
}
