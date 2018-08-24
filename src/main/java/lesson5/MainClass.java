package lesson5;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    //ожидаем завершения операций в других потоках
    public static CountDownLatch cdl;
    //ожидаем когда все машины будут годовы к старту
    public static CountDownLatch cdl2;

    public static CountDownLatch getCdl() {
        return cdl;
    }

    public static CountDownLatch getCdl2() {
        return cdl2;
    }

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60),new Tunnel(),new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        cdl = new CountDownLatch(CARS_COUNT);
        cdl2 = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race,20 + (int) (Math.random() * 10));
        }
        Thread[] threads = new Thread[cars.length];
        for (int i = 0; i < cars.length; i++) {
            threads[i] = new Thread(cars[i]);
            threads[i].start();
        }
        try {
            cdl2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" );
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //узнаем кто победитель
        for (int i = 0; i < cars.length; i++) {
            if (threads[i].getState() == Thread.State.TERMINATED) {
                System.out.println(cars[i].getName() + " - WINNER!!!");
                break;
            }
        }

        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" );
    }
}
