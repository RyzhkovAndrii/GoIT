package Module2_1.bitbucket;

import java.util.ArrayList;
import java.util.List;

class IntCollection {

    private List<Integer> intList;

    IntCollection() {
        intList = new ArrayList<>();
    }

    IntCollection(int initialCapacity) {
        intList = new ArrayList<>(initialCapacity);
    }

    IntCollection(IntCollection intCollection) {
        intList = new ArrayList<>(intCollection.size());
        for (int i = 0; i < intCollection.size(); i++) {
            intList.add(intCollection.get(i));
        }
    }

    private int size() {
        return intList.size();
    }

    private boolean isEmpty() {
        return this.size() == 0;
    }

    private void increaseElementsValue(int value) {
        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) + value);
        }
    }

    private void decreaseElementsValue(int value) {
        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) - value);
        }
    }

    void add(int element) {
        this.increaseElementsValue(element);
        intList.add(element);
    }

    Integer removeByIndex(int index) {
        Integer value = intList.remove(index);
        this.decreaseElementsValue(value);
        return value;
    }

    boolean removeByValue(Integer value) {
        if (intList.remove(value)) {
            this.decreaseElementsValue(value);
            return true;
        }
        return false;
    }

    Integer get(int index) {
        return intList.get(index);
    }

    int indexOf(Integer value) {
        return intList.indexOf(value);
    }

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
