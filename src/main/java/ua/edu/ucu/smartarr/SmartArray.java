package ua.edu.ucu.smartarr;

public interface SmartArray {
    // return array with SmartArray elements
    Object[] toArray();

    // return current operation name applied to SmartArray
    String operationDescription();

    int size(); // return SmartArray size
   
}
