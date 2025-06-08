package structures;

import java.util.Comparator;

public class PriorityQueue <T> {

    private final MinHeap<T> heap;

    public PriorityQueue(Comparator<T> comp) {
        heap = new MinHeap<>(comp);
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
