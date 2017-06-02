package module2_2;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Andrii Ryzhkov on 23.05.2017.
 *
 * <tt>FixedSizeQueue<E><tt> is an implementation of the <tt>ArrayDeque<tt> with limited
 * numbers of elements.
 * Class contains the modified methods <tt>add<tt> that inserts the element
 * into the tail of this queue and if number of element of this queue is bigger than max size,
 * then removed the element from the head of this queue.
 *
 * @param <E> the type of elements held in this queue
 */

class FixedSizeQueue<E> {

    /**
     * The ArrayDeque into which the elements of the FixedSizeQueue are stored.
     */
    private Queue<E> fixedSizeQueue;

    /**
     * The max size of this queue. Default max size of this queue is 16.
     */
    private int maxSize = 16;

    /**
     * Checked if this queue is full.
     *
     * @return <tt>true</tt> if this queue is full
     */
    private boolean isFull() {
        return size() >= maxSize;
    }

    /**
     * Retrieves and removes the head of the queue, or returns
     * <tt>null</tt> if this queue is empty.
     *
     * @return the head of the queue <tt>null</tt> if this queue is empty
     */
    private E poll() {
        return fixedSizeQueue.poll();
    }

    /**
     * Set max size of this queue.
     * If setting max size is negative, then set max size in default
     *
     * @param  maxSize max size of queue
     */
    private void setMaxSize(int maxSize) {
        this.maxSize = maxSize >= 0 ? maxSize: 16;
    }

    /**
     * Return the size of this queue
     *
     * @return the size of this queue
     */
    private int size() {
        return fixedSizeQueue.size();
    }

    /**
     * Constructs an empty queue
     */
    FixedSizeQueue() {
        fixedSizeQueue = new ArrayDeque<>();
    }

    /**
     * Constructs an empty queue and set max size of queue
     *
     * @param  maxSize max size of queue
     */
    FixedSizeQueue(int maxSize) {
        this();
        setMaxSize(maxSize);
    }

    /**
     * Constructs a queue containing the elements of the specified
     * FixedSizeQueue. If the size of the fixedSizeQueue is bigger than
     * max size of this queue, then add only first elements of the
     * FixedSizeQueue which can be placed in this queue
     *
     * @param anotherQueue the queue whose elements are to be placed into this
     * @throws NullPointerException if the specified queue is null
     */
    FixedSizeQueue(FixedSizeQueue<E> anotherQueue) {
        this();
        add(anotherQueue);
    }

    /**
     * Constructs a queue containing the elements of the specified
     * FixedSizeQueue. If the size of the fixedSizeQueue is bigger than
     * max size of this queue, then add only first elements of the
     * FixedSizeQueue which can be placed in this queue
     * Also set max size of queue
     *
     * @param anotherQueue the queue whose elements are to be placed into this
     * @throws NullPointerException if the specified queue is null
     */
    FixedSizeQueue(int maxSize, FixedSizeQueue<E> anotherQueue) {
        this(maxSize);
        add(anotherQueue);
    }

    /**
     * Inserts the element into the tail of this queue
     * If number of element of this queue is bigger than max size, then removed
     * the element from the head of this queue.
     *
     * @param element the element to add
     * @return removed element from the head of the queue, or <tt>null</tt> if queue
     * is not full.
     * @throws ClassCastException if the class of the adding element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the adding element is null
     */
    E add(E element) {
        E head = isFull() ? fixedSizeQueue.poll() : null;
        fixedSizeQueue.offer(element);
        return head;
    }

    /**
     * Inserts elements of the specified FixedSizeQueue into this queue.
     * If number of element of this queue is bigger than max size, then removed
     * the element from the head of this queue (in other words, add only last elements
     * of the FixedSizeQueue in an amount equal to max size of this queue)
     *
     * @param anotherQueue the queue whose elements are to be placed into this
     * @throws ClassCastException if the class of the adding element the FixedSizeQueue
     *         prevents it from being added to this queue
     */
    void add(FixedSizeQueue<E> anotherQueue) {
        for (int index = 0; index < anotherQueue.size(); index++) {
            add(anotherQueue.get(index));
        }
    }

    /**
     * Returns the element at the specified position in this queue
     *
     * @param index index of the element to return
     * @return the element at the specified position in this queue
     * @throws IndexOutOfBoundsException
     */
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

    /**
     * This method created for testing this class only
     */

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
