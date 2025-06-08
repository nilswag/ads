package algorithms;

import structures.ArrayList;
import structures.PriorityQueue;

import java.util.Comparator;

public class PQSort {

    public static <T> ArrayList<T> sort(ArrayList<T> list, Comparator<T> comp) {
        PriorityQueue<T> queue = new PriorityQueue<>(comp);
        ArrayList<T> sorted = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) queue.add(list.get(i));
        while (!queue.isEmpty()) sorted.add(queue.poll());
        return sorted;
    }

}
