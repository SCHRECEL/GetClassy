import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductJTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("000001", "Laptop", "High-performance laptop", 1500.0);
    }

    @Test
    public void testToCSVDataRecord() {
        assertEquals("000001,Laptop,High-performance laptop,1500.0", product.toCSVDataRecord());
    }

    @Test
    public void testSetters() {
        product.setName("Desktop");
        product.setDescription("High-performance desktop");
        product.setCost(1200.0);

        assertEquals("Desktop", product.getName());
        assertEquals("High-performance desktop", product.getDescription());
        assertEquals(1200.0, product.getCost());
    }
}
