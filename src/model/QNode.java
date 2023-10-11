package model;

public class QNode<T> {

    private QNode<T> next;

    private T element;

    private boolean check;

    public QNode(T element, boolean check) {
        this.element = element;
        this.check =  check;
    }

    public QNode<T> getNext() {
        return next;
    }

    public void setNext(QNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

}
