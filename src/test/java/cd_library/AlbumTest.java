package cd_library;

import day_one.cd_library.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class AlbumTest {

    @Test
    public void constructorTest() {

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
        Album album = new Album("Fragile", AlbumFormats.CD);
        album.addSong(song1);

        //then
        assertEquals("Fragile", album.getAlbumName());
    }

    @Test
    public void findTest() {

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
        Album album = new Album("Fragile", AlbumFormats.CD);
        album.addSong(song1);

        //then
        assertEquals(song1.getAuthors(), album.find("Roundabout").getAuthors());


    }

    @Test
    public void findTestNotFound() {

        //given
        //when
        Album album = new Album("Fragile", AlbumFormats.CD);

        //then
        assertNull(album.find("Roundabout"));


    }

    @Test
    public void findTestNull() {

        //given
        //when
        Album album = new Album("Fragile", AlbumFormats.CD);

        //then
        assertNull(album.find(null));
    }

}