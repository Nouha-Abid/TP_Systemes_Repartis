import java.rmi.*;
import java.rmi.server.*;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    public CalculatorImpl() throws RemoteException {
        super();
    }

    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    public double subtract(double x, double y) throws RemoteException {
        return x - y;
    }

    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

    public double divide(double x, double y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Division by zero");
        }
        return x / y;
    }
}
