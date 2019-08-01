package functional;

import java.util.Objects;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);

    default <V> Function<T,V> andThen(Function<R,V> second){
        Objects.requireNonNull(second);
        return (T t) -> {
            R r = this.apply(t);
            return second.apply(r);
        };
    }

}
