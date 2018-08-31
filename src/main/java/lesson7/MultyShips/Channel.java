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
            System.out.println(ship.getName() + " приблизился к " + description);
            System.out.println(ship.getName() + " проплывает " + description);
            Thread.sleep(length * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(ship.getName() + " вышел из " + description);
        }
        smp.release();

    }

}
