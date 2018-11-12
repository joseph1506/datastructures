package dynamic;

public class NStairsLogic {

    public static void main(String[] args) {
        int stairs = 4;
        int[] steps12 = {1,2};
        //int noOfWays = calculateNofWays(stairs,steps);
        //int noOfWays = calculateNoOfwaysDP(stairs,steps12);
        int noOfWays = calculateNofWaysX(stairs,steps12);
        System.out.println("No of ways--->"+noOfWays);

    }

    //for 1 to X steps at a time
    private static int calculateNofWaysX(int stairs, int[] steps) {
        if(stairs==0) return 1;
        int total =0;

        for(int i=0;i<steps.length;i++){
            int step = steps[i];
            if(stairs-step>=0){
             total= total+ calculateNofWaysX(stairs-step,steps);
            }
        }
        return total;
    }

    //for 1 to X steps at a time
    private static int calculateNofWaysXDP(int stairs, int[] steps) {
        if(stairs==0) return 1;
        int[] count = new int[stairs+1];
        count[0] = 1;

        for(int i=1;i<=stairs;i++){
            int total =0;
            for(int j=0;j<steps.length;j++){
                if(i-steps[j]>=0){
                    total= total+count[i-steps[j]];
                }
            }
            count[i] = total;
        }
        return count[stairs];
    }

    //only for 1,2 steps at a time
    private static int calculateNofWays(int stairs, int[] steps) {
        if(stairs==0 || stairs==1)
            return 1;

        return calculateNofWays(stairs-1,  steps) + calculateNofWays(stairs-2,steps);
    }



    //only for 1,2 steps at a time
    private static int calculateNoOfwaysDP(int stairs, int[] steps){
        if(stairs==0 || stairs==1)
            return 1;

        int[] count = new int[stairs+1];
        count[0] = 1;
        count[1] = 1;

        for(int i=2;i<=stairs;i++){
            count[i] = count[i-1] + count[i-2];
        }
        return count[stairs];
    }
}
