package day_one.cd_library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class Song {
    private Set<Musician> authors;
    private Set<Genre> genre;
    private String title;
    private int duration;

    public String toString(){
        return authors+" \""+title+" "+(double) duration/60+" min "+genre;
    }


}
