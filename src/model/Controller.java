package model;
import java.util.ArrayList;

public class Controller  {
    ChainigHashTable<Integer,Reminder> hash;
    PriorityQueue<Reminder> pQueue;
    Queue<Reminder> queue;
    Stack<Action> stack;

    ArrayList<Integer> keyArray;
    ArrayList<Reminder> reminders;

    public Controller(){
        hash = new ChainigHashTable<>();
        reminders = new ArrayList<>();
        keyArray = new ArrayList<>();
        queue = new Queue<>();
        pQueue = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void testKeys(int key){
        keyArray.add(key);
    }

    //--------------------------------------------------------------------------------------\\


    public void addReminderToList(Reminder reminder){
        reminders.add(reminder);
    }

    public void organizeReminders(){
        for(int i = 0; i<reminders.size();i++){
            for (int j = 1; j<reminders.size()-i;j++){
                Reminder anterior = reminders.get(j-1);
                Reminder actual = reminders.get(j);
                if(reminders.get(j-1)!=null && reminders.get(j)!=null){
                    if(reminders.get(j-1).getPriority()<reminders.get(j).getPriority()){
                        reminders.set(j,anterior);
                        reminders.set(j-1,actual);
                    }
                }
            }
        }
    }

    public void showReminderList(){
        int count = 1;
        for (int i = 0; i<reminders.size();i++){
            System.out.println("The index of the element is: " + count);
            System.out.println(reminders.get(i));
            System.out.println("\n");
            count++;
        }
    }



//    public void priorityInOrder(){
//        if(!keyArray.isEmpty()){
//            //Reminder[] objectArray;
//            ArrayList<Reminder> priorityArray = new ArrayList<>();
//            for (int i = 0; i<keyArray.size();i++){
//                    priorityArray.add(hash.hashSearch(keyArray.get(i)));
//                    //System.out.println(priorityArray.get(i));
//            }
//
//            for(int i = 0; i<priorityArray.size();i++){
//                for (int j = 1; j<priorityArray.size()-i;j++){
//                    Reminder anterior = priorityArray.get(j-1);
//                    Reminder actual = priorityArray.get(j);
//                    if(priorityArray.get(j-1)!=null && priorityArray.get(j)!=null){
//                        if(priorityArray.get(j-1).getPriority()>priorityArray.get(j).getPriority()){
//                            priorityArray.set(j,anterior);
//                            priorityArray.set(j-1,actual);
//                        }
//                   }
//               }
//           }
//            int count = 1;
//            for (int i = 0; i<priorityArray.size();i++){
//                System.out.println("The index of the element is: " + count);
//                System.out.println(priorityArray.get(i));
//                System.out.println("\n");
//                count++;
//            }
//        }
//    }


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

    //Integer processedkey = key;
    //int hashKey = hash.hashFuntion(processedkey);

    public void registerReminders(String title, String description, String deadline, int priority, int key){
        Reminder reminder = new Reminder(title,description,deadline,priority,key);

        addReminderToList(reminder);
        organizeReminders();

        hash.hashInsert(key, reminder);

        if(reminder.getPriority()!=0){
            pQueue.insert(reminder.getPriority(),reminder);
        }else{
            queue.enQueue(reminder);
        }

        ActionType type =ActionType.ADD;
        Action action = new Action(reminder,null, type);
        stack.push(action);
    }

    public  void modifyReminders(String title, String description, String deadline, int priority, int key){
        Reminder element = hash.hashSearch(key);
        Reminder copy = element;

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

        reminders.remove(copy);
        reminders.add(element);

        ActionType type =ActionType.MODIFY;
        Action action = new Action(element, copy, type);
        stack.push(action);
    }

    public void deleteReminders(int key){
        Reminder element = hash.hashSearch(key);
        hash.hashDelete(key);
        reminders.remove(element);

        ActionType type =ActionType.DELETE;
        Action action = new Action(element, null, type);
        stack.push(action);
    }


    //--------------------------------------------------------------------------------------\\

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
        try {
            System.out.println(pQueue.extractMax());
        } catch (Exception e) {
            System.out.println(e);
        }
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


    //--------------------------------------------------------------------------------------\\



    // Método para deshacer la última acción
    public void undo() {
        if (!stack.isEmpty()) {
            Action ultimaAccion = stack.pop();
            reverseAction(ultimaAccion);
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    private void reverseAction(Action action) {

        switch (action.getType()){
            case ADD:
                hash.hashDelete(action.getReminder1().getKey());
                reminders.remove(action.getReminder1());
                if(action.getReminder1().getPriority()>0){
                    try {
                        pQueue.extractMax();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }else {
                    queue.deQueue();
                }
                break;
            case DELETE:
                hash.hashInsert(action.getReminder1().getKey(),action.getReminder1());
                reminders.add(action.getReminder1());
                if(action.getReminder1().getPriority()>0){
                    pQueue.insert(action.getReminder1().getKey(),action.getReminder1());
                }else {
                    queue.enQueue(action.getReminder1());
                }
                break;
            case MODIFY:
                hash.hashDelete(action.getReminder1().getKey());
                hash.hashInsert(action.getReminder2().getKey(),action.getReminder2());
                reminders.remove(action.getReminder1());
                reminders.add(action.getReminder2());
                if(action.getReminder2().getPriority()>0){
                    pQueue.insert(action.getReminder2().getKey(),action.getReminder2());
                }else {
                    queue.enQueue(action.getReminder2());
                }
                break;
        }

        // Implementa la lógica para revertir la acción en función de la descripción
        // Por ejemplo, si la descripción es "Agregar tarea", entonces deshace la adición de la tarea.
        // Si la descripción es "Modificar tarea", revierte la modificación de la tarea.
        // Agrega la lógica correspondiente para las acciones que puedas realizar en tu sistema.

//        System.out.println("Deshaciendo: " + descripcion);
    }
}
