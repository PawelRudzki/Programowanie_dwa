package day_two.car_rent;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class CarRent {

    private List<Car> carPool;
    private List<Reservation> reservationsList;
    private Map<Car, Client> rentedCars = new HashMap<>();
    private List<Client> clientsList;

    public Car lendCar(Brands brand, String model, Client client){

        Car carToRent = carPool.stream()
                .filter(a-> brand.equals(a.getBrand()))
                .findAny().orElse(null);
        if (carToRent == null) {
            System.out.println("No such car in carpool");
            return null;
        }

        rentedCars.put(carToRent, client);
        carPool.remove(carToRent);
        client.addCar(carToRent);

        return carToRent;
    }


    public CarRent(List<Car> carPool){
        this.carPool=carPool;
    }

    public void acceptCarBack(Car car){
        if (rentedCars.containsKey(car)){
            rentedCars.get(car).removeCar(car);
            rentedCars.remove(car);
            carPool.add(car);

        } else {
            System.out.println("This is not our car!");
        }
    }

}
