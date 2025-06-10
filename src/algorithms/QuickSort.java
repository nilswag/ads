package algorithms;

import structures.ArrayList;

import java.util.Comparator;

public class QuickSort {

    public static <T> void sort(ArrayList<T> list, Comparator<T> comp) {
        sort(list, comp, 0, list.size() - 1);
    }

    private static <T> void sort(ArrayList<T> list,  Comparator<T> comp, int lower, int upper) {
        if (lower >= upper) return;
        int pivot = upper;
        int i = lower;
        int j = i - 1;
        while (i < upper) {
            if (comp.compare(list.get(i), list.get(pivot)) < 0) list.swap(i, ++j);
            i++;
        }
        list.swap(pivot, j + 1);
        pivot = j + 1;
        sort(list, comp, lower, pivot - 1);
        sort(list, comp, pivot + 1, upper);
    }

}
