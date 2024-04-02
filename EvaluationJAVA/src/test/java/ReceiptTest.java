import model.Product;
import model.Receipt;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReceiptTest {
    private Receipt receipt;

    @Before
    public void setUp() {
        receipt = new Receipt();
    }

    @Test
    public void testReceiptWithExemptProduct() {
        Product book = new Product("book", 12.49, false, true);
        receipt.addProduct(book);

        assertEquals("La taxe pour un produit exempt doit être nulle", 0.0, receipt.getTotalSalesTax(), 0.001);
        assertEquals("Le total et le prix d'un produit exempt doivent être égaux", 12.49, receipt.getTotalAmount(), 0.001);
    }

    @Test
    public void testReceiptWithImportedProduct() {
        Product importedChocolate = new Product("imported chocolate", 10.00, true, true);
        receipt.addProduct(importedChocolate);

        double expectedTax = 10.00 * 0.05;
        assertEquals("La taxe est de 5% pour les produits importés exempts", expectedTax, receipt.getTotalSalesTax(), 0.001);
        assertEquals("Le total doit inclure la taxe pour un produit importé exempt", 10.00 + expectedTax, receipt.getTotalAmount(), 0.001);
    }

    @Test
    public void testReceiptWithMultipleProducts() {
        Product book = new Product("book", 12.49, false, true);
        Product musicCD = new Product("music CD", 14.99, false, false);
        Product chocolate = new Product("chocolate", 0.85, false, true);

        receipt.addProduct(book);
        receipt.addProduct(musicCD);
        receipt.addProduct(chocolate);

        double expectedTax = 14.99 * 0.10;
        double expectedTotal = 12.49 + (14.99 + expectedTax) + 0.85;

        assertEquals("Le total doit être égal au résultat attendu", expectedTax, receipt.getTotalSalesTax(), 0.01);
        assertEquals("Le total doit inclure la taxe", expectedTotal, receipt.getTotalAmount(), 0.01);
    }
}
