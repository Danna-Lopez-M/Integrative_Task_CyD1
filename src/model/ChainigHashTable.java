package model;

import collections.IHashTable;

public class ChainigHashTable<K extends Comparable<K>, V> implements IHashTable<K, V> {

    public static final int ARRAY_SIZE =  200;

    private HNode<K,V> table[];

    private HNode<K,V> deleted;

    public ChainigHashTable() {
        table = new HNode[ARRAY_SIZE];
    }

    public int hashFuntion(K key){

        double A =  (Math.sqrt(5)-1)/2;

        int transform = fromStringToNatural(key);
        double result = transform *A % 1;

        result = Math.floor(ARRAY_SIZE*result);

        return (int) result;
    }

    @Override
    public void hashInsert(K key, V value){
        //, HNode<K,V> pointer

        int location = hashFuntion(key);

        HNode<K,V> current = table[location];

        HNode<K, V> node = new HNode<>(key, value);

        if(current != null){
            node.setNext(current);
            current.setPrevious(node);
        } else{
            table[location] = node;
        }
    }

    @Override
    public V hashSearch(K key){

        //Indice o puntero en el arreglo donde la key apunta
        int location = hashFuntion(key);

        //Nodo actual en la posicion del arreglo donde el indice apunta.
        HNode<K,V> current = table[location];

        if(current!=null){
            return current.getValue();
        }else {
            return null;
        }
    }

    @Override
    public void hashDelete(K key){

        int location = hashFuntion(key);

        HNode<K,V> current = table[location];

        if(current!=null){
            if(current.getKey().compareTo(key)==0){
                table[location] = current.getNext();
            }

            else {
                current = current.getNext();
                while (current != null){

                    if(current.getKey().compareTo(key)==0) {
                        if(current.getPrevious() == null){
                            current.getNext().setPrevious(null);
                            current.setNext(null);
                        }else if(current.getNext() == null){
                            current.getPrevious().setNext(null);
                            current.setPrevious(null);
                        }else {
                            HNode<K,V> auxiliar = current;
                            current.getPrevious().setNext(auxiliar.getNext());
                            current.getNext().setPrevious(current.getPrevious());
                        }
                        break;
                    }
                    current = current.getNext();
                }
            }
        }
    }

    public int fromStringToNatural(K key){
        int sum = 0;
        int pow = 0;
        for(int i = key.toString().length() -1 ;i >= 0; i--){
            sum += (int) ((int)key.toString().charAt(i) * Math.pow(128, pow));
            pow++;
        }
        return sum;
    }


    public int size(){
        int size = 0;
        for(int i = 1;i<table.length;i++){
            if(table[i]!=null){
                size++;
            }
        }
        return size;
    }


}
