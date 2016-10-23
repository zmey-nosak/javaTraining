package waitnotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Echetik on 15.10.2016.
 */
public class SharedResource {
    private List<Integer> list;
    private Lock lock = new ReentrantLock();

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public Lock getLock() {
        return lock;
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

}
