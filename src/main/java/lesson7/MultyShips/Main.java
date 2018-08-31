package lesson7.MultyShips;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static final int CLOTHES_SHIP_COUNT = 6;
    public static final int FOOD_SHIP_COUNT = 12;
    public static final int FUEL_SHIP_COUNT = 17;

    public static CountDownLatch countDownLatch = new CountDownLatch(35);

    public static void main(String[] args) {

        Cruise cruise1 = new Cruise(new Ocean(100),new Channel(),new Dock("одежда",2700),new Channel(),new Ocean(100));
        Ship[] clothesShip = new Ship[CLOTHES_SHIP_COUNT];
        for (int i = 0; i < clothesShip.length; i++) {
            clothesShip[i] = new Ship(cruise1,"одежда");
        }
        for (int i = 0; i < clothesShip.length; i++) {
            new Thread(clothesShip[i]).start();
        }


        Cruise cruise2 = new Cruise(new Ocean(100),new Channel(),new Dock("еда",5900),new Channel(),new Ocean(100));
        Ship[] foodShip = new Ship[FOOD_SHIP_COUNT];

        for (int i = 0; i < foodShip.length; i++) {
            foodShip[i] = new Ship(cruise2,"еда");
        }
        for (int i = 0; i < foodShip.length; i++) {
            new Thread(foodShip[i]).start();
        }

        Cruise cruise3 = new Cruise(new Ocean(100),new Channel(),new Dock("топливо",8500),new Channel(),new Ocean(100));
        Ship[] fuelShip = new Ship[FUEL_SHIP_COUNT];
        for (int i = 0; i < fuelShip.length; i++) {
            fuelShip[i] = new Ship(cruise3,"топливо");
        }
        for (int i = 0; i < fuelShip.length; i++) {
            new Thread(fuelShip[i]).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----Все товары перевезены----------");

    }
}
