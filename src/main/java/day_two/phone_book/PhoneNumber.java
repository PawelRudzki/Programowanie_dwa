package day_two.phone_book;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhoneNumber implements Comparable<PhoneNumber> {
    private String directionNumber;
    private String restOfNumber;

    public int compareTo(PhoneNumber someNumber) {
        return this.restOfNumber.compareTo(someNumber.restOfNumber);
    }
}
