package PropertyReader;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Echetik on 15.10.2016.
 */
public class PropertyReaderTest {

    PropertyReader propertyReader = new PropertyReader();

    @Test
    public void doesItEat() {
        assertThat(true, is(propertyReader.eatMe("D:\\Downloads\\javaTraining\\module5_Homework\\myPropety.property")));
        Object obj = propertyReader.getValueByKey("SOME_INT_VALUE");
        assertThat(true, is(obj != null));
        System.out.println(obj);
        obj = propertyReader.getValueByKey("SOME_DOUBLE_VALUE");
        assertThat(true, is(obj != null));
        System.out.println(obj);
    }
}