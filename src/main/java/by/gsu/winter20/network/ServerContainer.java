package by.gsu.winter20.network;

import by.gsu.winter20.model.domain.Transport;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerContainer {

    private static ExecutorService executorService;
    private static CopyOnWriteArrayList<Transport<?>> list = new CopyOnWriteArrayList<>();


    public static void main(String[] args) throws IOException {
        executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("new connection opened");
            process(socket);
        }
    }

    private static void process(Socket socket) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    ObjectInputStream ois  = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                    System.out.println("ready to communicate");

                    while (true) {
                        communicate(ois, oos);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void communicate(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {


        Request request = (Request) ois.readObject();

        System.out.println(request);

        switch (request.getType()) {
            case ADD: {
                Transport<?> element = (Transport<?>) request.getPayload();
                list.add(element);
                break;
            }
            case GET: {
                Response response = new Response(list);
                for (Transport<?> transport : list) {
                    Thread.sleep(1_000);
                    System.out.println(transport);
                }
                oos.writeObject(response);
                oos.flush();
                break;
            }
        }

    }
}
