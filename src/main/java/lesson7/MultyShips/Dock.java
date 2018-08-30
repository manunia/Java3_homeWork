package lesson7.MultyShips;

public class Dock extends Water {

    private String product;
    private int productWeight;
    private Ship ship;

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public Dock(String product, int productWeight) {
        this.product = product;
        this.productWeight = productWeight;

    }


    @Override
    public void swim(Ship ship) {
        while (productWeight != 0) {
            try {
                //System.out.println(ship.getProduct() + " причалил.");
                //System.out.println(ship.getProduct() + " начал загрузку.");
                //while (ship.getCAPACITY() != 500) {
                    Thread.sleep(1000);
                    ship.setCAPACITY(ship.getCAPACITY() + 100);
                    //productWeight -= ship.getCAPACITY();
                    setProductWeight(productWeight - ship.getCAPACITY());
                //}
                //System.out.println(ship.getProduct() + " закончил загрузку.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(product + " погружен");

        }

}
