package day_two.phone_book;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person extends Entry {


    private String name;
    private String lastName;
    private String adress;
    private PhoneNumber phoneNumber;


    @Override
    public String description() {
        return "Dane kontaktowe osoby";
    }
}
