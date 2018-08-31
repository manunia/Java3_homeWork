package lesson7.MultyShips;

public class Ship implements Runnable{

    private static int SHIP_NUMBER;
    static {
        SHIP_NUMBER = 0;
    }

    private int CAPACITY = 0;
    private Cruise cruise;
    private String product;
    private String name;

    public String getName() {
        return name;
    }

    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public Ship(Cruise cruise, String product) {
        this.cruise = cruise;
        this.product = product;
        SHIP_NUMBER++;
        this.name = "корабль # " + SHIP_NUMBER;
    }

    public String getProduct() {
        return product;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    @Override
    public void run() {
        for (int i = 0; i < cruise.getWaters().size(); i++) {
            cruise.getWaters().get(i).swim(this);
        }
        Main.countDownLatch.countDown();
    }
}
