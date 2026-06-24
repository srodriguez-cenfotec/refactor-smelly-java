// Tópico 12: Bajo acoplamiento - Tópico 17: Falta de interfaces o clases base
// Interfaz que define el contrato de una base de datos, desacoplando la implementación
public interface DatabaseService {
    void connect();
    void query();
    void disconnect();
}
