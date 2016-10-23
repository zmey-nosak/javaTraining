package FilmsCollection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by Echetik on 08.10.2016.
 */
public class Film implements Serializable {
    HashSet<Actor> starts = new HashSet<>();
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return Objects.equals(starts, film.starts) &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(starts, name);
    }

    public void addStar(Actor actor) {
        starts.add(actor);
    }

    public void removeStar(Actor actor) {
        starts.remove(actor);
    }

    public Film() {
    }

    public Film(String name, Actor... actors) {
        this.name = name;
        starts.clear();
        starts.addAll(Arrays.asList(actors));
    }
    public HashSet<Actor> getActors(){
        return starts;
    }
}
