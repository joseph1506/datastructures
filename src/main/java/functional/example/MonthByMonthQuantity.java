package functional.example;

abstract class MonthByMonthQuantity implements QuantityOfInterest{

    private final double[] values;

    protected MonthByMonthQuantity(final double[] values){
        this.values = values;
    }


    public double valueAt(int time) {
        return this.values[time-1];
    }
}
