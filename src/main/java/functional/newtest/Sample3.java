package functional.newtest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

interface Selector {
    public boolean pick(Integer value);
}

public class Sample3 {

    public static void main(String[] args) {
        List<Integer> values= Arrays.asList(11,2,3,4,6,2,3,45,55);
        totalValues(values, e-> e>8);
    }

    private static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        /*int result=0;
        for(int e:values){
            if(selector.pick(e)) result+=e;
        }
        return result;*/
        return values.stream()
                .filter(selector)
                .reduce(0, Math::addExact);


    }
}
