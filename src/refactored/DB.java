
public class DB {

    protected String databaseName;

    public DB(String databaseName) {
        this.databaseName = databaseName;
    }

    public void connect() {
        System.out.println("Connecting to " + databaseName);
    }

    public void query() {
        System.out.println("Querying " + databaseName);
    }

    public void disconnect() {
        System.out.println("Disconnecting from " + databaseName);
    }
}
