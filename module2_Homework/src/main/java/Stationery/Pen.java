package Stationery;

import java.util.Objects;

/**
 * Created by Echetik on 10.09.2016.
 */
public class Pen {
    private Colour color;
    private double price;
    private boolean isEmpty;
    Brand brand;

    public Pen(Colour color, double price, Brand brand) {
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color=" + color +
                ", price=" + price +
                ", isEmpty=" + isEmpty +
                ", brand=" + brand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Double.compare(pen.price, price) == 0 &&
                isEmpty == pen.isEmpty &&
                color == pen.color &&
                brand == pen.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, price, isEmpty, brand);
    }
}
