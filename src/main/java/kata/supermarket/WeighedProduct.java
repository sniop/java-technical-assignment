package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {
    private final ProductName productName;
    private final BigDecimal pricePerKilo;

    public WeighedProduct(ProductName productName, final BigDecimal pricePerKilo) {
        this.productName = productName;
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    public ProductName getProductName() {
        return productName;
    }
}
