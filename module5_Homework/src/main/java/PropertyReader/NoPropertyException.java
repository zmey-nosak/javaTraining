package PropertyReader;

/**
 * Created by Echetik on 15.10.2016.
 */
public class NoPropertyException extends Exception {
    private String property;

    public NoPropertyException(String property) {
        this.property = property;
    }

    public String toString() {
        return "Property " + property + " does not exist";

    }
}
