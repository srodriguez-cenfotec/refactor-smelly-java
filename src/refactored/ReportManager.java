
public class ReportManager {

    // Tópico 2: Números mágicos - constante para el mensaje de procesamiento
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

    // Tópico 15: Boy Scout Rule - validación para evitar estado inválido en la clase
    public void setData(String reportData) {
        if (reportData == null || reportData.isEmpty()) {
            throw new IllegalArgumentException("reportData cannot be null or empty");
        }
        this.reportData = reportData;
    }

    public void processReport() {
        // Tópico 14: KISS - flujo simple y directo, cada paso delega a un método con nombre claro
        logProcessing();
        emailSender.send(reportData);
        reportStorage.save(reportData);
    }

    private void logProcessing() {
        System.out.println(MSG_PROCESSING + reportData);
    }
}
