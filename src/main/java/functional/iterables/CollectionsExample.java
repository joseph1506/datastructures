package functional.iterables;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class CollectionsExample {

    final static String[] food = new String[]{
            "Crunchy carrots",
            "Golen hued bananas",
            "",
            "bright orange  pumpkins ",
            "Little trees of brocolli",
            "mutton"
    };

    public static void main(String[] args) {
        final String summary = summarize(food);
        final String desiredSummary = "carrots & bananas & pumpkins & brocolli & mutton";
        System.out.println(summary);
        if(summary.equals(desiredSummary)) System.out.printf("yay!!!");
    }

    private static String summarize(String[] food) {
        /*final StringBuilder output = new StringBuilder();
        boolean isFirst =  true;
        for(String d: food){
            if(!d.isEmpty()){
                final String word = lastWord(d);
                if(!isFirst){
                    output.append(" & ");
                }
                output.append(word);
                isFirst=false;
            }
        }*/

        return Arrays.asList(food).stream()
                .peek(s-> System.out.println("About to filter::" + s))
                .filter(s-> !s.isEmpty())
                .peek(s-> System.out.println("About to map::" + s))
                .map(lastWord)
                .peek(s-> System.out.println("About to reduce::" + s))
                .reduce(joinOn(" & "))
                .orElse("");
    }

    private static BinaryOperator<String> joinOn(final String delimiter) {
        return (allSoFar, nextElement)-> allSoFar+ delimiter +nextElement;
    }

    static BinaryOperator<String> chooseLast = (allSofar,nextElement)-> nextElement;

    static Function<? super String, String> lastWord =
            sentence -> Arrays.asList(sentence.split(" ")).stream()
                        .reduce(chooseLast)
                        .orElse("");



    /*private static String lastWord(String sentence) {
        final int lastSpace = sentence.lastIndexOf(" ");
        if(lastSpace<0){
            return sentence;
        } else {
            return sentence.substring(lastSpace+1, sentence.length());
        }
    }*/
}
