package hw6_PriorityQueueAndHeap;


public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {

    ArrEntry<K, E> heapPQ[];
    int n = 0;
    int defaultSize = 20;

    public MinHeapPriorityQueue() {
        heapPQ = new ArrEntry[defaultSize];
    }

    public void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

    protected void upHeap() {
        int i = n;
        while (i > 1 && heapPQ[i].getKey().compareTo(heapPQ[i / 2].getKey()) < 0) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    protected void downHeap() {
        int i = 1;
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && heapPQ[j].getKey().compareTo(heapPQ[j + 1].getKey()) > 0) {
                j++;
            }
            if (heapPQ[i].getKey().compareTo(heapPQ[j].getKey()) < 0) {
                swap(i, j);
            }
            i = j;
        }
    }


        public static void main (String[] args){
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
