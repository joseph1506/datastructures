package dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        int[] numbers={2,3,5,8};
        int targetSum=8;
        Map<Integer,List> memo= new HashMap<>();
        System.out.println(howSum(targetSum,numbers,memo));
    }

    private static List howSum(int targetSum, int[] numbers, Map<Integer,List> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum==0) return new ArrayList();
        if(targetSum<0) return null;
        int minLength=Integer.MAX_VALUE;
        for(int number:numbers){
           int remainder= targetSum-number;
           List elements= howSum(remainder,numbers,memo);
           if(elements!=null && elements.size()<minLength){
               minLength=elements.size();
               elements.add(number);
               memo.put(targetSum,elements);
           }
        }
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }else{
            memo.put(targetSum,null);
            return null;
        }
    }
}
