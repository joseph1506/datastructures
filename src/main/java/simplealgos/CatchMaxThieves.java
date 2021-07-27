package simplealgos;

import java.util.ArrayList;
import java.util.List;

public class CatchMaxThieves {

    public static void main(String[] args) {
        int k, n;
        char arr1[] =new char[] { 'P', 'T', 'T',
                'P', 'T' };
        k = 2;
        n = arr1.length;
        System.out.println("Maximum thieves caught: "
                +maxThievesEfficient(arr1, k));

        char arr2[] =new char[] { 'T', 'T', 'P', 'P',
                'T', 'P' };
        k = 2;
        n = arr2.length;
        System.out.println("Maximum thieves caught: "
                +maxThievesEfficient(arr2, k));

        char arr3[] = new char[]{ 'P', 'T', 'P', 'T',
                'T', 'P' };
        k = 3;
        n = arr3.length;
        System.out.println("Maximum thieves caught: "
                +maxThievesEfficient(arr3, k));


    }
      //O(N)--time complexity
      //O(N)-- space complexity
    private static int maxThievesGreedy(char[] policeThieves, int distance) {
        int thievesCaught=0;
        List<Integer> polIndex= new ArrayList<>();
        List<Integer> thIndex= new ArrayList<>();
        for(int i=0;i<policeThieves.length;i++){
            if(policeThieves[i]=='P') polIndex.add(i);

            if(policeThieves[i]=='T') thIndex.add(i);
        }

        if(polIndex.size()>0 && thIndex.size()>0) {
            int l=0;
            int r=0;

            while(l<thIndex.size() && r<polIndex.size()){

                if(Math.abs(thIndex.get(l)-polIndex.get(r))<=distance){
                    // can be caught
                    thievesCaught++;
                    l++;
                    r++;
                }
                else if(thIndex.get(l)<polIndex.get(r)){
                    //it thief is left to police, move to next thief
                    l++;
                } else{
                    r++;
                }
            }
        }
        return thievesCaught;
    }

    //O(N)--time complexity
    //O(1)-- space complexity
    private static int maxThievesEfficient(char[] policeThieves, int distance) {
        int thievesCaught=0;
        int leftPolIndex=-1;
        int leftThiefIndex=-1;
        for(int i=0;i<policeThieves.length;i++){
            if(policeThieves[i]=='P') {
                leftPolIndex=i;
                break;
            }
        }

        for(int i=0;i<policeThieves.length;i++){
            if(policeThieves[i]=='T') {
                leftThiefIndex=i;
                break;
            }
        }

        if(leftPolIndex==-1 || leftThiefIndex==-1) return 0;
        int N=policeThieves.length;
        while(leftPolIndex<N && leftThiefIndex<N){

            if(Math.abs(leftPolIndex-leftThiefIndex)<=distance){
                thievesCaught++;
                // find next leftest polindex and thIndex
                leftPolIndex++;
                while(leftPolIndex<N && policeThieves[leftPolIndex]!='P'){
                    leftPolIndex++;
                }

                leftThiefIndex++;
                while(leftThiefIndex<N && policeThieves[leftThiefIndex]!='T'){
                    leftThiefIndex++;
                }

            } else if (leftThiefIndex < leftPolIndex ){
                // find next leftest thief
                leftThiefIndex++;
                while(leftThiefIndex<N && policeThieves[leftThiefIndex]!='T'){
                    leftThiefIndex++;
                }

            }else{
                // find next leftest police
                leftPolIndex++;
                while(leftPolIndex<N && policeThieves[leftPolIndex]!='P'){
                    leftPolIndex++;
                }
            }
        }
        return thievesCaught;
    }

}
