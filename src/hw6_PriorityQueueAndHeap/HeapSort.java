package hw6_PriorityQueueAndHeap;

public class HeapSort extends MinHeapPriorityQueue {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> queue = new MinHeapPriorityQueue<>();
        queue.insert(3, "c");
        queue.insert(1, "a");
        queue.insert(2, "b");
        queue.insert(4, "d");
        queue.insert(5, "e");
        queue.insert(6, "f");
        queue.insert(7, "g");

        queue.downHeap();
        System.out.println(queue);
    }
}
