package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {

    BigDecimal calculateDiscount(List<Item> items);
}
