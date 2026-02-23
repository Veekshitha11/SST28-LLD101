import java.nio.charset.StandardCharsets;

public class CsvEncoder implements FormatEncoder {

    @Override
    public ExportResult encode(String title, String body) {

        String csv =
                "title,body\n"
                + escape(title) + ","
                + escape(body) + "\n";

        return new ExportResult(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String escape(String value) {
        if (value.contains(",") || value.contains("\n") || value.contains("\"")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        return value;
    }
}