package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;


public class SmartArrayApp {
    private static final int GOOD_POINT = 4;

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyByTwo(
                    Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObj, Object secondObj) {
                return ((Integer) firstObj) - ((Integer) secondObj);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFromSecondYearWithGPAgtFourAndOrderedBySurname(
                    Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        SmartArray array = new BaseArray(students);
        array = new DistinctDecorator(array);
        array = new FilterDecorator(array, new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2
                        && ((Student) t).getGpa() >= GOOD_POINT;
            }
        });
        array = new SortDecorator(array, new MyComparator() {
            @Override
            public int compare(Object firstObj, Object secondObj) {
                return ((Student) firstObj).getSurname().
                        compareTo(((Student) secondObj).getSurname());
            }
        });
        array = new MapDecorator(array, new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname()
                        + " " + ((Student) t).getName();
            }
        });
        Object[] result = array.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
