package datastructure2;

public class Deque {
    DequeNode front;
    DequeNode rear;

    public Deque() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insertFront(char item) {
        DequeNode node = new DequeNode(item);
        if (isEmpty()) {
            front = node;
            rear = node;
            node.rlink = null;
            node.llink = null;
        } else {
            node.rlink = front;
            node.llink = null;
            front.llink = node;
            front = node;
        }
    }

    public char deleteFront() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
            return 0;
        } else {
            char data = front.data;
            if (front.rlink == null) {
                front = null;
                rear = null;
            } else {
                front = front.rlink;
                front.llink = null;
            }
            return data;
        }
    }

    public void insertRear(char item) {
        DequeNode node = new DequeNode(item);
        if (isEmpty()) {
            front = node;
            rear = node;
            node.rlink = null;
            node.llink = null;
        } else {
            node.llink = rear;
            node.rlink = null;
            rear.rlink = node;
            rear = node;
        }
    }

    public char deleteRear() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
            return 0;
        } else {
            char data = rear.data;
            if (rear.llink == null) {
                front = null;
                rear = null;
            } else {
                rear = rear.llink;
                rear.rlink = null;
            }
            return data;
        }
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
        } else {
            if (front.rlink == null) {
                front = null;
                rear = null;
            } else {
                front = front.rlink;
                front.llink = null;
            }
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
        } else {
            if (rear.llink == null) {
                front = null;
                rear = null;
            } else {
                rear = rear.llink;
                rear.rlink = null;
            }
        }
    }

    public char peekRear() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
            return 0;
        } else {
            return rear.data;
        }
    }

    public char peekFront() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
            return 0;
        } else {
            return front.data;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("덱이 비어있습니다.");
        } else {
            DequeNode node = front;
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.rlink;
            }
            System.out.println();
        }
    }

    public class DequeNode {
        char data;
        DequeNode llink;
        DequeNode rlink;

        public DequeNode() {
            this.llink = null;
            this.rlink = null;
        }

        public DequeNode(char data) {
            this.data = data;
            this.llink = null;
            this.rlink = null;
        }
    }
}


