package by.gsu.winter20;


import by.gsu.winter20.menu.*;
import by.gsu.winter20.model.TransportFactory;
import by.gsu.winter20.model.domain.Transport;
import by.gsu.winter20.network.NetworkClientContainer;
import by.gsu.winter20.utils.Container;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.LocalContainer;

import java.io.IOException;

public class GenericMenuMain {

    public static void main(String[] args) throws IOException {

        Factory<Transport<?>> factory = new TransportFactory();
        Container<Transport<?>> container = new NetworkClientContainer<Transport<?>>("localhost", 8080);

        MenuItem<Transport<?>>[] items = new MenuItem[3];

        items[0] = new AddMenuItem<>(container, factory);
        items[1] = new DeleteMenuItem<>(container);
        items[2] = new PrintAllMenuItem<>(container);
        TopLevelMenu<Transport<?>> menu1 = new TopLevelMenu<>(items, "transport menu", 0);

        menu1.execute();
    }
}
