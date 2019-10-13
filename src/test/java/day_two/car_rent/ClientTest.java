package day_two.car_rent;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void clientAllArgsConstructorTest() {

        //given
        Brands brand = Brands.FIAT;
        String model = "Punto";
        String plateNr = "KRK 30989";
        long mileage = 123000;
        int yearOfProduction = 2009;

        Car car = new Car(brand, model, plateNr, mileage, yearOfProduction);
        List<Car> carList = new LinkedList<>();
        carList.add(car);

        //when

        Client client = new Client(carList, 1,
                "Antoni", "Bogusz");

        //then

        assertEquals("Punto", client.getRentedCars().get(0).getModel());
        assertEquals("Antoni", client.getName());
        assertEquals("Bogusz", client.getLastName());
    }


    @Test
    public void rentCar() {

        //given
        Brands brand = Brands.FIAT;
        String model = "Punto";
        String plateNr = "KRK 30989";
        long mileage = 123000;
        int yearOfProduction = 2009;

        Car car = new Car(brand, model, plateNr, mileage, yearOfProduction);
        List<Car> carList = new LinkedList<>();
        carList.add(car);

        CarRent carRent = new CarRent(carList);

        Client client = new Client(new LinkedList<>(), 1,
                "Antoni", "Bogusz");

        //when

        client.rentCar(carRent, Brands.FIAT, "Punto");


        //then

        assertEquals("Punto", client.getRentedCars().get(0).getModel());
        assertEquals("Antoni", client.getName());
        assertEquals("Bogusz", client.getLastName());
        assertFalse(carRent.getCarPool().contains(car));
        assertTrue(carRent.getRentedCars().containsKey(car));
        assertTrue(carRent.getRentedCars().containsValue(client));
    }


    @Test
    public void returnCar() {

        //given
        Brands brand = Brands.FIAT;
        String model = "Punto";
        String plateNr = "KRK 30989";
        long mileage = 123000;
        int yearOfProduction = 2009;

        Car car = new Car(brand, model, plateNr, mileage, yearOfProduction);
        List<Car> carList = new LinkedList<>();
        carList.add(car);

        CarRent carRent = new CarRent(carList);

        Client client = new Client(new LinkedList<>(), 1,
                "Antoni", "Bogusz");

        client.rentCar(carRent, Brands.FIAT, "Punto");

        //when
        client.returnCar(carRent, car);

        //then
        assertTrue(client.getRentedCars().size()==0);
        assertTrue(carRent.getCarPool().contains(car));
        assertFalse(carRent.getRentedCars().containsKey(car));
        assertFalse(carRent.getRentedCars().containsValue(client));

    }
}