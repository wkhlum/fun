import java.util.Arrays;

public class Stack<T> {
    private T[] values;
    private int top;
    
    public Stack() {
        values = (T[])new Object[10];
        top = 0;
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public void push(T value) {
        if (top == values.length) {
            values = Arrays.copyOf(values, values.length * 2);
        }
        values[top++] = value;
    }
    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return values[--top];
    }
}