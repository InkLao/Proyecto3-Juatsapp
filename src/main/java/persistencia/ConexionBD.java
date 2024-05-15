package persistencia;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionBD {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "juatsapp";
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
                database = mongoClient.getDatabase(DATABASE_NAME);
            } catch (Exception e) {
                System.err.println("Error connecting to MongoDB: " + e.getMessage());
            }
        }
        return database;
    }

    public static void verificarConexionBD() {
        try {
            System.out.println("Verificando conexión a la base de datos...");
            MongoDatabase db = getDatabase();
            System.out.println("Colecciones disponibles en la base de datos '" + DATABASE_NAME + "':");
            for (String name : db.listCollectionNames()) {
                System.out.println(name);
            }
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.err.println("Error al verificar la conexión con la base de datos: " + e.getMessage());
        }
    }
}
