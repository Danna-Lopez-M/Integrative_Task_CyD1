package collections;

public interface IHashTable<K extends Comparable<K>, V> {

    public void hashInsert(K key,V value);
    //HNode<K,V> node

    public V hashSearch(K key);

    public void hashDelete(K key);

}
