
public class ReportManager {
    private Object data;

    public void setData(Object d) {
        this.data = d;
    }

    public void processReport() {
        System.out.println("Processing report: " + data.toString());
        System.out.println("Sending email report: " + data.toString());
        System.out.println("Saving report to disk: " + data.toString());
    }
}
