package collections;

public interface IHeap<T> {

    public IHeap build();

    public void heapify(int index);

    public void buildHeap();

    public void heapSort();

    public int parent(int index);

    public int left(int index);

    public int right(int index);


}
