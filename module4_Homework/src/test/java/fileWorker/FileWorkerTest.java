package fileWorker;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by Echetik on 01.10.2016.
 */
public class FileWorkerTest {
FileWorkerSymbStream fs=new FileWorkerSymbStream();
    @Test
    public void test() {
        try {
            fs.doWork("D:\\Downloads\\javaTraining\\module3_Homework\\src\\test\\java\\fileWorker\\FileWorkTest.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}