package dynamic;

import java.util.Arrays;

public class CanConstructIterative {

    public static void main(String[] args) {
        String[] words= new String[]{"ab","abc","cd","def","abcd"};
        System.out.println(canConstruct("abcdef",words));
    }

    private static boolean canConstruct(String target, String[] words) {
        boolean[] table= new boolean[target.length()+1];
        Arrays.fill(table,false);
        table[0]=true;
        for(int i=0;i<=table.length-1;i++){
            if(table[i]){
                for(String word:words){
                    if(i+ word.length()< table.length){
                        String match= target.substring(i,i+word.length());
                        if(match.equalsIgnoreCase(word)){
                            table[i+word.length()]=true;
                        }
                    }

                }
            }
        }
        return table[target.length()];
    }

}
