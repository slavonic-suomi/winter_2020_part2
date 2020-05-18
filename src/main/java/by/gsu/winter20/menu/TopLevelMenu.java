package by.gsu.winter20.menu;

import by.gsu.winter20.utils.ScannerWrapper;

import java.util.Arrays;
import java.util.Comparator;

public class TopLevelMenu<T> implements MenuItem<T> {

    private MenuItem<T>[] items;
    private ScannerWrapper sc = new ScannerWrapper();
    private String title;
    private int order;

    public TopLevelMenu(MenuItem<T>[] items, String title, int order) {
        Arrays.sort(items, new Comparator<MenuItem<T>>() {
            @Override
            public int compare(MenuItem<T> o1, MenuItem<T> o2) {
                return Integer.compare(o1.getOrder(), o2.getOrder());
            }
        });
        this.items = items;
        this.title = title;
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() {
        run();
    }

    public void run() {
        while (true) {
            printHelp();
            int choice = sc.nextInt();
            if (choice == 0) {
                return;
            }
            for (MenuItem<T> item : items) {
                if (item.getOrder() == choice) {
                    item.execute();
                    break;
                }
            }
        }

    }

    private void printHelp() {
        for (MenuItem<T> item : items) {
            System.out.println(item.getOrder() + " - " + item.getTitle());
        }
        System.out.println("0 - exit");
    }
}
