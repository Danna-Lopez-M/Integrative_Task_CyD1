package model;

public class HNode<K extends Comparable<K>,V> {

    private V value;

    private K key;

    private HNode<K,V> next;

    private HNode<K,V> previous;

    public HNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public HNode<K, V> getNext() {
        return next;
    }

    public void setNext(HNode<K, V> next) {
        this.next = next;
    }

    public HNode<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(HNode<K, V> previous) {
        this.previous = previous;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public String toString(){
        return value.toString() + key.toString();
    }

}
