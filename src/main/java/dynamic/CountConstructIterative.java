package dynamic;

import java.util.Arrays;

public class CountConstructIterative {

    public static void main(String[] args) {
        String[] words= new String[]{"ab","abc","cd","def","abcd"};
        System.out.println(countConstruct("abcdef",words));
    }

    private static int countConstruct(String target, String[] words) {
        int[] table= new int[target.length()+1];
        Arrays.fill(table,0);
        table[0]=1;
        for(int i=0;i<=table.length-1;i++){
            if(table[i]!=0){
                for(String word:words){
                    if(i+ word.length()< table.length){
                        String match= target.substring(i,i+word.length());
                        if(match.equalsIgnoreCase(word)){
                            table[i+word.length()]=table[i]+table[i+word.length()];
                        }
                    }

                }
            }
        }
        return table[target.length()];
    }

}
