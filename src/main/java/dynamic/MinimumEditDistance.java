package dynamic;

public class MinimumEditDistance {

    public static void main(String[] args) {
        String input1="sunday";
        String input2="saturday";


        System.out.println(minOperations(input1,input2));


    }

    private static int minOperations(String input1, String input2) {
        int M=0;
        int N=0;
        if(input1!=null) M= input1.length();
        if(input2!=null) N= input2.length();

        int[][] dpSolution= new int[M+1][N+1];

        for(int i=0;i<=M;i++){
            for(int j=0;j<=N;j++){
                if(i==0) {
                    dpSolution[i][j]=j;
                } else if(j==0) {
                    dpSolution[i][j]=i;
                } else if(input1.charAt(i-1)==input2.charAt(j-1)){
                    dpSolution[i][j]=dpSolution[i-1][j-1];
                } else{
                    //  dpSolution[i][j]= 1+ MIN(  Replace ,Insert, Remove)
                    //int insertOP= 1+ dpSolution[i][j-1];
                    //int replaceOp= 1+ dpSolution[i-1][j-1];
                    //int removeOp= 1+ dpSolution[i-1][j];

                    dpSolution[i][j]= 1+  minimum(dpSolution[i][j-1],dpSolution[i-1][j-1],dpSolution[i-1][j]);
                }

            }
        }
        return dpSolution[M][N];
    }

    private static int minimum(int number1, int number2, int number3) {
        return Math.min(number1,Math.min(number2,number3));
    }


}
