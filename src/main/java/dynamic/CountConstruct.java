package dynamic;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        Map<String,Integer> memo= new HashMap<>();
        String[] words= new String[]{"purp","p","ur","le","purpl"};
        System.out.println(countConstruct("purple",words,memo));

        /*String[] words= new String[]{"bo","rd","ate","t","ska","sk","boar"};
        System.out.println(canConstruct("skateboard",words));*/

        /*String[] words= new String[]{"e","ee","eee","eeee","eeeee","eeeeee"};
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",words,memo));*/

    }

    public static int countConstruct(String target, String[] words, Map<String,Integer> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if("".equalsIgnoreCase(target)) return 1;
        int count=0;
        for(String word:words){
            if(target.startsWith(word)){
                String suffix= target.substring(word.length(),target.length());
                count+= countConstruct(suffix,words,memo);
                /*if(countConstruct(suffix,words,memo)){
                    memo.put(target,true);
                    return true;
                }*/
            }
        }
        memo.put(target,count);
        return count;
    }

}
