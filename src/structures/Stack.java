package structures;

public class Stack <T> {

    private final Deque<T> deque;

    public Stack() {
        deque = new Deque<>();
    }

    public void push(T element) {
        deque.addFirst(element);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty.");
        return deque.removeFirst();
    }

    public T peek() {
        if (isEmpty()) return null;
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
