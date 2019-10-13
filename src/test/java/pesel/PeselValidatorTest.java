package pesel;

import day_one.pesel.PeselValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeselValidatorTest {

    PeselValidator peselValidator = new PeselValidator();


    @Test
    public void validatePeselCorrect1() {


        //given
        String pesel = "02070803628";

        //when
        boolean result = peselValidator.validate(pesel);


        //then
        assertTrue(result);
    }

    @Test
    public void validatePeselCorrect2() {


        //given
        String pesel = "89022601053";

        //when
        boolean result = peselValidator.validate(pesel);


        //then
        assertTrue(result);
    }

    @Test
    public void validatePeselTooShort() {


        //given
        String pesel = "8902260105";

        //when
        boolean result = peselValidator.validate(pesel);


        //then
        assertFalse(result);
    }

    @Test
    public void validatePeselWrongCharacters() {


        //given
        String pesel = "890tr60105";

        //when
        boolean result = peselValidator.validate(pesel);


        //then
        assertFalse(result);
    }

}