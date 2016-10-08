package EncodingChanger;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Echetik on 08.10.2016.
 */
public class EncodingChanger {
    static final String FILE_INPUT = "D:\\Downloads\\javaTraining\\module4_Homework\\test_utf8.txt";
    static final String FILE_OUTPUT = "D:\\Downloads\\javaTraining\\module4_Homework\\test_utf16.txt";

    public static void changeToUTF16Start() throws IOException {
        File file = new File(FILE_INPUT);
        byte[] result = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeUsingBufferedWriter(new String(result, StandardCharsets.UTF_8));
    }

    private static void writeUsingBufferedWriter(String data) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_OUTPUT), "UTF16"))) {
            bw.write(data);
            bw.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
