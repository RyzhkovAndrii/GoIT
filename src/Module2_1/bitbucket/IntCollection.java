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
     * elements in the collection on his value
     *
     * @param element the element which is added in the collection
     */
    void add(Integer element) {
        increaseElementsValue(element);
        intList.add(element);
    }

    /**
     * Removes the element at the specified position in this collection.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    Integer removeByIndex(int index) {
        Integer value = intList.remove(index);
        decreaseElementsValue(value);
        return value;
    }

    boolean removeByValue(Integer value) {
        if (intList.remove(value)) {
            decreaseElementsValue(value);
            return true;
        }
        return false;
    }

    Integer getMax() {
        int max = Integer.MIN_VALUE;
        for (Integer element : intList) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    Integer getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer element : intList) {
            if (element > min) {
                min = element;
            }
        }
        return min;
    }





}
