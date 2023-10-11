package model;

import collections.IQueue;

public class Queue<T extends Comparable<T>> implements IQueue<T> {

    private QNode<T> first;

    private QNode<T> last;

    public Queue() {
    }

    @Override
    public boolean isEmpty(){
        boolean flag = true;
        if(first !=null){
            flag=false;
        }
        return flag;
    }

    @Override
    public void enQueue(T element){
        QNode<T> node = new QNode<>(element, false);

        if(first==null){
            first=node;
            last=node;
        }

        if(last!=null){
            last.setNext(node);
            last = node;
        }
    }

    @Override
    public T deQueue(){
        T auxiliar = null;

        if(first!=null){
            auxiliar = first.getElement();
            first = first.getNext();
        }

        return auxiliar;
    }

    @Override
    public T front(){
        return first.getElement();
    }

}
