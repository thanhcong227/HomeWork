package hw2_simplesort;

public class SelectionSort {
    public static void main(String[] args) {
        int countCompare = 0;
        int countMove = 0;
        int[] a = {3, 9, 5, 6, 8, 4, 7, 2, 1};
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                countCompare += 1;
                if (a[min] > a[j]) {
                    int temp = min;
                    min = j;
                    j = temp;
                }
            }
            if (a[i] > a[min]) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
                countMove += 1;
            }
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
        System.out.println("Số lần so sánh :"+countCompare);
        System.out.println("Số lần di chuyển :"+countMove);
    }
}

