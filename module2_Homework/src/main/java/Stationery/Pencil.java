package Stationery;
public class Pencil extends Stationery {
    protected Colour colour;
    protected boolean isEmpty;

    public Pencil(Colour colour, boolean isEmpty, double price, Brand brand) {
        this.name = "Pencil";
        this.brand = brand;
        this.price = price;
        this.colour = colour;
        this.isEmpty = isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Colour getColour() {
        return colour;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        return name + "{" +
                "colour=" + colour +
                ", isEmpty=" + isEmpty +
                ", price=" + price +
                ", brand" + brand +
                '}';
    }
}
