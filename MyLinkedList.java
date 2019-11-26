package Lists;

public class MyLinkedList<T> {

    private Node _first;
    private int _size;

    public MyLinkedList() {
        _first = null;
        _size = 0;
    }

    public int getSize() {
        return _size;
    }

    public void add(T value) {
        Node current = _first;

        if (current == null) {
            _first = new Node(value);
            _size++;
            return;
        }

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new Node(value));
        _size++;
    }

    public void remove(int index) {
        Node current = _first;
        Node next = current.getNext();

        if (_first.getData().equals(index)) {
            if (_size == 1) {
                _first.setData(null);
                _size--;
                return;
            }
            _first.setData(null);
            _first = _first.getNext();
            _size--;
            return;
        }

        while (next != null) {
            if (next.getData().equals(index)) {
                current.setNext(next.getNext());
                next = null;
                _size--;
                return;
            }
            current = next;
            next = current.getNext();
        }
    }

    private class Node<T> {

        private T _data;
        private Node _next;

        public Node(T data) {
            _data = data;
            _next = null;
        }

        public void setData(T data) {
            _data = data;
        }

        public T getData() {
            return _data;
        }

        public void setNext(Node next) {
            _next = next;
        }

        public Node getNext() {
            return _next;
        }
    }
}
