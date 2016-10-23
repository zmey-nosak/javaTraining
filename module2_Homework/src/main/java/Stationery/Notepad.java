package Stationery;

import java.util.Objects;

/**
 * Created by Echetik on 10.09.2016.
 */
public class Notepad extends Stationery {
    protected int pageCount;

    public Notepad(int pageCount, double price, Brand brand) {
        this.name = "Notepad";
        this.pageCount = pageCount;
        this.price = price;
        this.brand = brand;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return name + "{" +
                "pageCount=" + pageCount +
                ", price=" + price +
                ", brand=" + brand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notepad notepad = (Notepad) o;
        return pageCount == notepad.pageCount && price==notepad.price && brand==notepad.brand && name.equals(notepad.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageCount);
    }
}
