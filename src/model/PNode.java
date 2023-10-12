package model;

public class PNode<T> implements Comparable<PNode<T>>  {

    private int priority;

    private T element;

    public PNode(int priority, T element) {
        this.priority = priority;
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public int compareTo(PNode<T> o) {
        return this.priority-o.priority;
    }
}