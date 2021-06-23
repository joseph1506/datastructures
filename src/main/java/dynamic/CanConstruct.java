package dynamic;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {
        /*String[] words= new String[]{"ab","abc","cd","def","abcd"};
        System.out.println(canConstruct("abcdef",words));*/

        /*String[] words= new String[]{"bo","rd","ate","t","ska","sk","boar"};
        System.out.println(canConstruct("skateboard",words));*/
        Map<String,Boolean> memo= new HashMap<>();
        String[] words= new String[]{"e","ee","eee","eeee","eeeee","eeeeee"};
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",words,memo));

    }

    public static boolean canConstruct(String target, String[] words, Map<String,Boolean> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if("".equalsIgnoreCase(target)) return true;

        for(String word:words){
            if(target.startsWith(word)){
                String suffix= target.substring(word.length(),target.length());
                if(canConstruct(suffix,words,memo)){
                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target,false);
        return false;
    }

}
