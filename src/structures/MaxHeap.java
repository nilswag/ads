package structures;

public class MaxHeap {

    /*
     parent = (index - 1) / 2
     left child = 2 * index + 1
     right child = 2 * index + 2
     */

    private ArrayList<Integer> list;

    public MaxHeap() {
        list = new ArrayList<>();
    }

    public void push(int element) {
        list.add(element);
        int cur = list.size() - 1;
        while (cur > 0) {
            int p = (cur - 1) / 2;
            if (list.get(p) < list.get(cur)) {
                list.swap(cur, p);
                cur = p;
            } else break;
        }
    }

    public int pop() {
        int element = list.getFirst();
        list.swap(0, list.size() - 1);
        list.removeLast();
        int current = 0;
        while (true) {
            int l = current * 2 + 1;
            int r = current * 2 + 2;
            int bigger = current;

            if (l < list.size() && list.get(l) > list.get(bigger)) bigger = l;
            if (r < list.size() && list.get(r) > list.get(bigger)) bigger = r;
            if (bigger == current) break;

            list.swap(current, bigger);
            current = bigger;
        }
        return element;
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
