package day_one.cd_library;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Musician {
    String band;
    String name;
    String lastName;

    public String toString(){
        return band
                +" "+name
                +" "+lastName;
    }
}
