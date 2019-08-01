package functional;

import java.util.function.Function;

public class LambdaFunc {

    public static void printIt(Integer n, String msg, Function<Integer, Integer> func){
        System.out.println(n+" "+msg+"::"+func.apply(n));
    }

    public static void main(String[] args) {
        Function<Integer,Integer> inc= e->e+1;
        Function<Integer,Integer> doubled = e->e*2;
        Function<Integer,Integer> incAndDoubled= e-> doubled.apply(inc.apply(e));

        printIt(10,"incremented and doubled",inc.andThen(doubled));
        printIt(20,"incremented and doubled",incAndDoubled);
    }
}
