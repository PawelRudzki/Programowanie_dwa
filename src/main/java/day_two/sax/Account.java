package day_two.sax;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Account {
    private String iban;
    private String name;
    private String currency;
    private String balance;
    private String closingDate;

    @Override
    public String toString(){
        return iban+" "+name+" "+currency
                +" "+balance+" "+closingDate;
    }
}
