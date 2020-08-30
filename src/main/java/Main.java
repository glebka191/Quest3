import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main{
    public static void main(String[] args) {
        int people = Integer.parseInt(args[0]);
        List<Buyer> buyersList = new ArrayList<>();
        for (int i = 0; i < people; i ++){
            buyersList.add(new Buyer(0,0,i+1));
        }
            System.out.println("Начинаем покупки");
            while (Shop.getProducts()>0){
                for (Buyer b : buyersList){
                    b.run();
                }
            }
            for (Buyer b : buyersList){
                System.out.println( "Покупатель номер " + b.getName() + " Кол-во покупок " + b.getProduct()
                        + " Кол-во операций " + b.getOperation());
            }
        System.out.println("Остаток на складе "+ Shop.getProducts());
    }
}