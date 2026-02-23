import java.util.*;
public interface EligibilityRule {
    void evaluate(StudentProfile s, List<String> reasons);
}