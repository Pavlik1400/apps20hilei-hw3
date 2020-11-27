package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.*;

/**
 *
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        
        Integer[] res = 
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};
        
        assertArrayEquals(expectedRes, res);        
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
            new Student("Ivar", "Grimstad", 3.9, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Antons", "Kranga", 4.0, 2),
            new Student("Burr", "Sutter", 4.2, 2),
            new Student("Philipp", "Krenn", 4.3, 3),
            new Student("Tomasz", "Borek", 4.1, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames = 
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void operationDescriptionTest() {
        SmartArray arr = new BaseArray(new Object[]{1, 2, 3, 4, 5, 5, -9, 12, -14});
        assertEquals(arr.operationDescription(), "ua.edu.ucu.smartarr.BaseArray");

        arr = new DistinctDecorator(arr);
        assertEquals(arr.operationDescription(), "ua.edu.ucu.smartarr.DistinctDecorator");

        arr = new FilterDecorator(arr, new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        });
        assertEquals(arr.operationDescription(), "ua.edu.ucu.smartarr.FilterDecorator");

        arr = new MapDecorator(arr, new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Integer)t) * ((Integer)t);
            }
        });
        assertEquals(arr.operationDescription(), "ua.edu.ucu.smartarr.MapDecorator");

        arr = new SortDecorator(arr, new MyComparator() {
            @Override
            public int compare(Object firstObj, Object secondObj) {
                return (((Integer)firstObj) > ((Integer)secondObj)) ? 1 : 0;
            }
        });
    }

    @Test
    public void studentEqualsTest() {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Ittai", "Zeidman", 4.5, 1)};
        assertEquals(students[1], students[2]);
        assertNotEquals(students[0], students[1]);
        assertEquals(students[0], students[0]);
        assertNotEquals(students[0], null);
        assertNotEquals(students[0], new Object());
    }

    @Test
    public void studentTestToString() {
        Student student = new Student("Pavlo", "Hilei", 12000, 2);
        assertEquals(student.toString(), "Student{name=Pavlo, surname=Hilei, GPA=12000.0, year=2}");
    }

    @Test
    public void smartArrayAppConstructor() {
        SmartArrayApp app = new SmartArrayApp();
    }
}