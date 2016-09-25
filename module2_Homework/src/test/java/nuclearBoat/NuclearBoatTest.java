package nuclearBoat;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 25.09.2016.
 */
public class NuclearBoatTest {
    @Test
    public void ShouldRunBoat() {
        NuclearBoat boat = new NuclearBoat();
        Assert.assertEquals(false, boat.isSailing());
        boat.startSailing();
        Assert.assertEquals(true, boat.isSailing());
    }
}