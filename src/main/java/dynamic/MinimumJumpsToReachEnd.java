package dynamic;

import java.util.Arrays;

// minimum no of jumps required to reach the end of array
public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
        //1-> 3-> 8-> 9  3 jumps   (0-> 1-> 3->10 )
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(dpApproach(arr));
        int arr2[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //System.out.println(dpApproach(arr2));

        int arr3[] = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        //System.out.println(dpApproach(arr3));

        //System.out.println(OOfNApproachGFG(arr));
    }

    private static int dpApproach(int[] numbers) {
        if(numbers==null || numbers.length==0) return 0;

        if(numbers[0]==0) return -1;


        int[] jumps= new int[numbers.length];
        Arrays.fill(jumps,-1);
        jumps[0]=0;

        for(int i=0;i<numbers.length;i++){
            int iValue=numbers[i];

            if(jumps[numbers.length-1]!=-1) break;

            for(int j=1;j<=iValue && i+j<numbers.length;j++){
                if(jumps[i+j]==-1){
                    jumps[i+j]=jumps[i]+1;
                } else{
                    jumps[i+j]=Math.min(jumps[i+j],jumps[i]+1);
                }
            }
        }
        return jumps[numbers.length-1];
    }

    private static int OOfNApproachGFG(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached
// the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                // Check if the current
// index/position or lesser index
                // is the maximum reach point
// from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

}
