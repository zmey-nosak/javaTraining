package PropertyReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by Echetik on 15.10.2016.
 */
public class PropertyReader {
    private HashMap<String, Object> storage = new HashMap<>();
    private Properties props = new Properties();

    public boolean eatMe(String path) {
        try (FileInputStream in = new FileInputStream(new File(path))) {
            props.load(in);
            for (String key : props.stringPropertyNames()) {
                storage.put(key, props.getProperty(key));
            }
            return true;
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
           // e.printStackTrace();
            System.out.println("IOException");
        }
        return false;
    }

    public Object getValueByKey(String key) {
        try {
            isExistProperty(key);
            return storage.get(key);
        } catch (NoPropertyException ex) {
            System.out.println(ex.toString());
            throw new RuntimeException();
        }
    }

    private boolean isExistProperty(String key) throws NoPropertyException {
        if (!storage.containsKey(key)) {
            throw new NoPropertyException(key);
        }
        return true;
    }
}



