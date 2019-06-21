package functional.newtest;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Sample {

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(5));
    }

    private Predicate<Integer> integerPredicate = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return false;
        }
    };

    private static boolean isPrime(int number) {
        /*for(int i=2;i<number;i++){
            if(number%i==0) return false;
        }
        return number>1;*/
        IntPredicate isDivisible = divisor-> number%divisor==0;
        return number>1 &&
                IntStream.range(2, number)
                .noneMatch(isDivisible);

    }
}
