package lesson7.MultyShips;

public class Dock extends Water {

    private String product;
    private int productWeight;

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public Dock(String product, int productWeight) {
        this.product = product;
        this.productWeight = productWeight;

    }

    @Override
    public void swim(Ship ship) {

        try {
            System.out.println(ship.getName() + " причалил.");

            System.out.println(ship.getName() + " начал загрузку " + product);
            while (ship.getCAPACITY() != 500) {
                Thread.sleep(1000);
                ship.setCAPACITY(ship.getCAPACITY() + 100);
            }
            if (productWeight <= 500) {
                ship.setCAPACITY(productWeight);
            }
            setProductWeight(productWeight - ship.getCAPACITY());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(product + " осталось " + productWeight);
        System.out.println(ship.getName() + " погружен " + product);
//        try {
//            cdl.await(10, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
