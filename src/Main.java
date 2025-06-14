import algorithms.QuickSort;
import structures.ArrayList;

import java.util.Random;

public class Main {

    private static ArrayList<Integer> sample(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(max - min) + min);
        }
        return numbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = sample(50, 0, 200);
        System.out.println(list);
        QuickSort.sort(list, Integer::compare);
    }

}
