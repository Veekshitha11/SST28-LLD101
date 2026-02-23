import java.nio.charset.StandardCharsets;

public interface FormatEncoder {
    ExportResult encode(String title, String body);
}