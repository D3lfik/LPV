import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    void registerClient(ClientInterface client) throws RemoteException;
    void unregisterClient(ClientInterface client) throws RemoteException;
    void computeFactorial(ClientInterface client, int number) throws RemoteException;
}
