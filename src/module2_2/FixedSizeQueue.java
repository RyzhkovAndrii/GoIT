package module2_2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Andrii Ryzhkov on 23.05.2017.
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
     * Retrieves and removes the head of the queue, or returns
     * <tt>null</tt> if this queue is empty.
     *
     * @return the head of the queue <tt>null</tt> if this queue is empty
     */
    private E poll() {
        return fixedSizeQueue.poll();
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
        this.fixedSizeQueue = new ArrayDeque<>();
    }

    /**
     * Constructs an empty queue and set max size of queue
     *
     * @param  maxSize max size of queue
     */
    FixedSizeQueue(int maxSize) {
        this();
        this.maxSize = maxSize;
    }

    /**
     * Constructs a queue containing the elements of the specified
     * FixedSizeQueue. If the size of the specified FixedSizeQueue is bigger than
     * max size of this queue, then add only first elements of the specified
     * FixedSizeQueue which Can be placed in this queue
     *
     * @param queue the queue whose elements are to be placed into this
     */
    FixedSizeQueue(FixedSizeQueue<E> queue) {
        this();
        for (int elementsCount = maxSize; elementsCount > 0; elementsCount--) {
            E element = queue.poll();
            if (element == null) {
                return;
            }
            fixedSizeQueue.add(element);
        }
    }

    /**
     * Constructs a queue containing the elements of the specified
     * FixedSizeQueue.
     * Also set max size of queue
     *
     * @param queue the queue whose elements are to be placed into this
     */
    FixedSizeQueue(int maxSize,
                   FixedSizeQueue<E> queue) {
        this();
        this.maxSize = maxSize;
        for (int elementsCount = maxSize; elementsCount > 0; elementsCount--) {
            E element = queue.poll();
            if (element == null) {
                return;
            }
            fixedSizeQueue.add(element);
        }
    }

    /**
     * Inserts the element into the tail of this queue
     * If number of element of this queue is bigger than max size, then removed
     * the element from the head of this queue.
     *
     * @param element the element to add
     * @return removed element from the head of the queue
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null
     */
    E add(E element) {
        E head = null;
        if (this.size() == maxSize) {
            head = fixedSizeQueue.poll();
        }
        fixedSizeQueue.add(element);
        return head;
    }

}
