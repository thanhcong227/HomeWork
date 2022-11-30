package hw3_ADT_ListADT;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        // Thêm phần tử vào đầu danh sách
        Node node = new Node();
        node.data = data;
        if (top == null) {
            bot = node;
        } else {
            node.next = top;
        }
        top = node;
    }

    public void addBot(T data) {
        // Thêm phần tử vào cuối danh sách
        Node node = new Node();
        node.data = data;
        if (bot == null) {
            top = node;
        } else {
            bot.next = node;
        }
        bot = node;
    }

    public T get(int i) {
        // Trả về phần tử thứ i trong danh sách
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.data;
    }

    public void set(int i, T data) {
        // Gán giá trị data cho phần tử thứ i trong danh sách
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        node.data = data;
    }

    public boolean isContain(T data) {
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        Node node = top;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        // Trả về số phần tử trong danh sách
        return n;
    }

    public boolean isEmpty() {
        // Kiểm tra danh sách có rỗng hay không?
        return n == 0;
    }

        public T removeTop() {
        // Xóa phần tử đầu danh sách
        T data = top.data;
        top = top.next;
        n--;
        return data;
    }
    public T removeBot() {
        // Xóa phần tử cuối danh sách
        T data = bot.data;
        Node node = top;
        while (node.next != bot) {
            node = node.next;
        }
        node.next = null;
        bot = node;
        n--;
        return data;
    }
    public void remove(T data) {
        // Xóa tất cả các phần tử có giá trị bằng data
        Node node = top;
        while (node != null) {
            if (node.data.equals(data)) {
                node.data = null;
            }
            node = node.next;
        }
    }

}
