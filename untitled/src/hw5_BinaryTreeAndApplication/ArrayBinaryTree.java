package hw5_BinaryTreeAndApplication;

public class ArrayBinaryTree implements BinaryTreeInterface<Integer> {
    private int[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = new int[defaultSize];
    }

    //update methods
    public void setRoot(int element) {
        // Set element to root of an empty tree (at index 1)
        if (n == 0) {
            n++;
            array[1] = element;
        }
    }

    public void setLeft(int p, int element) {
        // Set left child of p (at index 2p)
        if (n == 0)
            throw new IllegalStateException("Tree is empty");
        else {
            n++;
            array[2 * p] = element;
        }
    }

    public void setRight(int p, int element) {
        // Set right child of p (at index 2p+1)
        if (n == 0)
            throw new IllegalStateException("Tree is empty");
        else {
            n++;
            array[2 * p + 1] = element;
        }
    }

    @Override
    public Integer root() {
        // Return root of tree
        return array[1];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(Integer p) {
        // Return number of children of p
        int count = 0;
        if (array[2 * p] != 0) {
            count++;
        }
        if (array[2 * p + 1] != 0) {
            count++;
        }
        return count;
    }

    @Override
    public Integer parent(Integer p) {
        // Return parent of p
        return array[p / 2];
    }

    @Override
    public Integer left(Integer p) {
        // Return left child of p
        return array[2 * p];
    }

    @Override
    public Integer right(Integer p) {
        // Return right child of p
        return array[2 * p + 1];
    }

    @Override
    public Integer sibling(Integer p) {
        // Return sibling of p
        if (p % 2 == 0) {
            return array[p + 1];
        } else {
            return array[p - 1];
        }
    }


    public static void main(String[] args) {
        ArrayBinaryTree tree = new ArrayBinaryTree();
        tree.setRoot(1);
        tree.setLeft(1, 2);
        tree.setRight(1, 3);
        tree.setLeft(2, 4);
        tree.setRight(2, 5);
        tree.setLeft(3, 6);
        tree.setRight(3, 7);
        System.out.println("Root: " + tree.root());
        System.out.println("Size: " + tree.size());
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Number of children of 1: " + tree.numChildren(1));
        System.out.println("Number of children of 2: " + tree.numChildren(2));
        System.out.println("Number of children of 3: " + tree.numChildren(3));
        System.out.println("Parent of 1: " + tree.parent(1));
        System.out.println("Parent of 2: " + tree.parent(2));
        System.out.println("Parent of 3: " + tree.parent(3));
        System.out.println("Left child of 1: " + tree.left(1));
        System.out.println("Left child of 2: " + tree.left(2));
        System.out.println("Left child of 3: " + tree.left(3));
        System.out.println("Right child of 1: " + tree.right(1));
        System.out.println("Right child of 2: " + tree.right(2));
        System.out.println("Right child of 3: " + tree.right(3));
        System.out.println("Sibling of 1: " + tree.sibling(1));
        System.out.println("Sibling of 2: " + tree.sibling(2));
        System.out.println("Sibling of 3: " + tree.sibling(3));
    }
}

