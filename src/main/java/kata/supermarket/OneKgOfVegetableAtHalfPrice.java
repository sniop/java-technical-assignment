package kata.supermarket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static kata.supermarket.ProductName.AMERICAN_SWEETS;
import static kata.supermarket.ProductName.PICK_N_MIX;

public class OneKgOfVegetableAtHalfPrice implements Offer {
    private final List<ProductName> ELIGIBLE_PRODUCTS = Arrays.asList(PICK_N_MIX, AMERICAN_SWEETS);

    @Override
    public BigDecimal amountToDiscount(List<Item> items) {
        return BigDecimal.ZERO;//TODO implement this
    }
}
