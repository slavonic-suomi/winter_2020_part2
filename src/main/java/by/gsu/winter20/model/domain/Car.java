package by.gsu.winter20.model.domain;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

public class Car extends Transport<Car> {

    private static final long serialVersionUID = 42L;

    private int power;

    public Car() {
    }

    public Car(int price, String number, int power) {
        super(price, number);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Car o) {
        int baseCompare = super.compareTo(o);
        return baseCompare != 0 ? baseCompare : Integer.compare(power, o.power);
    }

    @Override
    public String toString() {
        return "Car{" + "power = " + power + ", " + super.toString() + "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return power == car.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), power);
    }

}
