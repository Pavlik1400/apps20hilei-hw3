package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected final SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public String operationDescription() {
        return getClass().getName();
    }

    public int size() {
        return toArray().length;
    }

}
