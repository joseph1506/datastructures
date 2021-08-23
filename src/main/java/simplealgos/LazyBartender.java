package simplealgos;

import java.util.*;
import java.util.function.Function;

public class LazyBartender {

    public static void main(String[] args) {
        Map<Integer, int[]> custPrefDrinks= new HashMap<>();

        custPrefDrinks.put(0,new int[]{0,1,3,6});
        custPrefDrinks.put(1,new int[]{1,4,7});
        custPrefDrinks.put(2,new int[]{2,4,7,5});
        custPrefDrinks.put(3,new int[]{3,2,5});
        custPrefDrinks.put(4,new int[]{5,8});

        System.out.println(minDrinksToMake(custPrefDrinks,5,9));


    }

    private static int minDrinksToMake(Map<Integer, int[]> custPrefDrinks, int customers, int drinks) {
        Map<Integer, ArrayList> drinkCustMap= new HashMap<>();

        for(Integer customer:custPrefDrinks.keySet()){
            int[] prefDrinks= custPrefDrinks.get(customer);
            for(int prefDr:prefDrinks){
                drinkCustMap.putIfAbsent(prefDr,new ArrayList());
                drinkCustMap.get(prefDr).add(customer);
            }
        }
        System.out.println(drinkCustMap);
        return 0;

    }


}
