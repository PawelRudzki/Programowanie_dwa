package day_three.delivery_company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PackageContainer {

    public Customer getCustomer() {

        Customer customer = new Customer(
                10,
                "546-656-765",
                "ul. Polna 12, 23-453 Latyczów",
                new ArrayList<>());
        return customer;
    }

    public Package getPackage() throws ParseException {
        Customer customer1 = new Customer(
                10,
                "546-656-765",
                "ul. Polna 12, 23-453 Latyczów",
                new ArrayList<>());
        Customer customer2 = new Customer(
                11,
                "546-656-212",
                "ul. Kwaśna 1, 34-453 Łozy",
                new ArrayList<>());
        Courier courier = new Courier(1001103);
        Warehouse magazine1 = new Warehouse();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sendDate = simpleDateFormat.parse("2019-10-22");
        return new Package(0101, sendDate, Size.SMALL, customer1, customer2, true);
    }

}
