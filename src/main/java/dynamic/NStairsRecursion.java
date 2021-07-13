package dynamic;

import java.util.Arrays;

public class NStairsRecursion {

    public static void main(String[] args) {
        int[] steps= new int[]{1,2};
        int[] memo= new int[11];
        Arrays.fill(memo,-1);
        System.out.println(countWays(10,steps,memo));
    }

    private static int countWays(int target, int[] steps,int[] memo) {
        if(target<0) return 0;
        if(memo[target]!=-1) return memo[target];
        if(target==0) return 1;
        int count=0;
        for(int i=0;i<steps.length;i++){
            count+= countWays(target-steps[i],steps,memo);
        }
        memo[target]=count;
        return count;
    }


}
