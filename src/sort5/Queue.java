package sort5;

public class Queue {
    private Object[] queue;
    private int rear = 0;
    private int front = 0;
    private int queueSize;


    public Queue(int size) {
        this.queue = new Object[size];
        this.queueSize = size;
    }
    public boolean enqueue(Object data){

        if(isFull()) return false;
        rear = (rear+1) % queueSize;
        queue[rear] = data;
        return true;
    }

    public Object dequeue() {
        if(isEmpty()) return null;
        front = front+1 % queueSize;
        return queue[(front + 1) % queueSize];

    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return ((rear+1) % queueSize == front);
    }


}
