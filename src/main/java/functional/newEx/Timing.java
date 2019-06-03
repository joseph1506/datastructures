package functional.newEx;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Timing {
    public static <A> A timed(String description,
                              Consumer<String> consumer,
                              Supplier<A> code){
        final Date before = new Date();
        A result = code.get();
        final long timeTaken = new Date().getTime() - before.getTime();
        consumer.accept(description+" took "+timeTaken+" seconds");
        //System.out.println(description+" took "+timeTaken+" seconds");
        return result;
    }
}
