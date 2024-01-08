package library;

public class Member {
    private int id;
    private String name;

    // Constructor
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for id
    public int getId() {
        return id;
    }
}
