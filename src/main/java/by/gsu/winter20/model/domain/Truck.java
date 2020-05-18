package by.gsu.winter20.model.domain;

import java.util.Objects;

public class Truck extends Transport<Truck> {
    private int weight;

    public Truck() {
    }

    public Truck(int price, String number, int weight) {
        super(price, number);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Truck o) {
        int baseCompare = super.compareTo(o);
        return baseCompare != 0 ? baseCompare : Integer.compare(weight, o.weight);
    }

    @Override
    public String toString() {
        return "Truck{" + "weight = " + weight + ", " + super.toString() + "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return weight == truck.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
