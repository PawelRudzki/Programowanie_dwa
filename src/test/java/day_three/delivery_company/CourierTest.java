package day_three.delivery_company;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CourierTest {

    @Test
    public void pickUpPackage() {


    }

    @Test
    public void visitMagazine() throws ParseException {

        //given
        PackageContainer packageContainer= new PackageContainer();
        Customer customer = packageContainer.getCustomer();
        Package delivery = packageContainer.getPackage();
        Courier courier = new Courier(101);
        Warehouse warehouse = new Warehouse();

        customer.sendPackage(courier, delivery);

        //when

        courier.visitMagazine(warehouse);


        //then
        assertEquals(0, courier.packageList.size());
        assertEquals(1, warehouse.magazineOfPackages.size());


    }

    @Test
    public void deliverPackagesTest() throws ParseException {
//given
        PackageContainer packageContainer= new PackageContainer();
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
    public void generatePackageID() {
    }

    @Test
    public void setCourierID() {
    }

    @Test
    public void getCourierID() {
    }
}