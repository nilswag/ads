import algorithms.HeapSort;
import structures.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 30; i >= 0; i--) list.add(i);
        HeapSort.sort(list, Integer::compare);
        System.out.println(list);
    }

}
