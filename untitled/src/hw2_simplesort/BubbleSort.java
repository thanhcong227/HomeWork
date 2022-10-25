package hw2_simplesort;

public class BubbleSort {
    public static void main(String[] args) {
        int countCompare = 0;
        int countMove = 0;
        int[] a = {3, 9, 5, 6, 8, 4, 7, 2, 1};
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                countCompare += 1;
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    countMove += 1;
                }
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Số lần so sánh :"+countCompare);
        System.out.println("Số lần di chuyển :"+countMove);
    }
}

