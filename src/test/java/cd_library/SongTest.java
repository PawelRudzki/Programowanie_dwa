package cd_library;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SongTest {

    @Test
    public void testConstructor() {

        //given
        Musician musician1 = new Musician("Yes", "Jon", "Anderson");
        Set<Musician> authors = new HashSet<>();
        authors.add(musician1);


        Set<Genre> genre = new HashSet<>();
        genre.add(Genre.PROGGRESIVE_ROCK);

        int duration = 320;
        String name = "Roundabout";

        //when
        Song song1 = new Song(authors, genre, name, duration);

        //then
        assertEquals("Roundabout", song1.getTitle());
        assertEquals(320, song1.getDuration());

    }



}