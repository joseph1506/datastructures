package simplealgos;

import java.util.Arrays;

public class CandyDistribution {

    public static void main(String[] args) {
        int[] ratings= {1,2,2};
        System.out.println(minimiumCandiesGreedy(ratings));
    }

    private static int minimiumCandiesGreedy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;

        int N= ratings.length;
        int[] candiesLeftCheck= new int[N];
        Arrays.fill(candiesLeftCheck,1);

        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1]) {
                candiesLeftCheck[i]=candiesLeftCheck[i-1]+1;
            }
        }
        System.out.println(candiesLeftCheck);

        int[] candiesRightCheck= new int[N];
        Arrays.fill(candiesRightCheck,1);

        for(int i=N-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) {
                candiesRightCheck[i]=candiesRightCheck[i+1]+1;
            }
        }
        System.out.println(candiesRightCheck);

        int count=0;
        for(int i=0;i<N;i++){
            count+= Math.max(candiesLeftCheck[i],candiesRightCheck[i]);
        }
        return count;
    }
}
