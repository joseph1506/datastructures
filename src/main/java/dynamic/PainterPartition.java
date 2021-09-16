package dynamic;

public class PainterPartition {

    public static void main(String[] args) {
        int[] paintingTimings= new int[]{10,40,20,30,40,50};
        int painters= 3;
        System.out.println(minPossibleTimeAfterPartitioning(paintingTimings,painters));
    }

    private static int minPossibleTimeAfterPartitioning(int[] paintingTimings, int painters) {
        if(paintingTimings==null || paintingTimings.length==0) return 0;

        int paintings= paintingTimings.length;
        int[][] dpSolution= new int[painters+1][paintings+1];

        for(int j=0;j<=paintings;j++){
            dpSolution[0][j]=0;
            if(j!=0) dpSolution[1][j]= sumArr(paintingTimings,0,j-1);
        }

        for(int i=1;i<=painters;i++){
            dpSolution[i][0]=0;
            dpSolution[i][1]=paintingTimings[0];
        }

        for(int i=2;i<=painters;i++){
            for(int j=2;j<=paintings;j++){
                int best= Integer.MAX_VALUE;

                for(int k=1;k<=j;k++){
                    int maxOfCurrentPartition= Math.max(dpSolution[i-1][k],sumArr(paintingTimings,k,j-1));
                    best = Math.min(best,maxOfCurrentPartition);
                }

                dpSolution[i][j]=best;
            }
        }
        return dpSolution[painters][paintings];
    }

    private static int sumArr(int[] paintingTimings, int start, int end) {
        int sum =0;

        for(int i=start;i<=end;i++){
            sum+=paintingTimings[i];
        }

        return sum;
    }

}
