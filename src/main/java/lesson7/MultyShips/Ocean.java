package lesson7.MultyShips;

public class Ocean extends Water {

    public Ocean(int lenght) {
        this.length = lenght;
        this.description = "морской путь " + lenght + " морских миль";
    }

    @Override
    public void swim(Ship ship) {
        try {
            //System.out.println(ship.getProduct() + " преодолевает " + description);
            Thread.sleep(length * 1000);
            //System.out.println(ship.getProduct() + " преодолел " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
