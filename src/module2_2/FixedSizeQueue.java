package module2_2;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

class FixedSizeQueue<E> {

   private Queue<E> fixedSizeQueue;

    private int maxSize = 16;

    private boolean isFull() {
        return size() >= maxSize;
    }

    private E poll() {
        return fixedSizeQueue.poll();
    }

    private void setMaxSize(int maxSize) {
        this.maxSize = maxSize >= 0 ? maxSize: 16;
    }

    private int size() {
        return fixedSizeQueue.size();
    }

    FixedSizeQueue() {
        fixedSizeQueue = new ArrayDeque<>();
    }

    FixedSizeQueue(int maxSize) {
        this();
        setMaxSize(maxSize);
    }

    FixedSizeQueue(FixedSizeQueue<E> anotherQueue) {
        this();
        add(anotherQueue);
    }

    FixedSizeQueue(int maxSize, FixedSizeQueue<E> anotherQueue) {
        this(maxSize);
        add(anotherQueue);
    }

    E add(E element) {
        E head = isFull() ? fixedSizeQueue.poll() : null;
        fixedSizeQueue.offer(element);
        return head;
    }

    void add(FixedSizeQueue<E> anotherQueue) {
        for (int index = 0; index < anotherQueue.size(); index++) {
            add(anotherQueue.get(index));
        }
    }

    E get(int index) {
        if (index >= maxSize || index < 0) {
            throw new IndexOutOfBoundsException("Index: "+index+", MaxSize: "+maxSize);
        }
        Iterator<E> iterator = fixedSizeQueue.iterator();
        int currentIndex = 0;
        E element = null;
        while (iterator.hasNext()) {
            element = iterator.next();
            if (currentIndex++ == index) {
                break;
            }
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (E element : fixedSizeQueue) {
            builder.append(element);
            builder.append(" ");
        }
        return "FixedSizeQueue{ " + builder.toString() + " }";
    }
}
