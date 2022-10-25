package hw2_simplesort;

public class QuickSort {
    public static void main(String[] args) {
//        int[] numbers = {3, 9, 5, 6, 8, 4, 7, 2, 1};
        int[] numbers = new int[50];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random()*100);
        }
        int n = numbers.length;
        System.out.println("Before:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("After:");

        quickSort(numbers, 0, n-1);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int index = partition(arr, lowIndex, highIndex);
            quickSort(arr, lowIndex, index - 1);
            quickSort(arr, index + 1, highIndex);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr,i+1,high);
        return i+1;
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

