package ua.edu.ucu.smartarr;

import ua.edu.ucu.SmartArrayApp;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

/**
 * Created by matt on 11/16/16.
 */
public class DecoratorMain {

    public static void main(String args[]) {
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


        Integer[] myIntArr = new Integer[]{1, 3, -2, 4, 4, 5, 1, 1, -1};
        System.out.println("Starting array: ");
        System.out.println(Arrays.toString(myIntArr));
        System.out.println();
        BaseArray myBase = new BaseArray(myIntArr);
        DistinctDecorator myDistinct = new DistinctDecorator(myBase);
        System.out.println(Arrays.toString(myDistinct.toArray()));
        System.out.println();
        FilterDecorator myFilter = new FilterDecorator(myBase, pr);
        System.out.println(Arrays.toString(myFilter.toArray()));
        System.out.println();
        MapDecorator myMap = new MapDecorator(myBase, func);
        System.out.println(Arrays.toString(myMap.toArray()));
        System.out.println();
        SortDecorator mySort = new SortDecorator(myBase, cmp);
        System.out.println(Arrays.toString(mySort.toArray()));


    }
}
