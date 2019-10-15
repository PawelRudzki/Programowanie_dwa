package day_two.car_rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class CarRent {

    private List<Car> carPool;
    private List<Reservation> reservationsList;
    private Map<Car, Client> rentedCars = new HashMap<>();
    private List<Client> clientsList;

    Car lendCar(Brands brand,
                       String model,
                       Client client) {

        Car carToRent = carPool.stream()
                .filter(a -> brand.equals(a.getBrand()))
                .filter(b -> model.equals(b.getModel()))
                .findAny().orElse(null);
        if (carToRent == null) {
            System.out.println("No such car in carpool.");
            return null;
        }

        rentedCars.put(carToRent, client);
        carPool.remove(carToRent);
        client.addCar(carToRent);

        return carToRent;
    }

    void reserveCar(Car car,
                           Client client,
                           Date since,
                           Date to) {
        Optional<Reservation> foundReservation = reservationsList.stream()
                .filter(a -> a.getCar().equals(car))
                .filter(a ->
                                (a.getReservedSince().getTime() <= since.getTime() &&
                        a.getReservedTo().getTime() >= to.getTime()) ||

                                (a.getReservedSince().getTime() > since.getTime() &&
                        a.getReservedTo().getTime() >= to.getTime()) ||

                                (a.getReservedSince().getTime() <= since.getTime() &&
                        a.getReservedTo().getTime() < to.getTime())).findAny();

        if (!foundReservation.isPresent()) {
            reservationsList.add(new Reservation(since, to, car, client));
        } else throw new IllegalStateException("Car already reserved for this period.");


    }


    void acceptCarBack(Car car) {
        if (rentedCars.containsKey(car)) {
            rentedCars.get(car).removeCar(car);
            rentedCars.remove(car);
            carPool.add(car);

        } else {
            System.out.println("This is not our car!");
        }
    }

    CarRent(List<Car> carPool) {
        this.carPool = carPool;
        this.reservationsList = new ArrayList<>();
    }
}
