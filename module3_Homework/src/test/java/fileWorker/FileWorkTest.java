package fileWorker;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Echetik on 25.09.2016.
 */
public class FileWorkTest {
    @Test
    public void isMakeStringFromFile() {
        String str;
        try {
          assertThat(false,is( FileWork.isOrdered("D:\\Downloads\\javaTraining\\module3_Homework\\src\\main\\java\\resources\\TestFile6.html")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}