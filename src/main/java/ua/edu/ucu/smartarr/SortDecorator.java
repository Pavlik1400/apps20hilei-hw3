package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator comparator;
    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        Object[] sorted = new Object[size()];
        System.arraycopy(smartArray.toArray(), 0, sorted, 0, size());
        Arrays.sort(sorted, comparator);
        return sorted;
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
