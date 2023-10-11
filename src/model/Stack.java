package model;

import collections.IStack;

public class Stack <T extends Comparable<T>> implements IStack<T> {

    private SNode<T> top;

    public Stack() {
    }


    @Override
    public boolean isEmpty(){
        boolean flag = true;

        if(top!=null){
            flag = false;
        }

        return flag;
    }

    @Override
    public void push(T element){
        SNode<T> node = new SNode<>(element);
        top.setNext(node);
        node=top;
    }

    @Override
    public T pop(){
        T auxiliar = null;
        if(top!=null){
            auxiliar = top.getElement();
            top.setNext(top.getNext());
        }

        return auxiliar;
    }

    @Override
    public T top(){
        T element = null;
        if(!isEmpty()){
            element=top.getElement();
        }

        return element;
    }

}
