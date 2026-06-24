
public class DB {

    // Tópico 3: Strings mágicos - constantes para mensajes literales repetidos
    private static final String MSG_CONNECTING = "Connecting to ";
    private static final String MSG_QUERYING = "Querying ";
    private static final String MSG_DISCONNECTING = "Disconnecting from ";

    protected String databaseName;

    public DB(String databaseName) {
        this.databaseName = databaseName;
    }

    public void connect() {
        System.out.println(MSG_CONNECTING + databaseName);
    }

    public void query() {
        System.out.println(MSG_QUERYING + databaseName);
    }

    public void disconnect() {
        System.out.println(MSG_DISCONNECTING + databaseName);
    }
}
