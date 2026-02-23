import java.util.*;

public class RoomPricing implements PricingComponent {

    private final Map<Integer, Money> roomRates;

    public RoomPricing() {
        roomRates = new HashMap<>();
        roomRates.put(LegacyRoomTypes.SINGLE, new Money(14000.0));
        roomRates.put(LegacyRoomTypes.DOUBLE, new Money(15000.0));
        roomRates.put(LegacyRoomTypes.TRIPLE, new Money(12000.0));
        roomRates.put(LegacyRoomTypes.DELUXE, new Money(16000.0));
    }

    @Override
    public Money monthlyCharge(BookingRequest req) {
        return roomRates.getOrDefault(req.roomType, new Money(0.0));
    }
}