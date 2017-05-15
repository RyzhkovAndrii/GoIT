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
    private List<Integer> intList = new ArrayList<>();

    /**
     * Increases the value of all elements in this collection
     *
     * @param value the value on which the values of all elements increase
     */
    private void increaseElementsValue(int value) {
        for (Integer element : intList) {
            element += value;
        }
    }

    /**
     * Decreases the value of all elements in this collection
     *
     * @param value the value on which the values of all elements decrease
     */
    private void decreaseElementsValue(int value) {
        for (Integer element : intList) {
            element -= value;
        }
    }

    /**
     * Add a new integer element in this collection and increases the value of all
     * elements in the collection on its value
     *
     * @param element the element which is added in the collection
     */
    void add(int element) {
        increaseElementsValue(element);
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
        decreaseElementsValue(value);
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
            decreaseElementsValue(value);
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
     * @return the value of maximal element, or ... if this collection
     * does not contain the element.
     */
    Integer getMax() {
        /*if (intList.size() == 0) {
            return 0;
        }*/

        int max = Integer.MIN_VALUE;
        for (Integer element : intList) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Find minimal element in this collection
     *
     * @return the value of minimal element, or ... if this collection
     * does not contain the element.
     */
    Integer getMin() {
        /*if (intList.size() == 0) {
            return 0;
        }*/
        int min = Integer.MAX_VALUE;
        for (Integer element : intList) {
            if (element > min) {
                min = element;
            }
        }
        return min;
    }

    /**
     * Find average of all element in this collection
     *
     * @return average, or ... if this collection
     * does not contain the element.
     */
    Integer getAverage() {
        /*if (intList.size() == 0) {
            return 0;
        }*/
        int average = 0;
        for (Integer element : intList) {
            average += element;
        }
        return average / intList.size();
    }

}
