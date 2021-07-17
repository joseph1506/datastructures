package backtracting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class StringPermutation {

    public static void main(String[] args) {
        String testString="AABCDDE";
        List<String> results=permute(testString);
        results.stream()
                .forEach(s-> System.out.println(s));
    }

    private static List<String> permute(String testString) {
        Map<Character,Integer> countMap= new TreeMap<>();
        for(char ch: testString.toCharArray()){
            countMap.compute(ch, (key,val)-> val!=null?val+1:1);
        }

        char[] characters= new char[countMap.size()];
        int[] eachCharCount= new int[countMap.size()];
        int index=0;
        for(char character: countMap.keySet()){
            characters[index]=character;
            eachCharCount[index]=countMap.get(character);
            index++;
        }
        char[] result= new char[testString.length()];
        List<String> resultList= new ArrayList<>();

        permuteRecursion(characters,eachCharCount,0,result,resultList);
        return resultList;
    }

    private static void permuteRecursion(char[] allChars, int[] charCount, int level, char[] result, List<String> resultList) {
        if(level==result.length){
            resultList.add(new String(result));
            return;
        }
        for(int i=0;i<allChars.length;i++){
            if(charCount[i]==0) continue;

            result[level]=allChars[i];
            charCount[i]=charCount[i]-1;
            permuteRecursion(allChars,charCount,level+1,result,resultList);
            charCount[i]=charCount[i]+1;
        }

    }
}
