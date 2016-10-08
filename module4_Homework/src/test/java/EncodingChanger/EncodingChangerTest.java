package EncodingChanger;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Echetik on 08.10.2016.
 */
public class EncodingChangerTest {
    EncodingChanger enCh = new EncodingChanger();

    @Test
    public void test() {
        try {
            enCh.changeToUTF16Start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}