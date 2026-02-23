public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        // Ignores subject; base type doesn't clarify expectations (smell)
        //  if (n.phone == null) {
        //     throw new IllegalArgumentException("phone required");
        // }
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
