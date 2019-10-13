package day_one.cd_library;

import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Library {

    List<Album> listOfAlbums = new LinkedList<>();

    public Album find(String albumName) {
        return listOfAlbums.stream()
                .filter(a -> a.getAlbumName()
                        .equals(albumName))
                .findAny()
                .orElse(null)
                ;
    }

    public void addAlbum(Album album) {
        listOfAlbums.add(album);
    }

    public void removeAlbum(Album album) {
        listOfAlbums.remove(album);
    }

    public String toString() {
        List<String> stringOfAlbums = listOfAlbums.stream()
                .map(a -> a.toString())
                .collect(Collectors.toList());

        return stringOfAlbums.stream().reduce("", (tmp, a) -> tmp += a);
    }

    public void save() throws FileNotFoundException {
        File file = new File("library.txt");
        PrintWriter save = new PrintWriter("library.txt");

        listOfAlbums.forEach(album -> {
            save.println("---");
            save.println(album.getAlbumName());
            save.println(album.getAlbumFormat());

            album.getAlbumSongs().forEach(song -> {
                List<String> songAuthors = song.getAuthors()
                        .stream()
                        .map(a -> a.toString())
                        .collect(Collectors.toList());

                List<String> songGenres = song.getGenre()
                        .stream()
                        .map(a -> a.toString())
                        .collect(Collectors.toList());

                save.print(songAuthors.stream().reduce("", (tmp, a) -> tmp += a + "#"));
                save.print("terminator");
                save.print("%");
                save.print(song.getTitle());
                save.print("%");

                save.print(song.getDuration());
                save.print("%");

                save.print(songGenres.stream().reduce("", (tmp, a) -> tmp += a + "#"));

                save.print("terminator");

                save.println();
            });
        });
        save.close();
    }

    public Library load(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Library library = new Library();

        String tmp = scan.nextLine();
        int counter = 0;
        while (tmp != null) {
            if (tmp.equals("---")) {
                library.listOfAlbums.add(counter,
                        new Album(scan.nextLine(),
                                AlbumFormats.valueOf(scan.nextLine())));

            }

            try {
                tmp = scan.nextLine();
            } catch (NoSuchElementException e) {
                return library;
            }

            while (!tmp.equals("---")) {
                String tabOfSong[] = tmp.split("%");

                String tabOfAuthors[] = tabOfSong[0].split("#");

                Set<Musician> musicansSet = new HashSet<>();
                for (int i = tabOfAuthors.length - 2; i >= 0; i--) {
                    Scanner scan2 = new Scanner(tabOfAuthors[i]);
                    Musician tmpMusician = new Musician(scan2.next(), scan2.next(), scan2.next());
                    musicansSet.add(tmpMusician);
                }


                String tabOfGenres[] = tabOfSong[3].split("#");
                Set<Genre> genresSet = new HashSet<>();
                for (int i = 0; i < tabOfGenres.length - 1; i++) {
                    Scanner scan2 = new Scanner(tabOfGenres[i]);
                    genresSet.add(Genre.valueOf(scan2.next()));
                }

                library.listOfAlbums.get(counter)
                        .addSong(new Song(musicansSet,
                                genresSet,
                                tabOfSong[1],
                                Integer.valueOf(tabOfSong[2])));

                try {
                    tmp = scan.nextLine();
                } catch (NoSuchElementException e) {
                    return library;
                }


            }

            library.listOfAlbums.get(counter).albumUpdate();
            counter++;

        }


        return library;
    }


}
