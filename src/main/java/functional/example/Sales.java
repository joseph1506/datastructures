package functional.example;

public class Sales extends MonthByMonthQuantity{

    public Sales(double[] sales) {
        super(sales);
    }

    @Override
    public String getName() {
        return "Expected Sales-->";
    }
}
