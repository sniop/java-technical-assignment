package kata.supermarket;

import java.math.BigDecimal;

public class Product {
    private final ProductName productName;
    private final BigDecimal pricePerUnit;

    public Product(final ProductName productName,final BigDecimal pricePerUnit) {
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public ProductName getProductName() {
        return productName;
    }
}
