package Stationery;

public class Ruler extends Stationery {
    private int rulerLong;

    public Ruler(int rulerLong, double price, Brand brand) {
        this.name = "Ruler";
        this.brand = brand;
        this.price = price;
    }

    public int getRulerLong() {
        return rulerLong;
    }

    @Override
    public String toString() {
        return name + "{" +
                ", price=" + price +
                ", brand" + brand +
                ", rulerLong" + rulerLong +
                '}';
    }
}
