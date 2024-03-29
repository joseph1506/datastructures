package algorithms;

import java.util.Arrays;

public class LongCommSubsequence {

    /*public static void main(String[] args) {
        String input1 = "ABATD";
        String input2 = "CBCADDT";
        int[][] count = new int[input1.length()][input2.length()];
        for(int i=0;i<input1.length();i++){
            Arrays.fill(count[i],-1);
        }

        System.out.println(findLengthLCS(input1, input2, input1.length(), input2.length(),count));
    }*/

    private static int findLengthLCS(String input1, String input2, int m, int n, int[][] count) {
        if(count[m][n]!=-1) return count[m][n];
        int result = 0;
        if(m==0 || n == 0)
            result =0;
        else if(input1.charAt(m-1)== input2.charAt(n-1)){
            result = 1+ findLengthLCS(input1, input2, m-1, n-1,count);
        } else {
            result = Math.max(findLengthLCS(input1, input2, m-1,n,count), findLengthLCS(input1, input2,m,n-1,count));
        }
        count[m][n]= result;
        return result;
    }


    private static int lcsDynamic(char[] input1,char[] input2){
        int[][] count= new int[input1.length+1][input2.length+1];

        for(int i=1;i<count.length;i++){
            for(int j=1;j<count[i].length;j++){
                if(input1[i-1]==input2[j-1]){
                    count[i][j]=1+ count[i-1][j-1];
                } else {
                    count[i][j]= Math.max(count[i-1][j],count[i][j-1]);
                }
            }
        }

        return count[input1.length][input2.length];
    }

    public static void main(String[] args) {
        String input1="abcdaf";
        String input2="acbcf";
        System.out.println(lcsDynamic(input1.toCharArray(),input2.toCharArray()));

    }

}
