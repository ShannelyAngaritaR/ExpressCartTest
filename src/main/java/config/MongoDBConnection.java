package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Método para obtener la instancia de la base de datos
    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }

    // Método para iniciar la conexión
    private static void connect() {
        mongoClient = MongoClients.create("mongodb://127.0.0.1:27017/expresscart");
        database = mongoClient.getDatabase("expresscart"); // Nombre de la base de datos
    }

    // Método para cerrar la conexión
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
