package hw1_javareview;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (perfectNumber(arr[i])) {
                System.out.println("Perfect number :"+arr[i]);
            } else {
                System.out.println("NOT Perfect number :"+arr[i]);
            }
        }
    }

    //kiem tra so hoan hao
    public static boolean perfectNumber(int m) {
        int sum = 0;
        for (int i = 1; i <= m / 2; i++) {
            if (m % i == 0) {
                sum += i;
            }
        }
        return sum == m;
    }
}
