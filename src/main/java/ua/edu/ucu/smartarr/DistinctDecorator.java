package ua.edu.ucu.smartarr;

import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        int j = 0;  // index of last distinctElements element
        Object[] distinctElements = new Object[smartArray.size()];
        Object[] origin = smartArray.toArray();


        HashSet<Object> isPresent = new HashSet<>();

        for (int i = 0; i < smartArray.size(); i++) {
            if (!isPresent.contains(origin[i])) {
                isPresent.add(origin[i]);
                distinctElements[j++] = origin[i];
            }
        }

        Object[] result = new Object[j];
        System.arraycopy(distinctElements, 0, result, 0, j);
        return result;
    }
}
