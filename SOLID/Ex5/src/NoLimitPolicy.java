public class NoLimitPolicy implements DeliveryPolicy {
    @Override
    public void validate(String title, String body) {
        // No restriction
    }
}