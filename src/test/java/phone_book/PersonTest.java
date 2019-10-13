package phone_book;

import day_two.phone_book.Person;
import day_two.phone_book.PhoneNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void personDescriptionTest() {
        //given
        Person person = new Person();

        //when

        //then

        assertEquals("Dane kontaktowe osoby", person.description());
    }

    @Test
    public void personAllArgsConstructorTest() {

        //given
        String name = "Jan";
        String lastName = "Barszczuch";
        String adress = "Kryniczna 12, 23-432 Karczowisko";
        PhoneNumber phoneNumber = new PhoneNumber("+48", "5771121");

        //when
        Person person = new Person(name, lastName, adress, phoneNumber);

        //then
        assertEquals("Jan", person.getName());
        assertEquals("Barszczuch", person.getLastName());
        assertEquals("Kryniczna 12, 23-432 Karczowisko", person.getAdress());
        assertEquals("+48", person.getPhoneNumber().getDirectionNumber());
        assertEquals("5771121", person.getPhoneNumber().getRestOfNumber());
    }

}