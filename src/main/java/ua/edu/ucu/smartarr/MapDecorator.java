package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        int j = 0;
        Object[] mapped = new Object[size()];
        Object[] origin = smartArray.toArray();

        for (int i = 0; i < size(); i++) {
            mapped[j++] = function.apply(origin[i]);
        }

        Object[] result = new Object[j];
        System.arraycopy(mapped, 0, result, 0, j);
        return result;
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
