package algorithms;

import java.util.Stack;

public class MaximumHistogramArea {

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,3,3,2};
        System.out.println(maxArea(arr));

    }

    private static int maxArea(int[] histogram) {
        if(histogram==null || histogram.length==0) return 0;

        Stack<Integer> indexes= new Stack<>();
        int counter=0;
        int maxArea=0;
        while(counter<histogram.length){
            if(indexes.isEmpty()||histogram[counter] >= histogram[indexes.peek()]){
                indexes.push(counter);
                counter++;
            } else {
                int currIndex= indexes.pop();
                int intervalForArea= indexes.isEmpty()?counter-1:counter-1-indexes.peek();
                int area= histogram[currIndex] * intervalForArea;
                maxArea= Math.max(maxArea,area);
            }
        }

        while(!indexes.isEmpty()){
            int currIndex= indexes.pop();
            int intervalForArea= indexes.isEmpty()?counter-1:counter-1-indexes.peek();
            int area= histogram[currIndex] * intervalForArea;
            maxArea= Math.max(maxArea,area);
        }
        return maxArea;
    }


}
