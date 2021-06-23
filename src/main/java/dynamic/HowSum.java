package dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

    public static void main(String[] args) {
        int[] numbers={7,2,14};
        int targetSum=300;
        Map<Integer,List> memo= new HashMap<>();
        System.out.println(howSum(targetSum,numbers,memo));
    }

    private static List howSum(int targetSum, int[] numbers, Map<Integer,List> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum==0) return new ArrayList();
        if(targetSum<0) return null;

        for(int number:numbers){
           int remainder= targetSum-number;
           List elements= howSum(remainder,numbers,memo);
           if(elements!=null){
               elements.add(number);
               memo.put(targetSum,elements);
               return elements;
           }
        }
        memo.put(targetSum,null);
        return null;
    }
}
