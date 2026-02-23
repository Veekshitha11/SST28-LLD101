public class PdfSizeLimitPolicy implements DeliveryPolicy {

    @Override
    public void validate(String title, String body) {
        if (body.length() > 20) {
            throw new IllegalArgumentException(
                "PDF cannot handle content > 20 chars"
            );
        }
    }
}