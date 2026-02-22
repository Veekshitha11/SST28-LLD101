import java.util.*;

public class Invoice {

    public final String id;
    public final List<String> lineDetails;
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public Invoice(String id,
                   List<String> lineDetails,
                   double subtotal,
                   double taxPct,
                   double tax,
                   double discount,
                   double total) {

        this.id = id;
        this.lineDetails = lineDetails;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}