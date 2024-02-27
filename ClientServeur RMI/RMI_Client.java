import java.rmi.*;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            // Recherche du serveur dans le registre RMI
            IService service = (IService) Naming.lookup("//localhost/Service");

            // Appel à la méthode distante
            String result = service.convertToUpper("hello");

            System.out.println("Résultat de la conversion : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
