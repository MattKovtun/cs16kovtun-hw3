package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    MyFunction myFunc;
    public MapDecorator(SmartArray arr, MyFunction func) {
        super(arr);
        this.myFunc = func;
    }

    @Override
    public Object[] toArray() {
        Object[] insideArr = smartArray.toArray();
        System.out.println(operationDescription());
        for (int i = 0; i < insideArr.length; ++ i) {
            insideArr[i] = myFunc.apply(insideArr[i]);
        }
        return insideArr;
    }

    @Override
    public String operationDescription() {
        return "Processing each element through the function...";
    }

    @Override
    public int size() {
        return 0;
    }
}
