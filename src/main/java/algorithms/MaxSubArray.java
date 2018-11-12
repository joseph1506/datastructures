package algorithms;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] numbers =  {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayBrute(numbers));
        System.out.println(maxKaydenAlgo(numbers));
    }

    private static int maxKaydenAlgo(int[] numbers) {
        int maxSum = numbers[0];
        int maxCurrent = numbers[0];

        for(int i=1;i<numbers.length;i++){
            maxCurrent = Math.max(numbers[i], maxCurrent+numbers[i]);
            maxSum = Math.max(maxSum, maxCurrent);
        }
        return maxSum;
    }

    // Brute force O(N2)
    private static int maxSubArrayBrute(int[] numbers) {
        int sum =0;
        for(int i=0;i<numbers.length;i++){
            int total =numbers[i];
            for(int j= i+1;j<numbers.length;j++){
                   total = total+numbers[j];
                   if(total>sum){
                       sum = total;
                   }
            }
        }
        return sum;
    }


}
