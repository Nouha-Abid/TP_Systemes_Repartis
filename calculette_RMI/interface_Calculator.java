import java.rmi.*;

public interface Calculator extends Remote {
    public double add(double x, double y) throws RemoteException;
    public double subtract(double x, double y) throws RemoteException;
    public double multiply(double x, double y) throws RemoteException;
    public double divide(double x, double y) throws RemoteException;
}
