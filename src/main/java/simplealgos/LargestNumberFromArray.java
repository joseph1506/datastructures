package simplealgos;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFromArray {
    public static void main(String[] args) {
        int[] numbers= {1, 34, 3, 98, 9, 76, 45, 4};
        System.out.println(largestNumberNLogN(numbers));
    }
    static Comparator<Integer> customComp= new Comparator<Integer>() {
        @Override
        public int compare(Integer X, Integer Y) {
            String XY= ""+X+Y;
            String YX= ""+Y+X;
            return XY.compareTo(YX)>0?-1:1;
        }
    };

    private static String largestNumberNLogN(int[] numbers){
        if(numbers==null || numbers.length==0) return "";

        StringBuilder combined=new StringBuilder();
        Arrays.stream(numbers)
                .boxed()
                .sorted(customComp)
                .map(value -> String.valueOf(value.intValue()))
                .forEach(value-> {
                    combined.append(value);
                });
        return combined.toString();
    }




    //O(N square) logic type of bubble sort
    private static String largestNumber(int[] numbers) {
        if(numbers==null || numbers.length==0) return "";


        int N= numbers.length;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                long firstCombo= Long.parseLong(""+numbers[i]+numbers[j]);
                long secondCombo= Long.parseLong(""+numbers[j]+numbers[i]);
                if(secondCombo>firstCombo){
                    swap(i,j,numbers);
                }
            }
        }

        StringBuilder returnStr= new StringBuilder();
        for(int number:numbers){
            returnStr.append(number);
        }
        return returnStr.toString();
    }

    private static void swap(int i, int j, int[] numbers) {
        int temp=numbers[i];
        numbers[i]= numbers[j];
        numbers[j]=temp;
    }
}
