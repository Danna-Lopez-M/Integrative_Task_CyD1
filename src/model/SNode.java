package model;

public class SNode<T> {

    private SNode<T> next;

    private T element;

    public SNode(T element) {
        this.element = element;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
