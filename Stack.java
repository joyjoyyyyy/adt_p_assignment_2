public class Stack<T> {
    private Node<T> top;
    private int size;
    private static final int MAX_SIZE = 1000;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        if (size == MAX_SIZE) {
            throw new StackException();
        }
        Node<T> node = new Node<>(data);
        node.setNext(top);
        top = node;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new StackException();
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() {
        if (size == 0) {
            throw new StackException();
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
