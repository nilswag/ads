package structures;

public class Queue <T> {

    private final Deque<T> deque;

    public Queue() {
        deque = new Deque<>();
    }

    public void enqueue(T element) {
        deque.addLast(element);
    }

    public T dequeue(T element) {
        if (isEmpty()) throw new IllegalStateException("Queue is empty.");
        return deque.removeFirst();
    }

    public T peek() {
        return deque.peekFirst();
    }

    public void clear() {
        deque.clear();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

}
