package structures;

public class ArrayList<T> {

    private T[] arr;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        capacity = 1;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    public void add(T element) {
        if (size >= capacity) resize(capacity * 2);
        arr[size] = element;
        size++;
    }

    public void addFirst(T element) {
        insert(element, 0);
    }

    public void insert(T element, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index is out of bounds.");
        if (size >= capacity) resize(capacity * 2);
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is out of bounds.");
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        if (capacity > 1 && ((float) size / capacity) < 0.25f) resize(capacity / 2);
    }

    public void remove() {
        if (isEmpty())
            throw new IllegalStateException("DynamicArray is empty.");
        arr[size - 1] = null;
        size--;
        if (capacity > 1 && ((float) size / capacity) < 0.25f) resize(capacity / 2);
    }

    public void removeFirst() {
        removeAt(0);
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is out of bounds.");
        return arr[index];
    }

    public void set(T element, int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is out of bounds.");
        arr[index] = element;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        if (newCapacity < 1) newCapacity = 1;
        T[] tmp = (T[]) new Object[newCapacity];
        for (int i = 0; i < Math.min(size, newCapacity); i++) tmp[i] = arr[i];
        arr = tmp;
        capacity = newCapacity;
        if (size > capacity) size = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
        capacity = 1;
        arr = (T[]) new Object[capacity];
    }

}
