package dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] numbers= {3, 10, 2, 11};

        int[] lis= findLISDP(numbers);
        //System.out.printf(lis.toString());
        System.out.println(LongestIncreasingSubsequenceLengthNLogN(numbers,4));

    }

    private static int[] findLISDP(int[] numbers) {
        int[] lisCalc= new int[numbers.length];
        int[] lisIndex= new int[numbers.length];

        Arrays.fill(lisCalc,1);

        for(int i=1;i<numbers.length;i++){
            for(int j=0;j<i;j++){
                if(numbers[j]<numbers[i]){
                    if(lisCalc[j]+1>lisCalc[i]){
                        lisCalc[i]=lisCalc[j]+1;
                        lisIndex[i]=j;
                    }
                }
            }
        }

        int max=0;
        int lastIndex=0;
        for(int i=0;i<lisCalc.length;i++){
            if(lisCalc[i]>max){
                max=lisCalc[i];
                lastIndex= i;
            }
        }
        System.out.println("Maxx is-->"+max);




        return new int[0];
    }


    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLengthNLogN(int A[], int size) {
        // Add boundary case, when array size is one
        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1]) {
                // A[i] wants to extend largest subsequence
                len += 1;
                tailTable[len] = A[i];
            }

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }


}
