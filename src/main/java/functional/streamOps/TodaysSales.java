package functional.streamOps;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TodaysSales {

    static final List<Sale> sales = Arrays.asList(
            new Sale(Store.KANSAS_CITY, new Date(), Optional.of("Sarah"),
                    Arrays.asList(
                            new Item("carrot", 12.00)
                    )),
            new Sale(Store.ST_LOUIS, new Date(), Optional.empty(),
                    Arrays.asList(
                            new Item("carrot", 12.00),
                            new Item("lizard", 100),
                            new Item("cookie", 1.99)
                    )),
            new Sale(Store.ST_LOUIS, new Date(), Optional.of("Jamie"),
                    Arrays.asList(
                            new Item("banana", 22.00),
                            new Item("cookie", 1.49)
                    ))
    );

    static Stream<Sale> saleStream(){
        return sales.stream();
    }


    public static void main(String[] args) {
        System.out.println("Count--->"+ saleStream().count());
        // any sale which has total > 100
        System.out.println("any Sale > 100Rs:::"+ saleStream().anyMatch(sale-> sale.total()> 100));

        Supplier<Stream<Item>> itemStreamSupplier = ()->
                saleStream()
                        .flatMap(s->s.getItems().stream());

        System.out.println("ItemCount::::"+itemStreamSupplier.get().count());
        System.out.println("Unique Items::::"+itemStreamSupplier.get()
                .map(s->s.getName())
        .distinct().count());

        //summarize sales by store
        Map<Store,List<Sale>> summary = saleStream().collect(Collectors.groupingBy(Sale::getCity));
        System.out.println(summary);

    }
}
