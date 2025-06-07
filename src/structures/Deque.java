package structures;

public class Deque<T> {

    private final DoublyLinkedList<T> list;

    public Deque() {
        list = new DoublyLinkedList<>();
    }

    public void addFirst(T element) {
        list.addFirst(element);
    }

    public void addLast(T element) {
        list.addLast(element);
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty.");
        return list.removeFirst();
    }

    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty.");
        return list.removeLast();
    }

    public T peekFirst() {
        if (isEmpty()) return null;
        return list.getFirst();
    }

    public T peekLast() {
        if (isEmpty()) return null;
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

}
