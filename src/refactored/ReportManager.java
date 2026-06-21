
public class ReportManager {
    private String data;

    public void setData(String d) {
        this.data = d;
    }

    public void processReport() {
        System.out.println("Processing report: " + data);
        sendEmailReport();
        saveReportToDisk();
    }


    private void sendEmailReport() {
        System.out.println("Sending email report: " + data);
    }

    private void saveReportToDisk() {
        System.out.println("Saving report to disk: " + data);
    }
}
