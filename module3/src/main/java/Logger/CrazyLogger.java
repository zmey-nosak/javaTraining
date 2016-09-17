package Logger;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Formatter;

/**
 * Created by Echetik on 17.09.2016.
 */
public class CrazyLogger {
    private StringBuilder builder = new StringBuilder();

    public void SetMessages(String str) {
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance();
        formatter.format("%td", calendar);
        formatter.format("-%tm", calendar);
        formatter.format("-%ty : ", calendar);
        formatter.format("%tH", calendar);
        formatter.format("-%tM", calendar);
       // builder.append(formatter.toString());
       //formatter.format("%td-%tm-%ty : %tH-%tM", calendar);
        builder.append(formatter.toString()).append(" - ").append(str);
    }
}
