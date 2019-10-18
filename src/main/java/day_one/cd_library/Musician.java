package day_one.cd_library;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Musician implements Comparable<Musician> {
    String band;
    String name;
    String lastName;

    public String toString() {
        return band
                + " " + name
                + " " + lastName;
    }

    public int compareTo(Musician musician) {
        if (!this.band.equals(musician.band)) {
            return this.band.compareTo(musician.band);
        } else if (!this.lastName.equals(musician.lastName)) {
            return this.lastName.compareTo(musician.lastName);
        } else {
            return this.name.compareTo(musician.name);
        }

    }

}
