package algorithms;

public class SubArrayForATotal {


    public static void main(String[] args) {
        //int[] numbers= new int[]{1,4,0,0,3,10,5};
        int[] numbers= new int[]{1,2,3,7,5};
        int total=12;
        System.out.println(indexOfArrayForSumEfficient(numbers,total));
    }

    private static String indexOfArrayForSumBrute(int[] numbers, int total) {
        if(numbers==null || numbers.length==0) return "Not Found";


        for(int i=0;i<numbers.length;i++){
            int checkTotal=numbers[i];
            if(checkTotal==total) return "Index at "+i;

            for(int j=i+1;j<numbers.length;j++){
                checkTotal= checkTotal+numbers[j];
                if(checkTotal==total){
                    return "Index from "+i+" to "+j;
                }
                if(checkTotal>total){
                    break;
                }
            }

        }

        return "Not Found";
    }

    private static String indexOfArrayForSumEfficient(int[] numbers, int total) {
        if(numbers==null || numbers.length==0) return "Not Found";

        int start=0;
        int curr_sum=numbers[0];
        for(int i=1;i<numbers.length;i++){
            while(curr_sum>total && start<i-1){
                curr_sum=curr_sum-numbers[start];
                start++;
            }


            if(curr_sum==total) {
                int p=i-1;
                return "Index from "+start+" to "+p;
            }

            if(i<numbers.length) curr_sum=curr_sum+numbers[i];

        }

        return "Not Found";
    }

}
