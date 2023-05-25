import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {
    private RemoteInterface server;

    public ClientImpl(RemoteInterface server) throws RemoteException {
        this.server = server;
        server.registerClient(this);
    }

    public void requestFactorial() throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to compute factorial: ");
        int number = scanner.nextInt();
        scanner.close();

        server.computeFactorial(this, number);
    }

    @Override
    public void receiveFactorial(int number, long result) throws RemoteException {
        System.out.println("Factorial of " + number + ": " + result);
    }
}
