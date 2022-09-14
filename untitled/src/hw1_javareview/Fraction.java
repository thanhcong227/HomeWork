package hw1_javareview;

import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numerator1 = sc.nextInt();
        int denominator1 = sc.nextInt();
        int numerator2 = sc.nextInt();
        int denominator2 = sc.nextInt();
        if (denominator1 != 0 && denominator1 != 0) {
            System.out.println("fraction 1: " + numerator1 + "/" + denominator1);
            System.out.println("fraction 2: " + numerator2 + "/" + denominator2);
            plus(numerator1, denominator1, numerator2, denominator2);
            minus(numerator1, denominator1, numerator2, denominator2);
            times(numerator1, denominator1, numerator2, denominator2);
            division(numerator1, denominator1, numerator2, denominator2);
        } else {
            System.out.println("ERROR DENOMINATOR = 0");
        }
    }

    public static void plus(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator;
        int denominator;
        if (denominator1 == denominator2) {
            numerator = numerator1 + numerator2;
            denominator = denominator1;
        } else {
            numerator = numerator1 * denominator2 + numerator2 * denominator1;
            denominator = denominator1 * denominator2;
        }
        System.out.print("plus :");
        compact(numerator, denominator);
    }

    public static void minus(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator;
        int denominator;
        if (denominator1 == denominator2) {
            numerator = numerator1 - numerator2;
            denominator = denominator1;
        } else {
            numerator = numerator1 * denominator2 - numerator2 * denominator1;
            denominator = denominator1 * denominator2;
        }
        System.out.print("minus :");
        compact(numerator, denominator);
    }

    public static void times(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator = numerator1 * numerator2;
        int denominator = denominator1 * denominator2;
        System.out.print("times :");
        compact(numerator, denominator);
    }

    public static void division(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator;
        int denominator;
        numerator = numerator1 * denominator2;
        denominator = denominator1 * numerator2;
        System.out.print("division :");
        compact(numerator, denominator);
    }


    public static void compact(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        if (numerator == 0 || denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


}



