package FilmsCollection;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Echetik on 08.10.2016.
 */
public class Actor implements Serializable {
    String name;
    String sourName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) &&
                Objects.equals(sourName, actor.sourName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sourName);
    }

    public Actor(String name, String sourName) {
        this.name = name;
        this.sourName = sourName;
    }


}
