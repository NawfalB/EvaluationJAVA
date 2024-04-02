import org.junit.Test;
import static org.junit.Assert.*;
import model.Product;
import util.ProductParser;

public class ProductParserTest {
    @Test
    public void testParseProductFromText() {
        String input = "1 imported box of chocolates at 5.00";
        Product product = ProductParser.parseProductFromText(input);
        assertEquals("1 imported box of chocolates", product.getName());
        assertEquals(5.00, product.getPrice(), 0.001);
        assertTrue(product.isImported());
        assertTrue(product.isExempt());
    }
}
