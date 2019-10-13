package cd_library;

import day_one.cd_library.*;
import org.junit.Test;

import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library = new Library();

    Musician musician1 = new Musician("Yes", "Jon", "Anderson");
    Set<Musician> authors = new HashSet<>();

    Set<Genre> genre = new HashSet<>();

    Song song1 = new Song(authors, genre, "Roundabout", 510);
    Song song2 = new Song(authors, genre, "Five percent for nothing",35);


    Album fragile = new Album("Fragile", AlbumFormats.CD);


    @Test
    public void find() {

        //given
        authors.add(musician1);
        genre.add(Genre.PROGGRESIVE_ROCK);
        fragile.addSong(song1);
        fragile.addSong(song2);

        //when
        Album foundAlbum = library.find("Fragile");

        //then
        assertEquals(fragile.getAlbumName(), foundAlbum.getAlbumName());



    }

    @Test
    public void toStringTest(){

        //given
        Musician musician1 = new Musician("Yes", "Jon", "Anderson");
        Set<Musician> authors = new HashSet<>();
        authors.add(musician1);


        Set<Genre> genre = new HashSet<>();
        genre.add(Genre.PROGGRESIVE_ROCK);

        Song song1 = new Song(authors, genre, "Roundabout", 510);
        Song song2 = new Song(authors, genre, "Five percent for nothing",35);


        Musician musician2 = new Musician("Jethro Tull", "Ian", "Anderson");
        Set<Musician> authors2 = new HashSet<>();
        authors2.add(musician2);

        Set<Genre> genre2 = new HashSet<>();
        genre2.add(Genre.FOLCK);
        genre2.add(Genre.ROCK);

        Song song3 = new Song(authors2, genre2, "Aqualung",240);


        Album fragile = new Album("Fragile", AlbumFormats.CD);
        fragile.addSong(song1);
        fragile.addSong(song2);

        Album aqualung = new Album("Aqualung", AlbumFormats.CD);

        aqualung.addSong(song3);

        //when

        Library library = new Library();
        library.addAlbum(fragile);
        library.addAlbum(aqualung);

        //then

        assertEquals("\n"+"Fragile [PROGGRESIVE_ROCK] CD [Yes Jon Anderson]\n" +
                "[Yes Jon Anderson] \"Roundabout\" 8.5 min [PROGGRESIVE_ROCK]\n" +
                "[Yes Jon Anderson] \"Five percent for nothing\" 0.5833333333333334 min [PROGGRESIVE_ROCK]\n" +
                "\n" +
                "Aqualung [FOLCK, ROCK] CD [Jethro Tull Ian Anderson]\n" +
                "[Jethro Tull Ian Anderson] \"Aqualung\" 4.0 min [FOLCK, ROCK]"+"\n", library.toString());

    }

    @Test
    public void addAlbum() {
    }

    @Test
    public void removeAlbum() {
    }

    @Test
    public void save() throws FileNotFoundException {


        //given
        Musician musician1 = new Musician("Yes", "Jon", "Anderson");
        Set<Musician> authors = new HashSet<>();
        authors.add(musician1);


        Set<Genre> genre = new HashSet<>();
        genre.add(Genre.PROGGRESIVE_ROCK);

        Song song1 = new Song(authors, genre, "Roundabout", 510);
        Song song2 = new Song(authors, genre, "Five percent for nothing",35);


        Musician musician2 = new Musician("Jethro_Tull", "Ian", "Anderson");
        Musician musician3 = new Musician("Jethro_Tull", "Martin", "Barre");
        Set<Musician> authors2 = new HashSet<>();
        authors2.add(musician2);
        authors2.add(musician3);

        Set<Genre> genre2 = new HashSet<>();
        genre2.add(Genre.FOLCK);
        genre2.add(Genre.ROCK);

        Song song3 = new Song(authors2, genre2, "Aqualung",240);


        Album fragile = new Album("Fragile", AlbumFormats.CD);
        fragile.addSong(song1);
        fragile.addSong(song2);

        Album aqualung = new Album("Aqualung", AlbumFormats.CD);

        aqualung.addSong(song3);

        Library library = new Library();
        library.addAlbum(fragile);
        library.addAlbum(aqualung);

        //when
        library.save();
        Scanner scan;
        scan = new Scanner(new File("library.txt"));

        String tmp = "";
        while (scan.hasNext()) {
            tmp += scan.nextLine()+"\n";
        }


        //then

        assertEquals("---\n" +
                "Fragile\n" +
                "CD\n" +
                "[Yes Jon Anderson]%Roundabout%510%[PROGGRESIVE_ROCK]\n" +
                "[Yes Jon Anderson]%Five percent for nothing%35%[PROGGRESIVE_ROCK]\n" +
                "---\n" +
                "Aqualung\n" +
                "CD\n" +
                "[Jethro Tull Ian Anderson]%Aqualung%240%[FOLCK, ROCK]\n",tmp);


    }

    @Test
    public void load() throws FileNotFoundException {



        //given
        Musician musician1 = new Musician("Yes", "Jon", "Anderson");
        Set<Musician> authors = new HashSet<>();
        authors.add(musician1);


        Set<Genre> genre = new HashSet<>();
        genre.add(Genre.PROGGRESIVE_ROCK);

        Song song1 = new Song(authors, genre, "Roundabout", 510);
        Song song2 = new Song(authors, genre, "Five percent for nothing",35);


        Musician musician2 = new Musician("Jethro_Tull", "Ian", "Anderson");
        Musician musician3 = new Musician("Jethro_Tull", "Martin", "Barre");
        Set<Musician> authors2 = new HashSet<>();
        authors2.add(musician2);
        authors2.add(musician3);

        Set<Genre> genre2 = new HashSet<>();
        genre2.add(Genre.FOLCK);
        genre2.add(Genre.ROCK);

        Song song3 = new Song(authors2, genre2, "Aqualung",240);


        Album fragile = new Album("Fragile", AlbumFormats.CD);
        fragile.addSong(song1);
        fragile.addSong(song2);

        Album aqualung = new Album("Aqualung", AlbumFormats.CD);

        aqualung.addSong(song3);

        Library library = new Library();
        library.addAlbum(fragile);
        library.addAlbum(aqualung);

        library.save();


        //when

        File file = new File("library.txt");
        Library loadedLibrary = library.load(file);

        //then
//        assertEquals(library.find("Fragile").toString(), loadedLibrary.find("Fragile").toString());
        assertEquals(library.toString(), loadedLibrary.toString());




    }
}