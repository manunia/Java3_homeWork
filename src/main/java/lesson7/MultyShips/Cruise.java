package lesson7.MultyShips;

import java.util.ArrayList;
import java.util.Arrays;

public class Cruise {
    private ArrayList<Water> waters;

    public ArrayList<Water> getWaters() {
        return waters;
    }

    public Cruise(Water... waters) {
        this.waters = new ArrayList<>(Arrays.asList(waters));
    }
}
