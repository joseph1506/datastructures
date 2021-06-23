package dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {
        Map<String,List<String>> memo= new HashMap<>();
        /*String[] words= new String[]{"purp","p","ur","le","purpl"};
        //System.out.println(allConstruct("purple",words,memo));
        List<String> combinations= allConstruct("purple",words,memo);
        writeCombinations(combinations);*/

        /*String[] words= new String[]{"ab","abc","cd","def","abcd","ef","c"};
        List<String> combinations= allConstruct("abcdef",words,memo);
        writeCombinations(combinations);*/

        /*String[] words= new String[]{"act","dog","mouse"};
        List<String> combinations= allConstruct("hello",words,memo);
        writeCombinations(combinations);*/

        String[] words= new String[]{"a","aa","aaa","aaaa","aaaaa"};
        List<String> combinations= allConstruct("aaaaaaaaaaaaa",words,memo);
        writeCombinations(combinations);

        /*String[] words= new String[]{"e","ee","eee","eeee","eeeee","eeeeee"};
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",words,memo));*/

    }

    private static void writeCombinations(List<String> combinations) {
        combinations.stream()
                .forEach(comb-> System.out.println("Combination--->"+comb));
    }

    public static List<String> allConstruct(String target, String[] words, Map<String, List<String>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if("".equalsIgnoreCase(target)) {
            List<String> blank= new ArrayList<>();
            blank.add(target);
            return blank;
        }
        List<String> combinations=new ArrayList<>();
        for(String word:words){
            if(target.startsWith(word)){
                String suffix= target.substring(word.length(),target.length());
                List<String> subsCombinations= allConstruct(suffix,words,memo).stream()
                        .map(item-> word+","+item).collect(Collectors.toList());
                combinations.addAll(subsCombinations);
                //memo.put(target,combinations);
                /*if(countConstruct(suffix,words,memo)){
                    memo.put(target,true);
                    return true;
                }*/
            }
        }
        memo.put(target,combinations);
        return combinations;
    }

}
