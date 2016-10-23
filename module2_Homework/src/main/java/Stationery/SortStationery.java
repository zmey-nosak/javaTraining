package Stationery;
import java.util.Comparator;

/**
 * Created by Echetik on 10.09.2016.
 */
public class SortStationery {
    public static Comparator<Stationery> SORT_BY_PRICE = new Comparator<Stationery>() {
        @Override
        public int compare(Stationery o1, Stationery o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    };
    public static Comparator<Stationery> SORT_BY_NAME = new Comparator<Stationery>() {
        @Override
        public int compare(Stationery o1, Stationery o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Stationery> SORT_BY_PRICE_NAME = new Comparator<Stationery>() {
        @Override
        public int compare(Stationery o1, Stationery o2) {
            int i = (int) (o1.getPrice() - o2.getPrice());
            if (i == 0) {
                i = o1.getName().compareTo(o2.getName());
            }
            return i;
        }
    };

}
