public class InvoiceFormatter {

    public String format(Invoice inv) {

        StringBuilder out = new StringBuilder();

        out.append("Invoice# ").append(inv.id).append("\n");

        for (String line : inv.lineDetails) {
            out.append(line).append("\n");
        }

        out.append(String.format("Subtotal: %.2f\n", inv.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", inv.taxPct, inv.tax));
        out.append(String.format("Discount: -%.2f\n", inv.discount));
        out.append(String.format("TOTAL: %.2f\n", inv.total));

        return out.toString();
    }
}