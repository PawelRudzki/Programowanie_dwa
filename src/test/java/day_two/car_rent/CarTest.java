package day_two.car_rent;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void carConstructorTest() {

        //given
        Brands brand = Brands.FIAT;
        String model = "Punto";
        String plateNr = "KRK 30989";
        long mileage = 123000;
        int yearOfProduction = 2009;

        //when
        Car car = new Car(brand, model, plateNr, mileage, yearOfProduction);

        //then
        assertEquals(Brands.FIAT, car.getBrand());
        assertEquals("Punto", car.getModel());
        assertEquals("KRK 30989", car.getPlateNr());
        assertEquals(123000, car.getMileage());
        assertEquals(2009, car.getYearOfProduction());
    }

}