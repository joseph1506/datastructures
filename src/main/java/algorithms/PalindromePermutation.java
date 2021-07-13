package algorithms;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(checkPalindromeCanBeMade("level2"));
    }

    private static boolean checkPalindromeCanBeMade(String input) {
        if(input==null|| input.length()==0) return false;

        Map<Character,Integer> charCount= new HashMap<Character,Integer>();

        for(int i=0;i<input.length();i++){
            char character= input.charAt(i);
            if(Character.isDigit(character)|| Character.isLetter(character)){
                char lowerCaseChar= Character.toLowerCase(character);
                Integer count= charCount.get(lowerCaseChar);
                if(count==null){
                    charCount.put(lowerCaseChar,1);
                }else{
                    charCount.put(lowerCaseChar,count+1);
                }
            }
        }

        int countOfOddNumberChars=0;
        for(Character character:charCount.keySet()){
            int count= charCount.get(character);
            if(count%2!=0) countOfOddNumberChars++;
        }

        if(countOfOddNumberChars>1)
            return false;
        else
            return true;
    }
}
