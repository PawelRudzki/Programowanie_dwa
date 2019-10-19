package day_three.delivery_company;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

class Courier {

    @Setter
    @Getter
    private int courierID;
    Map<Integer, Package> packageList = new HashMap<>();


    void pickUpPackage(Customer sender, Package delivery) {
        int packageID = this.generatePackageID();
        packageList.put(delivery.getId(), delivery);
    }


    void visitMagazine(Warehouse warehouse) {
        packageList
                .entrySet()
                .stream()
                .filter(a -> a.getValue().isFlagToMagazine())
                .forEach(b -> warehouse.getMagazineOfPackages().put(b.getKey(), b.getValue()));



        packageList.clear();


        warehouse.getMagazineOfPackages()
                .entrySet()
                .stream()
                .filter(a -> !a.getValue().isFlagToMagazine())
                .forEach(b -> this.packageList.put(b.getKey(), b.getValue()));


    }

    void deliverPackages() {

        if (packageList.size() == 0) {
            throw new IllegalStateException("Courier number: " + this.getCourierID() + " has no packages to delivery.");
        }
        Package delivery = packageList
                .entrySet()
                .stream()
                .filter(a -> !a.getValue().isFlagToMagazine())
                .map(b-> b.getValue())
                .findFirst()
                .orElse(null);

        delivery.getRecipent().getPackagesOfCustomer().add(delivery);
        packageList.clear();

//                .forEach(b -> {
//                    b.getValue().getRecipent().getPackagesOfCustomer().add(b.getValue());
//                    packageList.remove(b.getKey());
//                });

    }


    Courier(int id) {
        this.courierID = id;
    }

    public int generatePackageID() {
        Random randomGenerator = new Random();
        return randomGenerator
                .nextInt();
    }
}
