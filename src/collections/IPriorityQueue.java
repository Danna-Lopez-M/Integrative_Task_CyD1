package collections;

public interface IPriorityQueue <T> {

    public void insert(int priority, T element);

    public T maximun();

    public T extractMax() throws Exception;

    public void increaseKey(int index, int priority);

}
