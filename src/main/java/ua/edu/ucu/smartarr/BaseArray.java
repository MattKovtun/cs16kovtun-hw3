package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {

    Object[] myArr;

    public BaseArray(Object[] arr) {
        this.myArr = arr;
    }

    @Override
    public Object[] toArray() {
        Object[] tmp = new Object[myArr.length];
        System.arraycopy(myArr, 0, tmp, 0, myArr.length);
        return tmp;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return myArr.length;
    }
}
