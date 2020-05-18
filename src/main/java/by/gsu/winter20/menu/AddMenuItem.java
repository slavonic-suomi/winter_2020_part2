package by.gsu.winter20.menu;

import by.gsu.winter20.utils.Container;
import by.gsu.winter20.utils.Factory;

public class AddMenuItem<T> implements MenuItem<T> {

    private Container<T> container;
    private Factory<T> factory;

    public AddMenuItem(Container<T> container, Factory<T> factory) {
        this.container = container;
        this.factory = factory;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getTitle() {
        return "Add element";
    }

    @Override
    public void execute() {
        container.add(factory.create());
    }
}
