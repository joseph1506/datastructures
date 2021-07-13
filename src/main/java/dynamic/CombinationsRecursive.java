package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsRecursive {
    public static void main(String[] args) {
        char[] test= new char[]{'a','b','c'};
        List<char[]> output= combinations(test);
        output.forEach(chars -> {
            System.out.print("[");
            int count=0;
            for(char charac:chars){
                System.out.print(charac);
                if(count<chars.length-1){
                    System.out.print(",");
                    count++;
                }
            }
            System.out.print("]");
            System.out.println("");
        });
    }

    private static List<char[]> combinations(char[] test) {
        if(test.length==0) {
            List<char[]> ret= new ArrayList<>();
            char[] blank = new char[0];
            ret.add(blank);
            return ret;
        }
        char firstElem= test[0];
        char[] rest= Arrays.copyOfRange(test,1,test.length);
        List<char[]> combsOfRest= combinations(rest);
        List<char[]> combsOfFirst= new ArrayList<>();
        combsOfRest.forEach(comb->{
            char[] combDup= new char[comb.length+1];
            for(int i=0;i<comb.length;i++){
                combDup[i]=comb[i];
            }
            combDup[comb.length]=firstElem;
            combsOfFirst.add(combDup);
        });
        combsOfRest.addAll(combsOfFirst);
        return combsOfRest;
    }
}
