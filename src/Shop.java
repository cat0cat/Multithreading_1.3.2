import java.util.Random;

public class Shop extends Thread{

    private static final int MAX_PRODUCTS = 30; //максимальное количество продуктов в одной корзине
    private static final int MAX_PRICE = 2_000; // максимальная цена одного продукта
    private static final int MAX_BUYERS = 100;  // максимальное число покупателей за день
    TaxReport taxReport;

    public Shop(String name, TaxReport taxReport) {
        super(name);
        this.taxReport = taxReport;
    }

    @Override
    public void run() {
        int revenue = 0;
        Random random = new Random();
        int[] basket = new int [random.nextInt(MAX_PRODUCTS)];
        for (int i = 0; i < basket.length; i++) {
            basket[i] = random.nextInt(MAX_PRICE);
            revenue += basket[i];
        }
        long dailyRevenue = (long) random.nextInt(MAX_BUYERS) * revenue;
        System.out.println(Thread.currentThread().getName() + ": выручка за день " + dailyRevenue);
        taxReport.addToAdder(dailyRevenue);
    }

}
