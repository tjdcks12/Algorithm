package sort5;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;


    public Node addFirst(Object data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
        if(head == null){
            tail = node;
        }
        return node;
    }

    public Node addLast(Object data) {
        if(size == 0) addFirst(data);

        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;

        return node;
    }

    public Object removeFirst() {
        Node tmp = head;
        head = tmp.next;
        Object data = tmp.data;

        tmp = null;
        size--;

        return data;
    }


    public class Node {
        private Node next;
        private Object data;


        public Node(Object data){
            this.data = data;
            this.next = null;
        }

    }
}
