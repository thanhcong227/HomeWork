package hw3_ADT_ListADT;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        // Hàm dựng với kích thước mảng là capacity
        array = (T[]) new Object[capacity];
    }


    @Override
    public void add(Object data) {
        if (n == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[n++] = (T) data;
    }

    public T get(int i) {
        // Hoàn thành thân hàm
        return array[i];
    }

    @Override
    public void set(int i, Object data) {
        array[i] = (T) data;
    }

    @Override
    public void remove(Object data) {
        T[] newArray = (T[]) new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        newArray[array.length] = (T) data;
        for (T i : newArray) {
            System.out.println(i + " ");
        }
    }

    public boolean isContain(Object data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != data)
                return false;
        }
        return true;
    }

    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        for (int i = 0; i < array.length; i++) {
            if (null != array[i])
                return false;
        }
        return true;
        // Hoàn thành thân hàm
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < n;
            }

            @Override
            public T next() {
                return array[n + 1];
            }
        };
        //Trả về toàn bộ danh sách
        // Hoàn thành thân hàm
    }
}
