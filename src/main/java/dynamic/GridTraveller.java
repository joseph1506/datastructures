package dynamic;

import java.util.Arrays;

public class GridTraveller {


    public static void main(String[] args) {
        System.out.println("Ways for 1,1---->"+countTimes(1,1));
        System.out.println("Ways for 2,3---->"+countTimes(2,3));
        System.out.println("Ways for 3,2---->"+countTimes(3,2));
        System.out.println("Ways for 18,18---->"+countTimes(18,18));
    }

    public static long countTimes(int m,int n){
        long[][] mem= new long[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(mem[i],-1);
        }
        return countWays(m-1,n-1,mem);
    }

    public static long countWays(int m,int n,long[][] mem){
        if(mem[m][n]!=-1) return mem[m][n];
        if(m==0 || n==0) return 1;
        mem[m][n]= countWays(m-1,n,mem)+countWays(m,n-1,mem);
        return mem[m][n];
    }


}
