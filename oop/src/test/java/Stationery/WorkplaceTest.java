package Stationery;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Echetik on 12.09.2016.
 */
public class WorkplaceTest {

    Workplace workplace = new Workplace();

    @Test
    public void testAddStationery() throws Exception {
        Stationery stationery = new Notepad(30, 15.75, Brand.Parker);
        workplace.removeAll();
        workplace.addStationery(stationery);
        assertTrue(workplace.isExist(stationery));
    }

    @Test
    public void testRemoveStationary() throws Exception {
        Stationery stationery = new Notepad(30, 15.75, Brand.Parker);
        workplace.removeAll();
        workplace.addStationery(stationery);
        workplace.removeStationary(stationery);
        assertFalse(workplace.isExist(stationery));
    }


    @Test
    public void testCostOfWorkplace() throws Exception {
        workplace.removeAll();
        Stationery stationery = new Notepad(30, 15.75, Brand.Parker);
        workplace.addStationery(stationery);
        stationery = new Pencil(Colour.BLACK, false, 60, Brand.Parker);
        workplace.addStationery(stationery);
        assertThat(75.75, is(workplace.costOfWorkplace()));
    }

    @Test
    public void testSortByPrice() throws Exception {
        List<Stationery> lst = new LinkedList<>();
        Stationery stationery = new Notepad(30, 15.75, Brand.Parker);//1
        Stationery stationery2 = new Pencil(Colour.BLACK, false, 60, Brand.Parker);//2
        Stationery stationery3 = new Ruler(30,99.99, Brand.Carioka);//3
        lst.add(stationery);
        lst.add(stationery2);
        lst.add(stationery3);
        //Добавляем в обратном порядке на рабочее место
        workplace.addStationery(stationery3);
        workplace.addStationery(stationery2);
        workplace.addStationery(stationery);
        //сортируем по цене
        workplace.sortByPrice();
        for (int i = 0; i < 2; i++) {
            assertTrue(lst.get(i).equals(workplace.getByIndex(i)));
        }

    }

    @Test
    public void testSortByName() throws Exception {
        List<Stationery> lst = new LinkedList<>();

        Stationery stationery = new Notepad(30, 15.75, Brand.Parker);//1
        Stationery stationery2 = new Pencil(Colour.BLACK, false, 60, Brand.Parker);//2
        Stationery stationery3 = new Ruler(30,99.99, Brand.Carioka);//3

        lst.add(stationery);
        lst.add(stationery2);
        lst.add(stationery3);
        //Добавляем в обратном порядке
        workplace.addStationery(stationery3);
        workplace.addStationery(stationery2);
        workplace.addStationery(stationery);
        //сортируем по имени
        workplace.sortByName();
        for (int i = 0; i < 2; i++) {
            assertTrue(lst.get(i).equals(workplace.getByIndex(i)));
        }
    }

    @Test
    public void testSortByPriceName() throws Exception {
        List<Stationery> lst = new LinkedList<>();
        Stationery stationery = new Notepad(30, 99.99, Brand.Parker);//2
        Stationery stationery2 = new Pencil(Colour.BLACK, false, 11, Brand.Parker);//1
        Stationery stationery3 = new Ruler(30,99.99, Brand.Carioka);//3

        lst.add(stationery2);
        lst.add(stationery);
        lst.add(stationery3);
        //Добавляем в произвольном порядке
        workplace.addStationery(stationery3);
        workplace.addStationery(stationery2);
        workplace.addStationery(stationery);
        //сортируем по 2 полям price и name(совпадает с название класса)
        workplace.sortByPriceName();
        for (int i = 0; i < 2; i++) {
            assertTrue(lst.get(i).equals(workplace.getByIndex(i)));
        }
    }
}