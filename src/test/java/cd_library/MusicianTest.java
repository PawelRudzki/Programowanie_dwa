package cd_library;

import day_one.cd_library.Musician;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MusicianTest {

    @Test
    public void musicianCompareToTest(){


        //given
        Musician musician1 = new Musician("Yes", "Jon", "Anderson");
        Musician musician2 = new Musician("Yes", "Jon", "Anderson");

        //when

        //then
        assertEquals(0, musician1.compareTo(musician2));
    }
}
