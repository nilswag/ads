package algorithms;

import structures.ArrayList;

import java.util.Comparator;

public class SelectionSort {

    public static <T> void sort(ArrayList<T> list, Comparator<T> comp) {
        for (int i = 0; i < list.size(); i++) {
            int smallest = i;
            for (int j = i; j < list.size(); j++) if (comp.compare(list.get(j), list.get(smallest)) < 0) smallest = j;
            list.swap(smallest, i);
        }
    }

}
