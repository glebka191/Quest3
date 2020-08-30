public class Shop{
    private static volatile int products = 1000;

    public static int getProducts() {
        return products;
    }

    public static synchronized int buy(int amountBuy){
        if (amountBuy >= products){
            amountBuy = products;
            products = 0;
        } else
            products-=amountBuy;
        return amountBuy;
    }
}