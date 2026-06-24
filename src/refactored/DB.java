
public class DB implements DatabaseService {

    // Tópico 3: Strings mágicos
    private static final String MSG_CONNECTING = "Connecting to ";
    private static final String MSG_QUERYING = "Querying ";
    private static final String MSG_DISCONNECTING = "Disconnecting from ";

    // Tópico 4: Constantes faltantes
    private final String databaseName;

    public DB(String databaseName) {
        // Tópico 15: Boy Scout Rule
        if (databaseName == null || databaseName.isEmpty()) {
            throw new IllegalArgumentException("databaseName cannot be null or empty");
        }
        this.databaseName = databaseName;
    }

    public void connect() {
        log(MSG_CONNECTING + databaseName);
    }

    public void query() {
        log(MSG_QUERYING + databaseName);
    }

    public void disconnect() {
        log(MSG_DISCONNECTING + databaseName);
    }

    // Tópico 13: Alta cohesión faltante 
    public void reconnect() {
        disconnect();
        connect();
    }

    // Tópico 11: Modularidad violada
    private void log(String message) {
        System.out.println(message);
    }
}
