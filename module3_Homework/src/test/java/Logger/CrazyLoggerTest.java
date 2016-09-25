package Logger;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 17.09.2016.
 */
public class CrazyLoggerTest {

    @Test
    public void findByDate() throws Exception {
        CrazyLogger logger = new CrazyLogger();

        logger.add("message 01");
        logger.add("message 02");
        logger.add("message 03");
        Thread.sleep(60000);

        LocalDateTime dateTimeBegin = LocalDateTime.now();
        logger.add("message 04");
        logger.add("message 05");
        logger.add("message 06");
        Thread.sleep(60000);

        LocalDateTime dateTimeEnd = LocalDateTime.now();
        logger.add("message 07");
        logger.add("message 08");
        logger.add("message 09");
        Thread.sleep(60000);

        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add("message 04");
        expectedMessages.add("message 05");
        expectedMessages.add("message 06");

        List<String> messages = logger.findByDate(dateTimeBegin, dateTimeEnd);

        Assert.assertEquals(expectedMessages.size(), messages.size());

        for (int i = 0; i < messages.size(); i++) {
            Assert.assertEquals(expectedMessages.get(i), messages.get(i).substring(21));
        }
    }

    @Test
    public void findByPartOfMessage() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        logger.add("message 01");
        logger.add("message 02");
        logger.add("message 03");
        logger.add("message 04");
        logger.add("Long message 05");
        logger.add("Long message 06");
        logger.add("Long message 07");
        logger.add("Long message 08");

        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add("Long message 05");
        expectedMessages.add("Long message 06");
        expectedMessages.add("Long message 07");
        expectedMessages.add("Long message 08");

        List<String> messages = logger.findByPartOfMessage("Long");

        Assert.assertEquals(expectedMessages.size(), messages.size());

        for (int i = 0; i < messages.size(); i++) {
            Assert.assertEquals(expectedMessages.get(i), messages.get(i).substring(21));
        }

    }
}