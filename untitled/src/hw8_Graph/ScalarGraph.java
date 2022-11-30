package hw8_Graph;
import java.util.Scanner;
public class ScalarGraph {
    private int[][] matrix;
    int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
    }

    public int numEdges() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public void getEdge(int u, int v) {
        if (matrix[u][v] != 0) {
            System.out.println("The edge is " + matrix[u][v]);
        } else {
            System.out.println("The edge does not exist");
        }
    }

    public int Degree(int u) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[u][i] != 0) {
                count++;
            }
        }
        return count;
    }

    public void insertEdge(int u, int v, int w) {
        if (u > n || v > n) {
            System.out.println("The vertex does not exist");
        } else {
            matrix[u][v] = w;
        }
    }

    public void removeEdge(int u, int v) {
        if (u > n || v > n) {
            System.out.println("The vertex does not exist");
        } else {
            matrix[u][v] = 0;
        }
    }
}