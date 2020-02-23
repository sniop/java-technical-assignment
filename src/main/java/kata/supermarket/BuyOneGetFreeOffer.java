package kata.supermarket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.groupingBy;
import static kata.supermarket.ProductName.DIGESTIVES;
import static kata.supermarket.ProductName.MILK;

public class BuyOneGetFreeOffer implements Offer {

    private final List<ProductName> ELIGIBLE_PRODUCTS = Arrays.asList(MILK, DIGESTIVES);

    @Override
    public BigDecimal amountToDiscount(List<Item> items) {

        Map<ProductName, List<ItemByUnit>> itemsMap
                = items.stream()
                .filter(i -> i instanceof ItemByUnit)
                .map(i -> (ItemByUnit) i)
                .filter(i->ELIGIBLE_PRODUCTS.contains(i.name()))
                .collect(groupingBy(ItemByUnit::name));

        BigDecimal totalDiscount = new BigDecimal(0);

        for (Entry<ProductName, List<ItemByUnit>> entry : itemsMap.entrySet()) {

            if(entry.getValue().size()<2){
                continue;
            }

            int noOfDiscountedItems = entry.getValue().size() / 2;
            BigDecimal itemPrice = entry.getValue().get(0).price();
            totalDiscount = totalDiscount.add(itemPrice.multiply(BigDecimal.valueOf(noOfDiscountedItems)));

        }

        return totalDiscount;
    }
}
