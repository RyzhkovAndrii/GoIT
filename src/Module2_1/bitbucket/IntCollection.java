package Module2_1.bitbucket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryzhkov Andrii on 14.05.2017.
 *
 * Необходимо реализовать коллекцию целых чисел, которая позволяет выполнять операции:
 * - добавления
 * - удаления
 * - поиска элемента по значению
 * - поиска элемента по индексу
 * - поиска максимального элемента
 * - поиска минимального элемента
 * - поиска среднего арифметического всех элементов
 *
 * При этом:
 * - при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
 * - при удалении - уменьшают своё значение на удаляемый элемент

 * Недопустим ввод в коллекцию null, символов и других значений, кроме целых чисел.

 * Результатом работы должен быть отдельный репозиторий github/bitbucket с README файлом, который описывает задание,
 * сам класс и содержит инструкции по запуску приложения.
 */

class IntCollection {

    /**
     * The ArrayList into which the elements of the IntCollection are stored.
     */
    private List<Integer> intList;

    /**
     * Constructs an empty collection
     */
    IntCollection() {
        intList = new ArrayList<>();
    }

    /**
     * Constructs an empty collection with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the collection
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    IntCollection(int initialCapacity) {
        intList = new ArrayList<>(initialCapacity);
    }

    /**
     * Constructs a collection containing the elements of the specified
     * IntCollection
     *
     * @param intCollection the collection whose elements are to be placed into this
     * @throws NullPointerException if the specified collection is null
     */
    IntCollection(IntCollection intCollection) {
        intList = new ArrayList<>(intCollection.size());
        for (int i = 0; i < intCollection.size(); i++) {
            intList.add(intCollection.get(i));
        }
    }

    /**
     * Return the size of this collection
     *
     * @return the size of this collection
     */
    private int size() {
        return intList.size();
    }

    /**
     * Check if this collection contains elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */

    private boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Increases the value of all elements in this collection
     *
     * @param value the value on which the values of all elements increase
     */
    private void increaseElementsValue(int value) {
        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) + value);
        }
    }

    /**
     * Decreases the value of all elements in this collection
     *
     * @param value the value on which the values of all elements decrease
     */
    private void decreaseElementsValue(int value) {
        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) - value);
        }
    }

    /**
     * Add a new integer element in this collection and increases the value of all
     * elements in the collection on its value
     *
     * @param element the element which is added in the collection
     */
    void add(int element) {
        this.increaseElementsValue(element);
        intList.add(element);
    }

    /**
     * Removes the element at the specified position in this collection and
     * decreases the value of all elements in the collection on its value.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException
     */
    Integer removeByIndex(int index) {
        Integer value = intList.remove(index);
        this.decreaseElementsValue(value);
        return value;
    }

    /**
     * Removes the first occurrence of the specified element from this
     * collection, if it is present, and decreases the value of all elements
     * in the collection on value.
     *
     * @param value the value of element which removes from this collection, if present
     * @return <tt>true</tt> if the element was removed from this collection
     */
    boolean removeByValue(Integer value) {
        if (intList.remove(value)) {
            this.decreaseElementsValue(value);
            return true;
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this collection
     *
     * @param index index of the element to return
     * @return the element at the specified position in this collection
     * @throws IndexOutOfBoundsException
     */
    Integer get(int index) {
        return intList.get(index);
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this collection does not contain the element.
     *
     * @param value the value of element which index returned from this
     * collection, if element present
     * @return the index of the element, or -1 if this collection does not contain the element
     */
    int indexOf(Integer value) {
        return intList.indexOf(value);
    }

    /**
     * Find maximal element in this collection
     *
     * @return the value of maximal element, or <tt>null</tt> if this collection
     * does not contain the element.
     */
    Integer getMaximal() {
        if (this.isEmpty()) {
            return null;
        }
        int maximal = Integer.MIN_VALUE;
        for (Integer element : intList) {
            if (element > maximal) {
                maximal = element;
            }
        }
        return maximal;
    }

    /**
     * Find minimal element in this collection
     *
     * @return the value of minimal element, or <tt>null</tt> if this collection
     * does not contain the element.
     */
    Integer getMinimal() {
        if (this.isEmpty()) {
            return null;
        }
        int minimal = Integer.MAX_VALUE;
        for (Integer element : intList) {
            if (element < minimal) {
                minimal = element;
            }
        }
        return minimal;
    }

    /**
     * Find average of all element in this collection
     *
     * @return average, or <tt>null</tt> if this collection does not contain the element.
     */
    Double getAverage() {
        if (this.isEmpty()) {
            return null;
        }
        double average = 0.0;
        for (Integer element : intList) {
            average += element;
        }
        return average / intList.size();
    }

}
