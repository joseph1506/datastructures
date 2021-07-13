package dynamic;

import java.util.Arrays;

public class NStairsIteration {

    public static void main(String[] args) {
        int[] steps= new int[]{1,2};
        System.out.println(countWays(10,steps));
    }

    private static int countWays(int target, int[] steps) {
        int[] pos= new int[target+1];
        Arrays.fill(pos,0);
        pos[0]=1;
        for(int i=0;i<pos.length;i++){
            if(pos[i]!=0){
                for(int step:steps){
                    if(i+step<=target){
                        pos[i+step]=pos[i]+pos[i+step];
                    }
                }
            }
        }
        return pos[target];
    }


}
