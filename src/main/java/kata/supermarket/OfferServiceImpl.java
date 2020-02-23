package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OfferServiceImpl implements OfferService {

    private List<Offer> offers;

    public OfferServiceImpl(){
        offers = new ArrayList<>();
        offers.add(new BuyOneGetFreeOffer());
        offers.add(new OneKgOfVegetableAtHalfPrice());
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        for(Offer offer:offers){
            BigDecimal discount = offer.amountToDiscount(items);
            if(discount!=null && discount.compareTo(BigDecimal.ZERO)>0){
                return discount;
            }
        }
        return BigDecimal.ZERO;
    }
}
