package fileWorker;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 02.10.2016.
 */
public class FileWorkerSymbStreamTest {
    FileWorkerByteStream fb = new FileWorkerByteStream();

    @Test
    public void test() {
        try {
            fb.doWork("D:\\Downloads\\javaTraining\\module3_Homework\\src\\test\\java\\fileWorker\\FileWorkTest.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}