package functional.streamOps;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Sale {
    private Store city;
    private Date date;
    private Optional<String> user;
    private List<Item> items;

    public Sale(Store city, Date date, Optional<String> user, List<Item> items) {
        this.city = city;
        this.date = date;
        this.user = user;
        this.items = items;
    }

    public double total() {
        return this.items.stream()
                .mapToDouble(s-> s.getPrice())
                .sum();
    }

    public Store getCity() {
        return city;
    }

    public Date getDate() {
        return date;
    }

    public Optional<String> getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }
}
