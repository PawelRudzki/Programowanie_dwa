package phone_book;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    @Test
    public void phoneNumberTest() {

        //given

        PhoneNumber phoneNumber = new PhoneNumber("+48","5771121");

        //when

        //then
        assertEquals("+48", phoneNumber.getDirectionNumber());
        assertEquals("5771121", phoneNumber.getRestOfNumber());
    }

}