import model.Receipt;
import model.Product;
import util.ProductParser;

public class Main {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();

        String[] inputs = {"" +
                "1 book at 12.49",
                "1 movie at 14.99",
                "1 chocolate bar at 0.85"
        };

        for (String input : inputs) {
            Product product = ProductParser.parseProductFromText(input);
            receipt.addProduct(product);
        }

        receipt.printReceipt();
    }
}
