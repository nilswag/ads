package structures;

import java.util.Comparator;

public class MaxHeap <T> {

    /*
     parent = (index - 1) / 2
     left child = 2 * index + 1
     right child = 2 * index + 2
     */

    private final ArrayList<T> list;
    private final Comparator<T> comp;

    public MaxHeap(Comparator<T> comp) {
        this.comp = comp;
        list = new ArrayList<>();
    }

    public void push(T element) {
        list.add(element);
        int cur = list.size() - 1;
        while (cur > 0) {
            int p = (cur - 1) / 2;
            if (comp.compare(list.get(p), list.get(cur)) < 0) {
                list.swap(cur, p);
                cur = p;
            } else break;
        }
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalStateException("Heap is empty.");
        return list.getFirst();
    }

    public T pop() {
        if (list.isEmpty()) throw new IllegalStateException("Heap is empty.");
        T element = list.getFirst();
        list.swap(0, list.size() - 1);
        list.removeLast();
        int current = 0;
        while (true) {
            int l = current * 2 + 1;
            int r = current * 2 + 2;
            int bigger = current;

            if (l < list.size() && comp.compare(list.get(l), list.get(bigger)) > 0) bigger = l;
            if (r < list.size() && comp.compare(list.get(r), list.get(bigger)) > 0) bigger = r;
            if (bigger == current) break;

            list.swap(current, bigger);
            current = bigger;
        }
        return element;
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
