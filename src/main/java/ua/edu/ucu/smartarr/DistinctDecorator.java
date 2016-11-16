package ua.edu.ucu.smartarr;


import java.util.Arrays;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    
    public DistinctDecorator(SmartArray arr) {
        super(arr);
    }
    

    @Override
    public Object[] toArray() {
        Object[] insideArr = smartArray.toArray();
        Object[] tmp = new Object[insideArr.length];
        System.out.println(operationDescription());
        int k = 0;
        for (int i = 0; i < insideArr.length; ++i) {
            for (int j = i + 1; j < insideArr.length; ++j) {
              //  System.out.println(insideArr[i] + " " + insideArr[j]);
                if (insideArr[i].equals(insideArr[j])) break;
                if (j == insideArr.length - 1) {
                    tmp[k] = insideArr[i];
                    k++;
            //        System.out.println("ADDed" + insideArr[i]);
                }

            }
        }
        tmp[k] = insideArr[insideArr.length - 1];
        k++;

        return Arrays.copyOf(tmp, k);
    }

    @Override
    public String operationDescription() {
        return "Removing duplicates from array...";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
