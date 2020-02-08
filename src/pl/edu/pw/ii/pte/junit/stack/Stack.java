package pl.edu.pw.ii.pte.junit.stack;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

public class Stack {



    public static int maxCapacity = 10;
    private int size = 0;
    private int[] contents = new int[maxCapacity];

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int i) {
        if (size == maxCapacity) {
            throw new BufferOverflowException();
        }
        contents[size++] = i;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return contents[--size];
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        size = 0;
    }


}