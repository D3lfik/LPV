import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Server", server);
            System.out.println("Server started.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
