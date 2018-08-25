package lesson5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable{
    //создаем барьер для старта машин
    private static CyclicBarrier cb = new CyclicBarrier(4);

    private static AtomicInteger ai = new AtomicInteger(0);

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public int getSpeed() {
        return speed;
    }

    public String getCarName() {
        return name;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник № " + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.getCdl2().countDown();//уменьшаем счетчик ожидания готовности машин
            cb.await();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        MainClass.getCdl().countDown();//уменьшаем счетчик ожидания всех потоков

        if (ai.incrementAndGet() == 1) {
            System.out.println(this.name + " WIN");
        }
    }
}
