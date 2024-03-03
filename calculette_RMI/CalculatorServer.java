import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", calculator);
            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.err.println("Calculator Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
