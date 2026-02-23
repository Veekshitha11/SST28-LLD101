import java.util.*;

public class AddOnPricing implements PricingComponent {

    private final Map<AddOn, Money> addOnRates;

    public AddOnPricing() {
        addOnRates = new HashMap<>();
        addOnRates.put(AddOn.MESS, new Money(1000.0));
        addOnRates.put(AddOn.LAUNDRY, new Money(500.0));
        addOnRates.put(AddOn.GYM, new Money(300.0));
    }

    @Override
    public Money monthlyCharge(BookingRequest req) {
        Money total = new Money(0.0);
        for (AddOn a : req.addOns) {
            total = total.plus(addOnRates.getOrDefault(a, new Money(0.0)));
        }
        return total;
    }
}