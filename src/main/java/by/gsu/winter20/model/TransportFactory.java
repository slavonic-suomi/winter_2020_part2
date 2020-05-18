package by.gsu.winter20.model;


import by.gsu.winter20.model.domain.Car;
import by.gsu.winter20.model.domain.Transport;
import by.gsu.winter20.model.domain.Truck;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.ScannerWrapper;

public class TransportFactory implements Factory<Transport<?>> {

    private ScannerWrapper sc = new ScannerWrapper();

    public Transport<?> create() {
        System.out.println("1 - create Car");
        System.out.println("2 - create Truck");

        int choice = sc.nextInt(1, 2);

        Transport<?> result;
        if (choice == 1) {
            Car car = new Car();

            System.out.println("Input car power");
            int power = sc.nextInt();

            car.setPower(power);

            result =  car;
        } else {
            Truck truck = new Truck();

            System.out.println("Input truck weight");
            int weight = sc.nextInt();

            truck.setWeight(weight);


            result = truck;
        }

        System.out.println("Input transport number");
        String number = sc.nextLine();
        result.setNumber(number);

        System.out.println("Input transport price");
        int price = sc.nextInt();
        result.setPrice(price);


        return result;
    }
}
