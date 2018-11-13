package algorithms;

public class LongConsChars {


    public static void main(String[] args) {
        String input= "AABCDDBBBEEEEEA";
        System.out.println(printLongest(input));
    }

    private static String printLongest(String input) {
        int currCount=0;
        char currChar=input.charAt(0);
        char globalChar=input.charAt(0) ;
        int globalCount=0;


        for(int i=0;i<input.length();i++){
            char inputChar = input.charAt(i);

            if(inputChar==currChar){
                currCount++;
            } else {
                currCount = 1;
                currChar= inputChar;
            }

            if(currCount>globalCount){
                globalCount=currCount;
                globalChar=inputChar;
            }
        }
        return globalChar+":"+globalCount;
    }
}
