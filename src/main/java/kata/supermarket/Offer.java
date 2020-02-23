package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public interface Offer {

    BigDecimal amountToDiscount(List<Item> items);
}
