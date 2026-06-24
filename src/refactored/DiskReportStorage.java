public class DiskReportStorage implements ReportStorage {
    @Override
    public void save(String reportData) {
        System.out.println("Saving report to disk: " + reportData);
    }
}
