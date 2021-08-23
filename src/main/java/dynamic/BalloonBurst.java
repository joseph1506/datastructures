package dynamic;

import java.util.Arrays;

public class BalloonBurst {

    public static void main(String[] args) {

        int[] baloons= {3,1,5,8};
        System.out.println(maxCoinsFetched(baloons));
    }

    private static int maxCoinsFetched(int[] baloons) {
        if(baloons==null || baloons.length==0) return 0;
        int bLen= baloons.length;
        int[][] coins= new int[bLen][bLen];
        for(int i=0;i<bLen;i++){
            Arrays.fill(coins[i],0);
        }

        for(int win=1;win<=bLen;win++){

            for(int left=0;left<(bLen-win+1);left++){
                int right= left+win-1;

                //loop from left to right to find the maximum.... considering k as the last baloon burst
                // formula in the section left to right,     value left to K +  value when K is burst + value right to K
                for(int k=left;k<=right;k++){
                    int leftSection= (k-1)>=0?   coins[left][k-1]   :0;
                    int rightSection=(k+1)<bLen? coins[k+1][right]  :0;
                    int kBurstValue=leftSection+  getLeftBaloonValue(left,baloons) * baloons[k]* getRightBaloonValue(right,baloons) + rightSection;

                    coins[left][right]= Math.max(coins[left][right],
                            kBurstValue
                            );
                }
            }
        }
        return coins[0][bLen-1];
    }

    private static int getLeftBaloonValue(int left, int[] baloons) {
        if(left-1<0) return 1;
        return baloons[left-1];
    }

    private static int getRightBaloonValue(int right, int[] baloons) {
        if(right+1>=baloons.length) return 1;
        return baloons[right+1];
    }
}
