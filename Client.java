import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            RemoteInterface server = (RemoteInterface) Naming.lookup("rmi://localhost/Server");
            ClientImpl client = new ClientImpl(server);

            client.requestFactorial();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

