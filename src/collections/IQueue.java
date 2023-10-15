package collections;

public interface IQueue<T extends Comparable<T>> {

    public boolean isEmpty();

    public void enQueue(T element);

    public T deQueue();

    public T front() throws Exception;

}