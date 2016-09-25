package nuclearBoat;

import java.lang.annotation.*;

/**
 * Created by Echetik on 25.09.2016.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NuclearBoatAnnotation {
    String name();
    int year();
}
