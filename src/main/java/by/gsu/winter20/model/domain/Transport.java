package by.gsu.winter20.model.domain;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.Objects;

public abstract class Transport<E extends Transport<E>> implements Comparable<E>, Serializable {
    private int price;
    private String number;

    public Transport() {
    }

    public Transport(int price, String number) {
        this.price = price;
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(E o) {
        int priceCompare = Integer.compare(price, o.getPrice());
        return priceCompare != 0 ? priceCompare : number.compareTo(o.getNumber());
    }

    @Override
    public String toString() {
        return "number = " + number + ", price = " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?> transport = (Transport<?>) o;
        return price == transport.price &&
                Objects.equals(number, transport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, number);
    }
}
