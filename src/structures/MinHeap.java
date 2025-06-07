package structures;

public class MinHeap <T> {

    private ArrayList<T> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    private T leftChild(int index) { return list.get(getLeftChildIndex(index)); }

    private T rightChild(int index) { return list.get(getRightChildIndex(index)); }

    private T parent(int index) { return list.get(getParentIndex(index)); }

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }

    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }

    private int getParentIndex(int childIndex) { return (childIndex - 1 ) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < list.size(); }

    private boolean hasRightchild(int index) { return getRightChildIndex(index) < list.size(); }

    private boolean hasParent(int index) { return getParentIndex(index) < list.size(); }

}
