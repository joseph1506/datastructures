package asynchronous;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestList {

    public static void main(String[] args) {
        List<Person> persons = populatePersons();
        //List<List<Person>> divided = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger();
        Collection<List<Person>> divided= persons.stream()
                .collect(Collectors.groupingBy(it->counter.getAndIncrement()/6))
                .values();
        System.out.println(divided);

        List<CompletableFuture<List<String>>> futures=divided.stream()
                                                    .map(d-> CompletableFuture.supplyAsync(()-> process(d)))
                                                    .collect(Collectors.toList());
        System.out.println(futures);
        List<List<String>> names = futures.stream()
                .map(f-> f.join())
                .collect(Collectors.toList());
         names.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("Ended");
    }

    private static List<String> process(List<Person> persons) {
        List<String> names = new ArrayList<>();
        persons.stream()
                .forEach(p-> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    names.add(p.getName());
                });

        return names;
    }

    private static List<Person> populatePersons() {
        List<Person> persons = new ArrayList<>();
        for(int i=0;i<50;i++){
            Person p = new Person();
            p.setName("Name"+i);
            p.setAge(i);
            persons.add(p);
        }
        return persons;
    }
}
