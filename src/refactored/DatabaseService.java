// Tópico 12: Bajo acoplamiento - Tópico 17: Falta de interfaces o clases base
public interface DatabaseService {
    void connect();
    void query();
    void disconnect();
    void reconnect();
}
