package Stationery;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Echetik on 10.09.2016.
 */
public class Workplace {
    static int countPlace;
    private List<Stationery> statList = new LinkedList<>();
    private int place;

    public void addStationery(Stationery stationery) {
        statList.add(stationery);
    }

    public void removeStationary(Stationery stationery) {
        statList.remove(stationery);
    }

    public void removeAll() {
        statList.clear();
    }

    public boolean isExist(Stationery stationery) {
        return statList.contains(stationery);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Workplace №" + place + ": " + ")");
        for (Stationery st : statList) {
            builder.append(st.toString());
        }
        return builder.toString();
    }

    public double costOfWorkplace() {
        double cost = 0;
        for (Stationery st : statList) {
            cost += st.getPrice();
        }
        return cost;
    }

    public Stationery getByIndex(int index) {
        return statList.get(index);
    }

    public void sortByPrice() {
        statList.sort(SortStationery.SORT_BY_PRICE);
    }
    public void sortByName() {
        statList.sort(SortStationery.SORT_BY_NAME);
    }
    public void sortByPriceName() {
        statList.sort(SortStationery.SORT_BY_PRICE_NAME);
    }
}
