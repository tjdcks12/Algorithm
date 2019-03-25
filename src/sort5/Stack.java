package sort5;

public class Stack {

    private int top = -1;
    private Object[] stack;

    public Stack(int size) {
        stack = new Object[size];
    }

    public Object pop() {
        if (isEmpty()) return null;
        return stack[top--];
    }

    public Object peek() {
        return stack[top];
    }

    public boolean push(Object data) {
        if (isFull()) return false;
        stack[++top] = data;
        return true;
    }

    public boolean isEmpty() {
        if (top == -1) return true;
        return false;
    }

    public boolean isFull() {
        return top == stack.length-1;
    }

    public int getSize() {
        return this.stack.length-1;
    }


}
