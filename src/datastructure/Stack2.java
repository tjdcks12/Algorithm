package datastructure;

public class Stack2 {

    private int[] stack;
    private int top = -1;
    private int size;

    public Stack2(int size){
        stack = new int[size];
    }

    public int peek(){
        if(top != -1){
            return this.stack[top];
        } else {
            return -1;
        }
    }

    public int pop(){
        if(top != -1){
            return this.stack[top--];
        } else{
            return -1;
        }
    }

    public void push(int data) {
        if(stack.length > top+1){
            stack[++top] = data;
            this.size++;
        } else {
            System.out.println("푸시 불가");
        }
    }

    public static void main(String[] args){
        Stack2 stack = new Stack2(3);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
