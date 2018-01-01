public class Queue<T> {
    private T[] values;
    private int front;
    private int back;
    
    public Queue() {
        values = (T[])new Object[10];
        front = 0;
        back = 0;
    }
    
    public boolean isEmpty() {
        return (front == back);
    }
    
    public void enqueue(T value) {
        if (front-back == 1) {
            int oldsize = values.length;
            T[] tmp = (T[])new Object[oldsize*2];
            for (int i = 0; i < oldsize; ++i) {
                tmp[i] = dequeue();
            }
            front = 0;
            back = oldsize;
            values = tmp;
        }
        values[back++] = value;
        if (back == values.length) {
            back = -1;
        }
    }
    
    public T dequeue() {
        if (isEmpty()) return null;
        T value = values[front++];
        if (front == values.length) {
            front = 0;
        }
        return value;
    }
}