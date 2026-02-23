import java.util.*;
public class CgrRule implements EligibilityRule {

    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }

    @Override
    public void evaluate(StudentProfile s, List<String> reasons) {
        if (s.cgr < minCgr) {
            reasons.add("CGR below " + minCgr);
        }
    }
}