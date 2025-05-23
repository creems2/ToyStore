package model;

public class Toy {
    private int id;
    private String name;
    private int weight;  // Вес для выпадения

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
