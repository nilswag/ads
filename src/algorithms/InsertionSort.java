package algorithms;

import structures.ArrayList;

import java.util.Comparator;

public class InsertionSort {

    public static <T> void sort(ArrayList<T> list, Comparator<T> comp) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            while (j > 0 && comp.compare(list.get(j), list.get(j - 1)) < 0) {
                list.swap(j, j - 1);
                j--;
            }
        }
    }

}
