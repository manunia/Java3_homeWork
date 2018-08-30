package lesson7.MultyShips;

public abstract class Water {

    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void swim(Ship ship);
}
