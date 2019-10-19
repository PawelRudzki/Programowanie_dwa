package day_three.delivery_company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class Package {

    private int id;
    private Date sendDate;
    private Size size;
    private Customer sender;
    private Customer recipent;
    private boolean flagToMagazine;

}
