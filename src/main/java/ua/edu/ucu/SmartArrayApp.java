package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {
    private static final int goodPoint = 4;

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(
                    Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
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
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                    Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        SmartArray array = new BaseArray(students);
        array = new DistinctDecorator(array);
        array = new FilterDecorator(array, new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2 &&
                        ((Student) t).getGPA() >= goodPoint;
            }
        });
        array = new SortDecorator(array, new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().
                        compareTo(((Student) o2).getSurname());
            }
        });
        array = new MapDecorator(array, new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() +
                        " " + ((Student) t).getName();
            }
        });
        Object[] result = array.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
