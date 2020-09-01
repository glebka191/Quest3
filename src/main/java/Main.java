import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main{
    public static void main(String[] args) {
        int people = Integer.parseInt(args[0]);
        final List<Buyer> buyersList = new ArrayList<>();
        Buyer.setCW(people);

        for (int i = 0; i < people; i ++){
            Buyer buyer = new Buyer(0,0,i);
            buyersList.add(buyer);
            buyer.start();
        }

        System.out.println("Начинаем покупки");

        buyersList.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

            buyersList.forEach(buyer -> System.out.println( "Покупатель номер " + buyer.getName() + " Кол-во покупок " + buyer.getProduct()
                    + " Кол-во операций " + buyer.getOperation()));
        System.out.println("Остаток на складе "+ Shop.getProducts());
    }
}