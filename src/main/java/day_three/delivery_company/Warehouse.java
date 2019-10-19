package day_three.delivery_company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class Warehouse {

    Map<Integer, Package> magazineOfPackages = new HashMap<>();

    public void acceptPackage(Courier courier, int id) {
        magazineOfPackages.put(id, courier.packageList.get(id));
        courier.packageList.remove(id);
        magazineOfPackages.get(id).setFlagToMagazine(false);
    }

    public void makePackagesReadyToBePicked(){
        magazineOfPackages
                .entrySet()
                .stream()
                .forEach(a-> a.getValue().setFlagToMagazine(false));
    }
}
