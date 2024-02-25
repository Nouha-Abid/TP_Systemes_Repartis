import java.net.*;
import java.util.Date;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            // Création d'un socket serveur UDP écoutant sur le port 1250
            DatagramSocket serverSocket = new DatagramSocket(1250);

            System.out.println("Serveur UDP démarré sur le port 1250...");

            while (true) {
                // Tampon pour stocker les données reçues
                byte[] receiveData = new byte[1024];

                // Réception du datagramme du client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Récupération de l'adresse IP et du port du client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Récupération de la date et de l'heure courante
                String date = new Date().toString();

                // Conversion de la date en tableau de bytes
                byte[] sendData = date.getBytes();

                // Création du datagramme à envoyer au client
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                // Envoi du datagramme au client
                serverSocket.send(sendPacket);

                System.out.println("Date et heure envoyées au client.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
