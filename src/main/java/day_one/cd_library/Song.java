package day_one.cd_library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class Song implements Comparable<Song>{
    private List<Musician> authors;
    private List<Genre> genre;
    private String title;
    private int duration;

    public String toString(){
        authors = authors.stream().sorted().collect(Collectors.toList());
        genre = genre.stream().sorted().collect(Collectors.toList());
        return authors+" \""+title+"\" "+(double) duration/60+" min "+genre;
    }

    public int compareTo(Song song){
        return this.title.compareTo(song.title);
    }


}
