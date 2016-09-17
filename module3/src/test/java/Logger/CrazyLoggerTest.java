package Logger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 17.09.2016.
 */
public class CrazyLoggerTest {

    CrazyLogger logger = new CrazyLogger();

    @Test
    public void testSetMessages() throws Exception {
        logger.SetMessages("eeee");

    }
}