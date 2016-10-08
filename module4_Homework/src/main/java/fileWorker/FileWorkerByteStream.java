package fileWorker;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Echetik on 01.10.2016.
 */
public class FileWorkerByteStream {
    private static Map<String, Integer> map = new HashMap<>();
    {
        map.put("package", 0);
        map.put("import", 0);
        map.put("public", 0);
        map.put("static", 0);
        map.put("class", 0);
        map.put("void", 0);
        map.put("try", 0);
        map.put("catch", 0);
        map.put("String", 0);
        map.put("false", 0);
        map.put("true", 0);
    }


    public void doWork(String fileName) throws FileNotFoundException {
        fillMap(map, exists(fileName));
        writeToFile(map);
    }

    protected void fillMap(Map<String, Integer> map, File file) {
        byte[] result = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(result);
            String str = new String(result);
            int counter;
            for (String key : map.keySet()) {
                counter = 0;
                Pattern p = Pattern.compile(key, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(str);
                while (m.find()) counter++;
                map.put(key, counter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeToFile(Map<String, Integer> map) {
        try (FileOutputStream out = new FileOutputStream("data.bin")) {
            for (Map.Entry entry : map.entrySet()) {
                out.write((entry.getKey().toString() + " ").getBytes());
                out.write(entry.getValue().toString().getBytes());
                out.write("\n" .getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected File exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        return file;
    }
}
