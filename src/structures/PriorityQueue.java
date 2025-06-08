package structures;

import java.util.Comparator;

public class PriorityQueue <T> {

    private MaxHeap<T> heap;
    private Comparator<T> comp;

    public PriorityQueue() {
        heap = new MaxHeap(comp);
    }

    public void add(T element) {
        heap.push(element);
    }

    public T poll() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty.");
        return heap.pop();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty.");
        return heap.peek();
    }

    void clear() {
        heap.clear();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

}
