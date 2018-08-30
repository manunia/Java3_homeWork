package lesson7.MultyShips;

public class Ship implements Runnable{

    private int CAPACITY = 0;

    private Cruise cruise;

    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    private String product;

    public Ship(Cruise cruise, String product) {
        this.cruise = cruise;
        this.product = product;
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
    }
}
