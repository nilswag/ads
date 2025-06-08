import structures.MaxHeap;
import structures.MinHeap;

public class Main {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.push(-1);
        heap.push(-2);
        heap.push(-5);
        heap.push(7);
        heap.push(16);
        heap.push(23);
        heap.push(111);

        while (!heap.isEmpty()) {
            System.out.println(heap);
            heap.pop();
        }
    }

}
