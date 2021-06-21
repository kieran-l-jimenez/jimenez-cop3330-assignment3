package ex44;

public class product {
    String name;
    double price;
    int quantity;

    String outputInfo()
    {
        return String.format("Name: %s\nPrice: $%.2f\nQuantity on hand: %d\n", name, price, quantity);
    }
}
