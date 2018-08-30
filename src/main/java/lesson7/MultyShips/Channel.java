package lesson7.MultyShips;

import java.util.concurrent.Semaphore;

public class Channel extends Water {

    public Semaphore smp = new Semaphore(5);

    public Channel() {
        this.length = 100;
        this.description = "Пролив " + length + " морских миль";
    }

    @Override
    public void swim(Ship ship) {
        try {
            smp.acquire();
            //System.out.println(ship.getProduct() + " приблизился к " + description);
            //System.out.println(ship.getProduct() + " продплывает " + description);
            Thread.sleep(length * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //System.out.println(ship.getProduct() + " вышел из " + description);
        }
        smp.release();

    }

}
