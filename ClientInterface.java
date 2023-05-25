import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    void receiveFactorial(int number, long result) throws RemoteException;
}
