package fileWorker;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Echetik on 02.10.2016.
 */
public class FileWorkerSymbStream extends FileWorkerByteStream {
    @Override
    protected void fillMap(Map<String, Integer> map, File file) {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            str = sb.toString();
            int counter;
            for (String key : map.keySet()) {
                counter = 0;
                Pattern p = Pattern.compile(key, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(str);
                while (m.find()) counter++;
                map.put(key, counter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void writeToFile(Map<String, Integer> map) {
        File file = new File("BufferedWriter.txt");
        try {
            try (FileWriter fr = new FileWriter(file);
                 BufferedWriter br = new BufferedWriter(fr)) {
                for (Map.Entry entry : map.entrySet()) {
                    br.write((entry.getKey().toString() + " "));
                    br.write(entry.getValue().toString());
                    br.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
