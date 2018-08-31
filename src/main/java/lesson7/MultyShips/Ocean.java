package lesson7.MultyShips;

public class Ocean extends Water {

    public Ocean(int lenght) {
        this.length = lenght;
        this.description = "морской путь " + lenght + " морских миль";
    }

    @Override
    public void swim(Ship ship) {
        try {
            System.out.println(ship.getName() + " преодолевает " + description);
            Thread.sleep( length * 10);
            System.out.println(ship.getName() + " преодолел " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
