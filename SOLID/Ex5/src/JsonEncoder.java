import java.nio.charset.StandardCharsets;

public class JsonEncoder implements FormatEncoder {

    @Override
    public ExportResult encode(String title, String body) {

        String json =
                "{\"title\":\""
                + bodyEscape(title)
                + "\",\"body\":\""
                + bodyEscape(body)
                + "\"}";

        return new ExportResult(
                "application/json",
                json.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String bodyEscape(String s) {
        return s.replace("\"", "\\\"");
    }
}