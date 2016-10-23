package parametrization.FilmsCollection;

import java.io.Serializable;

/**
 * Created by Echetik on 08.10.2016.
 */
public class Actor implements Serializable {
    String name;
    String sourName;

    public Actor(String name, String sourName) {
        this.name = name;
        this.sourName = sourName;
    }
}
