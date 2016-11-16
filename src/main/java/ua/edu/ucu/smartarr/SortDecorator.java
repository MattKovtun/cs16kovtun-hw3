package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    MyComparator myComp;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        this.myComp = comp;
    }

    @Override
    public Object[] toArray() {
        Object[] insideArr = smartArray.toArray();
        System.out.println();
        Arrays.sort(insideArr, myComp);
        return insideArr;
    }

    @Override
    public String operationDescription() {
        return "Doing comparisons according to the comparator...";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
