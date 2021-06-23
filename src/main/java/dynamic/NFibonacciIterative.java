package dynamic;

public class NFibonacciIterative {

    public static void main(String[] args) {
        System.out.println(nFib(50));
    }

    private static long nFib(int n) {
        long[] fibN= new long[n+1];
        fibN[0]=0;
        fibN[1]=1;

        for(int i=0;i<n+1;i++){
            if(i+1<n+1){
                fibN[i+1]=fibN[i]+fibN[i+1];
            }
            if(i+2<n+1){
                fibN[i+2]=fibN[i]+fibN[i+2];
            }
        }
        return fibN[n];
    }
}
