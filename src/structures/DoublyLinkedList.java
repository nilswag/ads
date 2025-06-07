package structures;

public class DoublyLinkedList <T> {

    private final Node<T> header;
    private final Node<T> trailer;

    public DoublyLinkedList() {
        header = new Node<T>(null);
        trailer = new Node<T>(null);
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public void add(T element) {
        Node<T> newNode = new Node<T>(element, trailer.getPrev(), trailer);
        newNode.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<T>(element, header, header.getNext());
        newNode.getNext().setPrev(newNode);
        header.setNext(newNode);
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<T>(element, trailer.getPrev(), trailer);
        trailer.setPrev(newNode);
        newNode.getPrev().setNext(newNode);
    }

    public void insert(T element, int index) {
        if (index < 0 || index > size()) throw new IllegalArgumentException("Index is out of bounds.");
        Node<T> current = header;
        for (int i = 0; i < index; i++) current = current.getNext();
        Node<T> newNode = new Node<T>(element, current, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
    }

    public T get(int index) {
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Index is out of bounds.");
        Node<T> current = header.getNext();
        for (int i = 0; i < index; i++) current = current.getNext();
        return current.getData();
    }

    public T getFirst() {
        return header.getNext().getData();
    }

    public T getLast() {
        return trailer.getPrev().getData();
    }

    public T removeFirst() {
        if (header.getNext() == trailer) throw new IllegalStateException("List is empty.");
        T element = header.getNext().getData();
        header.getNext().getNext().setPrev(header);
        header.setNext(header.getNext().getNext());
        return element;
    }

    public T removeLast() {
        if (header.getNext() == trailer) throw new IllegalStateException("List is empty.");
        T element = trailer.getPrev().getData();
        trailer.getPrev().getPrev().setNext(trailer);
        trailer.setPrev(trailer.getPrev().getPrev());
        return element;
    }

    public T deleteAt(int index) {
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Index is out of bounds.");
        Node<T> current = header.getNext();
        for (int i = 0; i < index; i++) current = current.getNext();
        T element = current.getData();
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        return element;
    }

    public void clear() {
        while (!isEmpty()) removeLast();
    }

    public void reverse() {
        Node<T> current = header.getNext();
        for (int i = 0; i < size(); i++) {
            Node<T> temp = current.getNext();
            current.setNext(current.getPrev());
            current.setPrev(temp);
            current = temp;
        }
        Node<T> temp = header.getNext();
        header.setNext(trailer.getPrev());
        trailer.setPrev(temp);
    }

    public int size() {
        int i = 0;
        Node<T> current = header.getNext();
        while (current != trailer) {
            current = current.getNext();
            i++;
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
