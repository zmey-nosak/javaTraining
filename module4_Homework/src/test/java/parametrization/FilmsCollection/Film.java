package parametrization.FilmsCollection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Echetik on 08.10.2016.
 */
public class Film implements Serializable {
    HashSet<Actor> starts = new HashSet<>();

    public void addStar(Actor actor) {
        starts.add(actor);
    }

    public void removeStar(Actor actor) {
        starts.remove(actor);
    }

    public Film() {
    }

    public Film(Actor... actors) {
        starts.clear();
        starts.addAll(Arrays.asList(actors));
    }
}
