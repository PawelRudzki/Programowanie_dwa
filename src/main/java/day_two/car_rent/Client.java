package day_two.car_rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Client {


    private List<Car> rentedCars;
    private int clientId;
    private String name;
    private String lastName;

    public void addCar(Car car) {
        rentedCars.add(car);
    }

    public void removeCar(Car car) {
        rentedCars.remove(car);
    }

    public void rentCar(CarRent carRent, Brands brand, String model) {
        carRent.lendCar(brand, model, this);
    }

    public void returnCar(CarRent carRent, Car car){
        if (rentedCars.contains(car)){
            carRent.acceptCarBack(car);
        }
    }

}
