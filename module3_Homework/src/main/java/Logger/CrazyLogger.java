package Logger;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Echetik on 17.09.2016.
 */
public class CrazyLogger {
    public static final String DATE_PATTERN = "dd-MM-YYYY : hh-mm";

    private StringBuilder log = new StringBuilder("");

    static LocalDateTime dateTime;

    public void add(String message) {
        log.append(getStringDateTime(dateTime.now()) + " - " + message + ";");
    }

    public void clear() {
        log = new StringBuilder("");
    }

    private String getStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return localDateTime.format(formatter);
    }

    public List<String> findByDate(LocalDateTime begin, LocalDateTime end) {
        List<String> returnMessages = new ArrayList<>();
        String stringLog = log.toString();

        String[] messages = stringLog.split(";");

        int firstMessage = -1;
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].startsWith(getStringDateTime(begin))) {
                firstMessage = i;
                break;
            }
        }

        if (firstMessage == -1) return returnMessages;

        for (int i = firstMessage; i < messages.length; i++) {
            if (!messages[i].startsWith(getStringDateTime(end))) {
                returnMessages.add(messages[i]);
            } else {
                break;
            }
        }
        return returnMessages;
    }

    public List<String> findByPartOfMessage(String partOfMessage) {

        List<String> messages = new ArrayList<>();

        String stringLog = log.toString();

        Pattern pattern = Pattern.compile("[^;]*" +  partOfMessage + "[^;]*");
        Matcher matcher = pattern.matcher(stringLog);

        while (matcher.find()) {
            messages.add(stringLog.substring(matcher.start(), matcher.end()));
        }

        return messages;
    }


}
