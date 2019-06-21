package functional.newtest;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.List;

public class Sample2 {

    public static final boolean isGTAndEven(int number){
        System.out.println("isGTAndEven "+number);
        return number >3 && number%2==0;
    }

    public static int doubleIt(int number){
        System.out.println("Double It "+number);
        return number*2;
    }

    public static void main(String[] args) {
        int result =0;
        List<Integer> numbers = Arrays.asList(1,2,5,4,7,3,8,10);
        for(Integer e:numbers){
            if(e>3 && e%2==0){
                result = 2 * e;
                break;
            }
        }
        System.out.println(result);

        numbers.stream()
                .filter(Sample2::isGTAndEven)
                //.filter(value-> value>3 && value%2==0)
                .map(Sample2::doubleIt)
                //.map(val-> val * 2)
                .findFirst();

    }
}
