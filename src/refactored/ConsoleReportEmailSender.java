public class ConsoleReportEmailSender implements ReportEmailSender {
    @Override
    public void send(String reportData) {
        System.out.println("Sending email report: " + reportData);
    }
}
