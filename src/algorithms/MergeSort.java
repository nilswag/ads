package algorithms;

import structures.ArrayList;

import java.util.Comparator;

public class MergeSort {

    public static <T> ArrayList<T> sort(ArrayList<T> list, Comparator<T> comp) {
        if (list.size() < 2) return list;
        int mid = list.size() / 2;
        ArrayList<T> left = new ArrayList<>(mid);
        ArrayList<T> right = new ArrayList<>(list.size() - mid);
        for (int i = 0; i < list.size(); i++) {
            if (i < mid) {
                left.add(list.get(i));
                continue;
            }
            right.add(list.get(i));
        }
        left = sort(left, comp);
        right = sort(right, comp);
        ArrayList<T> merged = new ArrayList<>(left.size() + right.size());
        int i = 0, j = 0;
        while (i < left.size() || j < right.size()) {
            if (i >= left.size()) { merged.add(right.get(j++)); continue; }
            if (j >= right.size()) { merged.add(left.get(i++)); continue; }
            if (comp.compare(left.get(i), right.get(j)) <= 0) merged.add(left.get(i++));
            else merged.add(right.get(j++));
        }
        return merged;
    }

}
