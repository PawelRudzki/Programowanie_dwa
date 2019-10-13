package phone_book;

import day_two.phone_book.Company;
import day_two.phone_book.PhoneNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void companydescriptionTest() {
        //given
        Company company = new Company();

        //when

        //then

        assertEquals("Dane kontaktowe firmy", company.description());
    }

    @Test
    public void companyConstructorTest(){
        //given
        String name = "JanuszPol Drewno i meble";
        String adress = "Kryniczna 13, 23-432 Karczowisko";
        PhoneNumber phoneNumber = new PhoneNumber("+48", "5771121");

        //when
        Company company = new Company(name, adress, phoneNumber);

        //then
        assertEquals("JanuszPol Drewno i meble", company.getName());
        assertEquals("Kryniczna 13, 23-432 Karczowisko", company.getAdress());
        assertEquals("+48", company.getPhoneNumber().getDirectionNumber());
        assertEquals("5771121", company.getPhoneNumber().getRestOfNumber());

    }
}

