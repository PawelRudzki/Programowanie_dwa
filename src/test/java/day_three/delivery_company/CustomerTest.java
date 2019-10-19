package day_three.delivery_company;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void sendPackage() throws ParseException {

        //given
        PackageContainer packageContainer = new PackageContainer();
        Customer customer = packageContainer.getCustomer();
        Package delivery = packageContainer.getPackage();
        Courier courier = new Courier(101);
        Warehouse warehouse = new Warehouse();

        //when
        customer.sendPackage(courier, delivery);


        //then
        assertEquals(1, courier.packageList.size());

    }

    @Test
    public void recievePackage() throws ParseException {

        //given
        PackageContainer packageContainer = new PackageContainer();
        Customer customer = packageContainer.getCustomer();
        Package delivery = packageContainer.getPackage();
        Courier courier = new Courier(101);
        Warehouse warehouse = new Warehouse();

        customer.sendPackage(courier, delivery);

        courier.visitMagazine(warehouse);

        warehouse.makePackagesReadyToBePicked();
        courier.visitMagazine(warehouse);


        //when


        courier.deliverPackages();


        //then
        assertEquals(0, courier.packageList.size());
        assertEquals(1, delivery.getRecipent().getPackagesOfCustomer().size());

    }

    @Test
    public void getId() {
    }

    @Test
    public void getPhoneNumber() {
    }

    @Test
    public void getAdress() {
    }

    @Test
    public void getPackagesOfCustomer() {
    }
}