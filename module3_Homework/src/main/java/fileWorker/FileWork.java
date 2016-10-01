package fileWorker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Echetik on 25.09.2016.
 */
public class FileWork {
    private final static String TAG = "<!{0,1}[^>]+/{0,1}>{1}";
    private final static String DOT = "(?<![Рр]ис)\\. ";
    private final static String LINQ_IMG = "\\([Рр]ис\\. ";
    private final static String DIGIT = "((?<=\\([рР]ис\\. )\\d+)";

    public static boolean isOrdered(String fileName) throws FileNotFoundException {
        StringBuffer sb = new StringBuffer();
        List<String> res = new ArrayList<>();
        LinkedList<Integer> resNum = new LinkedList<>();
        StringBuffer sb2 = new StringBuffer();
        if (exists(fileName)) {
            try {
                Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach((str) -> sb.append(str));
                String str = Pattern.compile(TAG).matcher(sb.toString())
                        .replaceAll("&nbsp;");
                str = Pattern.compile("&nbsp;|&nbsp").matcher(str).replaceAll("");
                str = Pattern.compile("(?<=[а-я])\\.(?=[А-Я])").matcher(str).replaceAll(". ");
                Pattern pattern = Pattern.compile(DIGIT);
                Arrays.asList(str.split(DOT))
                        .stream().filter(s -> {
                    return Pattern.compile(LINQ_IMG).matcher(s).find();
                }).forEach(s1 -> {
                    res.add(s1);
                    Matcher matcher = pattern.matcher(s1);
                    matcher.find();
                    Integer tmpInt = Integer.valueOf(matcher.group(1));
                    if (resNum.isEmpty()) {
                        resNum.add(tmpInt);
                    } else {
                        if (resNum.getLast() <= tmpInt) {
                            resNum.add(tmpInt);
                        }
                    }
                    System.out.println(s1);
                });
                if (resNum.size() == res.size()) {
                    return true;
                }
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static boolean exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        return true;
    }
}
