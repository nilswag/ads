import algorithms.PQSort;
import algorithms.SelectionSort;
import structures.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 30; i >= 0; i--) list.add(i);
        SelectionSort.sort(list, Integer::compare);
        System.out.println(list);
    }

}
