package dynamic;

import java.util.Arrays;

public class NFibonacci {

    public static void main(String[] args) {
        int n=50;
        long[] mem= new long[n+1];
        Arrays.fill(mem,-1);
        System.out.println("Fibonacci for N-->"+ fibonacci(n,mem));
        System.out.println("Fibonacci for N-->"+ fibonacci(n));
    }

    private static long fibonacci(int n,long[] mem) {
        if(mem[n]!=-1) return mem[n];

        if(n==1 || n==2) return 1;

        mem[n]= fibonacci(n-1,mem)+fibonacci(n-2,mem);
        return mem[n];
    }

    private static long fibonacci(int n) {
        if(n==1 || n==2) return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }
}
