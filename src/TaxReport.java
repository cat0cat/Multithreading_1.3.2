import java.util.concurrent.atomic.LongAdder;

public class TaxReport extends Thread{
    private final LongAdder adder = new LongAdder();

    public void addToAdder(long dailyRevenue) {
        adder.add(dailyRevenue);
    }

    public long getTotalRevenues() {
        return adder.sum();
    }

    public void printAdderResult() {
        System.out.println("Общая выручка всех магазинов составила: " + getTotalRevenues());
    }
}
