package by.gsu.winter20.menu;

public interface MenuItem<T> {

    int getOrder();

    String getTitle();

    void execute();
}
