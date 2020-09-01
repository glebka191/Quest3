public class Shop{
    private static volatile int products = 1000;

    public static int getProducts() {
        return products;
    }

    public static synchronized int buy(int amountBuy){
            products-=amountBuy;
        return amountBuy;
    }
}