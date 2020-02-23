package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static kata.supermarket.ProductName.MILK;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product(MILK,price).oneOf().price());
    }
}