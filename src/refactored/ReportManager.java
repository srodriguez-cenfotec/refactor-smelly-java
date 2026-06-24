
public class ReportManager {
    private String reportData;
    private final ReportEmailSender emailSender;
    private final ReportStorage reportStorage;

    public ReportManager() {
        this(new ConsoleReportEmailSender(), new DiskReportStorage());
    }

    public ReportManager(ReportEmailSender emailSender, ReportStorage reportStorage) {
        this.emailSender = emailSender;
        this.reportStorage = reportStorage;
    }

    public void setData(String reportData) {
        this.reportData = reportData;
    }

    public void processReport() {
        System.out.println("Processing report: " + reportData);
        emailSender.send(reportData);
        reportStorage.save(reportData);
    }
}
