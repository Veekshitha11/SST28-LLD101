import java.util.*;



public class OnboardingService {
    private final StudentRepository repo;
    private final StudentInputParser parser;
    private final StudentValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentRepository repo) { 
        this.repo = repo;
        this.parser = new StudentInputParser();
        this.validator = new StudentValidator();
        this.printer = new OnboardingPrinter();
     }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);


        //parse raw input 
        Map<String,String> kv = parser.parse(raw);
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");



        // validation inline, printing inline
        List<String> errors = validator.validate(name,email,phone,program);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }
        

        //generate id for student
        String id = IdUtil.nextStudentId(repo.count());

        //create a student record 
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repo.save(rec);
        

        //print success
        printer.printSuccess(rec, repo.count());
    }
}
