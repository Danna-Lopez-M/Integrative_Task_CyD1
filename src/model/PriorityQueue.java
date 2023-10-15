package model;

import collections.IHeap;
import collections.IPriorityQueue;
import collections.Prioritizeable;

import java.util.Arrays;

import static java.lang.Integer.MIN_VALUE;
@SuppressWarnings("unchecked")
public class PriorityQueue<T> implements IPriorityQueue<T>, IHeap<T> {

    public static final int ARRAY_SIZE =  200;

    private PNode<T>[] array;

    //    private Prioritizeable object;
//
//    private Prioritizeable[] array;
    private int heapSize;

    public int size;

    public PriorityQueue() {
//        array =(T[]) new Object [ARRAY_SIZE];
        array = new PNode [ARRAY_SIZE];
//        array = new Prioritizeable [ARRAY_SIZE];
        size=-1;
    }


    @Override
    public IHeap<T> build() {
        return null;
    }

    @Override
    public void heapify(int index) {
        int largest = 0;
        int l = left(index);
        int r = right(index);
        if(l<= size && array[l].compareTo(array[index])>0){
            largest = l;
        }else {
            largest = index;
        }
        if(r<= size && array[r].compareTo(array[largest])>0){
            largest = r;
        }
        if(largest!=index){
            PNode<T> auxiliary = array[index];
            array[index] = array[largest];
            array[largest] = auxiliary;
            heapify(largest);
        }
    }


    @Override
    public void buildHeap(){
        for(int i = (array.length/2);i>1;i--){
            heapify(i);
        }
    }

    @Override
    public void heapSort(){}

    @Override
    public int parent(int index){
        if (index == 0) {
            return 0;
        }
        return Math.floorDiv((index +1),2)-1;
    }

    @Override
    public int left(int index){
        return 2*(index+1)-1;
    }

    @Override
    public int right(int index){
        return 2*(index+1);
    }


    public int size(){
        int count=0;
        for(int i=1;i<array.length;i++){
            if(array[i]!=null){
                count++;
            }
        }
        return count;
    }


    //------------------------------------------------------------------------------------


    public void showElements(){
        int index = 0;
        while(array[index]!=null){
            System.out.println(array[index].toString());
            index++;
        }
    }



    @Override
    public void insert(int priority, T element){
        PNode<T> node = new PNode<>(MIN_VALUE, element);
//        size = size();
        size = size+1;
        array[size] = node;
        increaseKey(size, priority);
    }

    @Override
    public T maximun(){
        return array[0].getElement();
    }

    @Override
    public T extractMax() throws Exception {
        //buildHeap();
        PNode<T> max = null;
        if(size<0){
            System.out.println("heap Underflow");
        }else {
            max = array[0];
            array[0] = array[size];
            size = size-1;
            heapify(0);
        }
        if(max!=null) {
            return max.getElement();
        }else {
            throw new Exception("There is no element");
        }
    }

    @Override
    public void increaseKey(int index, int key){
        if(array[index]!=null){
            if(key<(array[index].getPriority())) {
                System.out.println("error: New key is smaller than current key");
            }
            //array[index].setPriority(key);
        }
        if(array[index]!=null){
            array[index].setPriority(key);
            while(index > 0 && array[parent(index)].getPriority()<(array[index].getPriority())){
                PNode<T> auxiliary = array[index];
                array[index] = array[parent(index)];
                array[parent(index)] = auxiliary;
                index = parent(index);
            }
        }else{
            System.out.println("error");
        }
    }
}
