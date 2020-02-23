package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static kata.supermarket.ProductName.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOneGetFreeOfferTest {


    @DisplayName("check whether offer applies when contains")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void checkWhetherOfferApplies(String description, String expectedDiscount, List<Item> items) {
        final BuyOneGetFreeOffer offer = new BuyOneGetFreeOffer();
        assertEquals(new BigDecimal(expectedDiscount), offer.amountToDiscount(items));
    }

    static Stream<Arguments> checkWhetherOfferApplies() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleEligibleItemsPair(),
                aSingleItemPricedByWeight(),
                multipleNonEligibleItemsPricedByWeight()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "0", asList(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleNonEligibleItemsPricedByWeight() {
        return Arguments.of("multiple non eligible items", "0",
                asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleEligibleItemsPair() {
        return Arguments.of("multiple eligible items pairs", "2.04",
                Stream.of(addDigestives(2), addMilk(3))
                        .flatMap(Collection::stream)
                        .collect(toList()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0", asList(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(MILK, new BigDecimal("0.49")).oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product(DIGESTIVES, new BigDecimal("1.55")).oneOf();
    }

    private static List<Item> addDigestives(int numOfDigestives) {
        final List<Item> digestives = new ArrayList<>();
        IntStream.range(0, numOfDigestives).forEach(i -> digestives.add(aPackOfDigestives()));
        return digestives;
    }

    private static List<Item> addMilk(int pintsOfMilk) {
        final List<Item> milkPints = new ArrayList<>();
        IntStream.range(0, pintsOfMilk).forEach(i -> milkPints.add(aPintOfMilk()));
        return milkPints;
    }


    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(AMERICAN_SWEETS, new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(PICK_N_MIX, new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }


}
