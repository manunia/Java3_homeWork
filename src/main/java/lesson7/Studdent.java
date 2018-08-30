package lesson7;

@XTable(name = "students")
public class Studdent {

    @XField
    int id;

    @XField
    String name;

    @XField
    int score;

    @XField
    String email;

    public Studdent(int id, String name, int score, String email) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.email = email;
    }
}
