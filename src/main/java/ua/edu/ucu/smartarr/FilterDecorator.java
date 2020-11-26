package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        int j = 0;
        Object[] filtered = new Object[smartArray.size()];
        Object[] origin = smartArray.toArray();

        for (int i = 0; i < smartArray.size(); i++) {
            if (predicate.test(origin[i])) {
                filtered[j++] = origin[i];
            }
        }

        Object[] result = new Object[j];
        System.arraycopy(filtered, 0, result, 0, j);
        return result;
    }
}
