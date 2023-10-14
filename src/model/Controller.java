package model;

import java.util.ArrayList;

public class Controller {


    ChainigHashTable<Integer,Reminder> hash;
    PriorityQueue<Reminder> pQueue;
    Queue<Reminder> queue;

    ArrayList<Integer> keyArray;

    public Controller(){
        hash = new ChainigHashTable<>();
        keyArray = new ArrayList<>();
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
    }

    public void testKeys(int key){
        keyArray.add(key);
    }


    public <V> void priorityInOrder(){
        if(!keyArray.isEmpty()){
            //Reminder[] objectArray;
            ArrayList<Reminder> priorityArray = new ArrayList<>();
            for (int i = 0; i<keyArray.size();i++){
                priorityArray.add(hash.hashSearch(keyArray.get(i)));
                //System.out.println(priorityArray.get(i));
            }
            Reminder temp = null;
            Integer temp2 = null;
//            //int temp;
            for(int i = 0; i<priorityArray.size();i++){
                for (int j = 1; j<priorityArray.size()-i;j++){
                    Reminder first = priorityArray.get(j-1);
                    Reminder second = priorityArray.get(j);
                    Reminder anterior = priorityArray.get(j-1);
                    Reminder actual = priorityArray.get(j);
//                    Integer firstKey = keyArray.get(j+1);
//                    Integer secondKey = keyArray.get(j);
//
                    if(priorityArray.get(j-1)!=null && priorityArray.get(j)!=null){
                        if(priorityArray.get(j-1).getPriority()>priorityArray.get(j).getPriority()){

                            priorityArray.set(j,anterior);
                            priorityArray.set(j-1,actual);
                        }
                    }
                }
            }
            int count = 1;
            for (int i = 0; i<priorityArray.size();i++){
                System.out.println("The index of the element is: " + count);
                System.out.println(priorityArray.get(i));
                System.out.println("\n");
                count++;
            }
        }
    }


    public boolean keyVerification(Integer key){
        Integer processedKey = key;
        boolean flag = false;
        if(!keyArray.isEmpty()){
            for (int i = 0; i<keyArray.size() && !flag;i++){
                if (keyArray.get(i).compareTo(processedKey) == 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }


    public void registerReminders(String title, String description, String deadline, int priority, int key){
        Reminder reminder = new Reminder(title,description,deadline,priority,key);
        //Integer processedkey = key;
        //int hashKey = hash.hashFuntion(processedkey);
        hash.hashInsert(key, reminder);

        if(reminder.getPriority()!=0){
            pQueue.insert(reminder.getPriority(),reminder);
        }else{
            queue.enQueue(reminder);
        }
    }

    public  void modifyReminders(String title, String description, String deadline, int priority, int key){
        Reminder element = hash.hashSearch(key);
        if(element!=null){

            if(title!=null){
                element.setTitle(title);
            }
            else if(description!=null){
                element.setDescription(description);
            }
            else if(deadline!=null){
                element.setDeadline(deadline);
            }
            else if(priority <= 5 && priority >= 1){
                element.setPriority(priority);
            }
            else{
                System.out.println("There is a problem");
            }

        }
    }

    public void deleteReminders(int key){
        hash.hashDelete(key);
    }

    public void showQueueFront(){
        try {
            System.out.println(queue.front().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            queue.front();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void enQueueFront(){


    }

    public void deQueueFront(){
        Reminder element = null;
        try {
            element = queue.front();
        } catch (Exception e) {
            System.out.println(e);
        }
        hash.hashDelete(element.getKey());
        queue.deQueue();
    }

    //--------------------------------------------------------------------------------------\\


    public void showMaximunValue(){
        System.out.println(pQueue.maximun());
        pQueue.maximun();
    }

    public void insertValue(int priority, Reminder reminder){
        pQueue.insert(priority, reminder);
    }

    public void extractValue(){
        Reminder element = null;
        element = pQueue.maximun();
        System.out.println(pQueue.extractMax());
        System.out.println("\n");
        hash.hashDelete(element.getKey());


    }

    public void increasePriority(int index, int priority, int key){
//        Reminder reminder = hash.hashSearch(index);
//        PNode<Integer, Reminder> node = new PNode<>(reminder.getPriority(),reminder);

        Reminder element = hash.hashSearch(key);
        element.setPriority(priority);
        pQueue.increaseKey(index, priority);
    }


    public void showElements(){
        pQueue.showElements();
    }


}
