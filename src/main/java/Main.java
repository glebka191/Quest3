import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main{
    public static void main(String[] args) {
        int people = Integer.parseInt(args[0]);
        List<Buyer> buyersList = new ArrayList<>();
        Buyer.setCW(people);

        for (int i = 0; i < people; i ++){
            Buyer buyer = new Buyer(0,0,i);
            buyersList.add(buyer);
            buyer.start();
        }
            System.out.println("Начинаем покупки");
        System.out.println(Buyer.START.getCount());
            while (Shop.getProducts()>0){
                for (Buyer b : buyersList){
                    b.run();
                Buyer.START.countDown();
                }
            }
            for (Buyer b : buyersList){
                System.out.println( "Покупатель номер " + b.getName() + " Кол-во покупок " + b.getProduct()
                        + " Кол-во операций " + b.getOperation());
            }
        System.out.println("Остаток на складе "+ Shop.getProducts());
    }
}