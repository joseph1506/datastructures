package functional;

import asynchronous.Person;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T obj1, T obj2);

    public static <T> Comparator<T> comparing(Function<T, String> extractor) {
        Objects.requireNonNull(extractor);
        return (p1,p2) -> extractor.apply(p1).compareTo(extractor.apply(p2));
    }
}
