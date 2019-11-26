package Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack<T> {
    private static final int DEFAULT_CAPACITY = 64;

    private ArrayList<T> data;

    private enum Action {
        GET_AND_REMOVE,
        GET_NO_REMOVE
    }

    public MyStack(final int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
    }

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public T push(T value) {
        data.add(value);
        return value;
    }

    public T remove(int index) {
    return getTrailingElement(Action.GET_AND_REMOVE);
    }


    public T peek() {
        return getTrailingElement(Action.GET_NO_REMOVE);
    }

    public T pop() {
        return getTrailingElement(Action.GET_AND_REMOVE);
    }

    @Override
    public String toString() {
        return Arrays.toString(data.toArray());
    }

    public int search(Object o) {
        int distance = data.lastIndexOf(o);

        if (distance > -1)
            distance = data.size() - distance;

        return distance;
    }

    private T getTrailingElement(Action behaviourType) {
        if (data.isEmpty())
            throw new NoSuchElementException();

        T item;
        if (behaviourType == Action.GET_NO_REMOVE)
            item = data.get(data.size() - 1);
        else
            item = data.remove(data.size() - 1);

        return item;
    }
}
