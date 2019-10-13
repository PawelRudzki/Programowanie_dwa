package day_one.cd_library;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter

public class Album {

    private AlbumFormats albumFormat;
    private String albumName;
    private List<Song> albumSongs = new LinkedList<Song>();
    private Set<Musician> albumAuthors = new HashSet<>();
    private Set<Genre> albumGenre = new HashSet<>();
    private int duration;

    public void addSong(Song song) {
        albumSongs.add(song);
        albumAuthors.addAll(song.getAuthors());
        albumGenre.addAll(song.getGenre());
        this.duration += song.getDuration();
    }

    public void removeSong(Song song) {
        albumSongs.remove(song);
        albumUpdate();
    }

    public Song find(String name) {
        return albumSongs.stream().
                filter(a -> a.getTitle().
                        equals(name)).findAny().
                orElse(null);
    }


    public void albumUpdate() {
        albumAuthors.removeAll(albumAuthors);
        albumSongs.stream().forEach(a -> albumAuthors.addAll(a.getAuthors()));

        albumGenre.removeAll(albumGenre);
        albumSongs.stream().forEach(a -> albumGenre.addAll(a.getGenre()));

        this.duration = 0;
        albumSongs.stream().forEach(a -> this.duration += a.getDuration());
    }

    public Album(String name, AlbumFormats albumFormat) {
        this.albumName = name;
        this.albumFormat = albumFormat;
    }

    public String toString() {
        List<String> listOfSongs = albumSongs.stream()
                .map(a->a.toString())
                .collect(Collectors.toList());
        return "\n"+albumName+ " " + albumGenre
                + " " +albumFormat
                + " " +albumAuthors
                +listOfSongs.stream().reduce("", (tmp, a) -> tmp + "\n" + a)
                +"\n";
    }
}
