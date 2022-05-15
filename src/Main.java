import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int SHOPS = 3;

    public static void main(String[] args) throws InterruptedException {
        TaxReport taxReport = new TaxReport();

        List<Shop> shopList = new ArrayList<Shop>(SHOPS);
        for (int i = 0; i < SHOPS; i++) {
            Shop shop = new Shop("Магазин " + (i + 1), taxReport);
            shopList.add(shop);
            shopList.get(i).start();
            shopList.get(i).join();
        }

        taxReport.printAdderResult();
    }
}