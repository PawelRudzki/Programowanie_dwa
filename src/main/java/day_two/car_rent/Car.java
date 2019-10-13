package day_two.car_rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
public class Car {
    private Brands brand;
    private String model;
    private String plateNr;
    private long mileage;
    private int yearOfProduction;


}
