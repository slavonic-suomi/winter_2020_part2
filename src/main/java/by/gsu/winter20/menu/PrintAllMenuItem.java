package by.gsu.winter20.menu;

import by.gsu.winter20.utils.Container;

import java.util.Collection;

public class PrintAllMenuItem<T> implements MenuItem<T> {

    private Container<T> container;

    public PrintAllMenuItem(Container<T> container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 4;
    }

    @Override
    public String getTitle() {
        return "Print all";
    }

    @Override
    public void execute() {
        Collection<T> all = container.getAll();
        for (T element : all) {
            System.out.println(element.toString());
        }
    }
}
