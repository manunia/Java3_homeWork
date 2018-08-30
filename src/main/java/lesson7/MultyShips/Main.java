package lesson7.MultyShips;

public class Main {

    public static final int CLOTHES_SHIP_COUNT = 6;
    public static final int FOOD_SHIP_COUNT = 12;
    public static final int FUEL_SHIP_COUNT = 17;

    public static void main(String[] args) {
        System.out.println("Круиз начинается");
        Cruise cruise1 = new Cruise(new Ocean(500),new Channel(),new Dock("одежда",2700));
        Ship[] clothesShip = new Ship[CLOTHES_SHIP_COUNT];
        for (int i = 0; i < clothesShip.length; i++) {
            clothesShip[i] = new Ship(cruise1,"одежда");
        }
        for (int i = 0; i < clothesShip.length; i++) {
            new Thread(clothesShip[i]).start();
        }
    }
}
