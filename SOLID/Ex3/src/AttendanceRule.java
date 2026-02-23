import java.util.*;
public class AttendanceRule implements EligibilityRule {

    private final int minAttendance;

    public AttendanceRule(int minAttendance) {
        this.minAttendance = minAttendance;
    }

    @Override
    public void evaluate(StudentProfile s, List<String> reasons) {
        if (s.attendancePct < minAttendance) {
            reasons.add("attendance below " + minAttendance);
        }
    }
}