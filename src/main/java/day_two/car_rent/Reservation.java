package day_two.car_rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Reservation {

    private Date reservedSince;
    private Date reservedTo;
    private Car car;
    private Client client;

}
