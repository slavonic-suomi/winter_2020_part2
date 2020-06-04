package by.gsu.winter20.network;

import java.io.Serializable;

public class UpdatePayload implements Serializable {
    private int index;
    private Serializable element;

    public UpdatePayload() {
    }

    public UpdatePayload(int index, Serializable element) {
        this.index = index;
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Serializable getElement() {
        return element;
    }

    public void setElement(Serializable element) {
        this.element = element;
    }
}
