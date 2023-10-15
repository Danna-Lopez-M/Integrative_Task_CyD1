package collections;

public interface IStack <T extends Comparable<T>> {

    public boolean isEmpty();

    public void push(T element);

    public T pop();

    public T top() throws Exception;

}