package algorithms;

import structures.ArrayList;

import java.util.Comparator;

public class HeapSort {

    public static <T> void sort(ArrayList<T> list, Comparator<T> comp) {
        for (int i = (list.size() - 1) / 2; i >= 0; i--) heapify(list, comp, list.size(), i);
        for (int i = list.size() - 1; i > 0; i--) {
            list.swap(0, i);
            heapify(list, comp, i, 0);
        }
    }

    private static <T> void heapify(ArrayList<T> list, Comparator<T> comp, int n, int i) {
        int current = i;
        while (true) {
            int l = current * 2 + 1;
            int r = current * 2 + 2;
            int largest = current;

            if (l < n && comp.compare(list.get(largest), list.get(l)) < 0) largest = l;
            if (r < n && comp.compare(list.get(largest), list.get(r)) < 0) largest = r;

            if (current != largest) {
                list.swap(current, largest);
                current = largest;
            } else break;
        }
    }

}
