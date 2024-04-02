package util;

import model.Product;

public class ProductParser {
    public static Product parseProductFromText(String text) {
        String[] parts = text.split(" at ");
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        boolean isImported = name.contains("imported");
        boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pill");

        return new Product(name, price, isImported, isExempt);
    }
}
