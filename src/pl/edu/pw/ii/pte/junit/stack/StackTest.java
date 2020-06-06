package pl.edu.pw.ii.pte.junit.stack;

import org.junit.jupiter.api.Test;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void afterPopStackIsEmptyAgain() {
        Stack s = new Stack();
        s.push(1);
        s.pop();
        assertTrue(s.isEmpty());
    }

    @Test
    public void afterPushStackIsNoTEmpty() {
        Stack s = new Stack();
        s.push(1);
        assertFalse(s.isEmpty());
    }

    @Test
    public void newlyCreatedStackIsEmpty() {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
    }

    @Test
    public void emptyStackThrowsOnPop() {
        assertThrows(EmptyStackException.class, () -> {
            Stack s = new Stack();
            s.pop();
        });
    }

    @Test
    public void positivePopTest() {
        Stack s = new Stack();
        s.push(1234);
        assertEquals(1234, s.pop());
    }


    @Test
    public void notEmptyStackAfterTwoPushesAndOnePop() {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.pop();
        assertFalse(s.isEmpty());
    }

    @Test
    public void stackThrowsWhenTryingToPushMoreThanMaximumCapacity() {
        assertThrows(BufferOverflowException.class, () -> {

            Stack s = new Stack();
            for (int i = 0; i < Stack.maxCapacity + 1; ++i)
                s.push(i);
        });
    }

    @Test
    public void stackIsEmptyAfterClearingEmptyStack() {
        Stack s = new Stack();
        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    public void stackIsEmptyAfterClearingStackAfterTwoPushesAndOnePop() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.pop();
        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    public void stackIsEmptyAfterClearingStackWithPushedElement() {
        Stack s = new Stack();
        s.push(1);
        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    public void returnMaximumCapacityForFullStack() {
        Stack s = new Stack();
        for (int i = 0; i < Stack.maxCapacity; i++) {
            s.push(i);
        }
        assertEquals(Stack.maxCapacity, s.getSize());
    }

    @Test
    public void returnTwoForTwoElementStack() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        assertEquals(2, s.getSize());
    }

    @Test
    public void returnOneForOneElementStack() {
        Stack s = new Stack();
        s.push(1);
        assertEquals(1, s.getSize());
    }

    @Test
    public void returnZeroForEmptyStack() {
        Stack s = new Stack();
        assertEquals(0, s.getSize());
    }

    @Test
    public void increasemaxcapa() {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.increaseMaxCapacity(20);

        for (int i = 0; i < 12; i++){
            s.push(i);
        }

        assertTrue(s.getSize() == 14);

    }

    @Test
    public void increasemaxcapawithsmallervalue() {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.increaseMaxCapacity(8);

        for (int i = 0; i < 5; i++){
            s.push(i);
        }

        assertTrue(s.getSize() == 7);

    }

}
