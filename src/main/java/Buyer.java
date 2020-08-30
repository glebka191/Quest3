import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

public class Buyer extends Thread {
    private int product = 0;
    private int operation;
    private int name;
    public static CountDownLatch START;

    public static void setCW(int buyers) {
        START = new CountDownLatch(buyers);
    }

    public Buyer(int product, int operation, int name) {
        this.name = name;
        this.product = product;
        this.operation = operation;
    }

    public int getProduct() {
        return product;
    }

    public int getOperation() {
        return operation;
    }

    public int getRandomOperations() {
        return (int) (Math.random() * 10) + 1;
    }

    public void run() {
        int buyProducts;
        if (Shop.getProducts() > 0) {
            START.countDown();
            buyProducts = getRandomOperations();
            if (Shop.getProducts() < buyProducts) {
                buyProducts = Shop.getProducts();
                Shop.buy(buyProducts);
                product += buyProducts;
            } else {
                product += buyProducts;
                Shop.buy(buyProducts);
            }
            operation++;
            System.out.println("Покупатель " + name + " Операция номер " + getOperation() +
                    " Куплено " + product);
            try {
                START.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}