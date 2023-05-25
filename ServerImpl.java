import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl extends UnicastRemoteObject implements RemoteInterface {
    private List<ClientInterface> clients;

    public ServerImpl() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public void registerClient(ClientInterface client) throws RemoteException {
        clients.add(client);
        System.out.println("Client registered.");
    }

    @Override
    public void unregisterClient(ClientInterface client) throws RemoteException {
        clients.remove(client);
        System.out.println("Client unregistered.");
    }

    @Override
    public void computeFactorial(ClientInterface client, int number) throws RemoteException {
        long result = factorial(number);
        client.receiveFactorial(number, result);
    }

    private long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
