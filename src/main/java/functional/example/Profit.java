package functional.example;

public class Profit implements QuantityOfInterest {
    Sales sales;
    IncrementalCosts incrementalCosts;
    FixedCosts fixedCosts;

    public Profit(Sales sales, IncrementalCosts incrementalCosts, FixedCosts fixedCosts) {
        this.sales = sales;
        this.incrementalCosts = incrementalCosts;
        this.fixedCosts = fixedCosts;
    }

    public String getName() {
        return "Profit--->";
    }

    public double valueAt(int time) {
        return this.sales.valueAt(time) -
                (this.incrementalCosts.valueAt(time)+this.fixedCosts.valueAt(time));
    }
}
