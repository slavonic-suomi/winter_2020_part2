package by.gsu.winter20.network;

import by.gsu.winter20.utils.Container;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;

public class NetworkClientContainer<T extends Serializable> implements Container<T> {

    private final Socket socket;
    private final ObjectOutputStream oos;
    private final ObjectInputStream ois;

    public NetworkClientContainer(String host, int port) throws IOException {
        socket = new Socket(host, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(T element) {
        Request request = new Request(Type.ADD, element);
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set(int index, T element) {
        Request request = new Request(Type.UPDATE, new UpdatePayload(index, element));
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        Request request = new Request(Type.DELETE, index);
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<T> getAll() {
        Request request = new Request(Type.GET, null);

        try {
            oos.writeObject(request);
            oos.flush();
            Response response = (Response) ois.readObject();
            return (Collection<T>) response.getPayload();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
