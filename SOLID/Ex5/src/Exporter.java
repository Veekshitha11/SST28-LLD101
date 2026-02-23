public abstract class Exporter {

    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest cannot be null");
        }

        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;

        ExportResult result = doExport(title, body);

        if (result == null || result.bytes == null) {
            throw new IllegalStateException("Exporter returned invalid result");
        }

        return result;
    }

    protected abstract ExportResult doExport(String title, String body);
}