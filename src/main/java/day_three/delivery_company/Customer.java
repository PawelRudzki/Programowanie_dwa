package day_three.delivery_company;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
class Customer {

    private int id;
    private String phoneNumber;
    private String adress;
    private List<Package> packagesOfCustomer;
    void sendPackage(Courier courier,
                     Package delivery) {
        courier.pickUpPackage(this, delivery);
    }

}
