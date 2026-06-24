
public class ReportManager {

    // Tópico 2: Números mágicos
    private static final String MSG_PROCESSING = "Processing report: ";

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

    // Tópico 15: Boy Scout Rule
    public void setData(String reportData) {
        if (reportData == null || reportData.isEmpty()) {
            throw new IllegalArgumentException("reportData cannot be null or empty");
        }
        this.reportData = reportData;
    }

    public void processReport() {
        // Tópico 14: KISS
        logProcessing();
        emailSender.send(reportData);
        reportStorage.save(reportData);
    }

    private void logProcessing() {
        System.out.println(MSG_PROCESSING + reportData);
    }
}
