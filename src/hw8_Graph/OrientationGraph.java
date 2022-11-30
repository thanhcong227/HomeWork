package hw8_Graph;

public class OrientationGraph {

    int[][] matrix;
    int n;
    int vertex;

    public int[] outgoingEdges(int u) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[u][i] != 0) {
                count++;
            }
        }
        int[] outgoing = new int[count];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[u][i] != 0) {
                outgoing[j] = i;
                j++;
            }
        }
        return outgoing;
    }

    public int[] incomingEdges(int u) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][u] != 0) {
                count++;
            }
        }
        int[] incoming = new int[count];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][u] != 0) {
                incoming[j] = i;
                j++;
            }
        }
        return incoming;
    }

    public OrientationGraph(int n) {
        this.n = n;
        matrix = new int[n][n];
    }


    public int numVertices() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    vertex++;
                }
            }
        }
        return vertex;
    }



    public int Degree(int u) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[u][i] != 0) {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][u] != 0) {
                count++;
            }
        }
        return count;
    }

    public void insertVertex(int u) {
        if (u > n) {
            System.out.println("The vertex does not exist");
        } else {
            matrix[u][u] = 1;
        }
    }

    public void removeVertex(int u) {
        if (u > n) {
            System.out.println("The vertex does not exist");
        } else {
            for (int i = 0; i < n; i++) {
                matrix[i][u] = 0;
            }
            for (int i = 0; i < n; i++) {

            }
        }
    }

}
