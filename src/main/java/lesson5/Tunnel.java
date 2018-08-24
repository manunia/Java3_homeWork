package lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    //создадим ограничение, что в тоннель не сможет заехать больше половины участников
    public Semaphore smp = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " готовится к этапу (ждет) " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length/c.getSpeed()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        smp.release();
    }
}
