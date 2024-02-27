import java.rmi.*;
import java.rmi.registry.*;

public class ServeurRMI extends java.rmi.server.UnicastRemoteObject implements IService {

    public ServeurRMI() throws RemoteException {
        super();
    }

    public String convertToUpper(String input) throws RemoteException {
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        try {
            // Création d'une instance du serveur RMI
            ServeurRMI server = new ServeurRMI();

            // Création et démarrage du registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrement du serveur dans le registre RMI avec le nom "Service"
            registry.rebind("Service", server);

            System.out.println("Serveur RMI démarré.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
