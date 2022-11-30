package hw5_BinaryTreeAndApplication;

import java.util.StringJoiner;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {

    protected static class Node<T> {
        private T element;        // an element stored at this node
        private Node<T> parent;    // a reference to the parent node (if any)
        private Node<T> left;    // a reference to the left child
        private Node<T> right;    // a reference to the right child

        // Constructs a node with the given element and neighbors. ∗/
        public Node(T e, Node<T> above, Node<T> leftChild, Node<T> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
    }

    public Node root;        // root of the tree
    private int size = 0;    // number of nodes in the tree

    //update methods
    public Node<E> addRoot(E element) {
        root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
        // Add element to left child of p
        Node<E> tree = new Node<>(element, p, null, null);
        size++;
        return tree;
    }

    public Node<E> addRight(Node p, E element) {
        // Add element to right child of p
        Node<E> tree = new Node<>(element, p, null, null);
        size++;
        return tree;
    }

    public void set(Node p, E element) {
        // Set element to p
        p.element = element;
    }


    @Override
    public E root() {
        return (E) root.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(E p) {
        // Return number of children of p
        int count = 0;
        if (root.left != null) {
            count++;
        }
        if (root.right != null) {
            count++;
        }
        return count;
    }

    @Override
    public E parent(E p) {
        //return parent of p
        return (E) root.parent;
    }

    @Override
    public E left(E p) {
        //return left child of p
        return (E) root.left.element;
    }

    @Override
    public E right(E p) {
        //return right child of p
        return (E) root.right.element;
    }

    @Override
    public E sibling(E p) {
        //return sibling of p
        if (root.left != null) {
            return (E) root.right.element;
        } else {
            return (E) root.left.element;
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.root = tree.addRoot(1);
        tree.root.left = tree.addLeft(tree.root, 2);
        tree.root.right = tree.addRight(tree.root, 3);
        tree.root.left.left = tree.addLeft(tree.root.left, 4);
        tree.root.left.right = tree.addRight(tree.root.left, 5);
        tree.root.right.left = tree.addLeft(tree.root.right, 6);
        tree.root.right.right = tree.addRight(tree.root.right, 7);
        System.out.println("root: " + tree.root());
        System.out.println("size: " + tree.size());
        System.out.println("isEmpty: " + tree.isEmpty());
        System.out.println("numChildren: " + tree.numChildren(1));
        System.out.println("parent: " + tree.parent(2));
        System.out.println("left: " + tree.left(2));
        System.out.println("right: " + tree.right(2));
        System.out.println("sibling: " + tree.sibling(2));
    }
}
