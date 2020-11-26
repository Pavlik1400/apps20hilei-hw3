package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] arr;

    public BaseArray(Object[] values) {
        arr = values;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        System.arraycopy(arr, 0, result, 0, size());
        return result;
    }

    @Override
    public String operationDescription() {
        return getClass().getName();
    }

    @Override
    public int size() {
        return arr.length;
    }
}
