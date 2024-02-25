import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            // Create a Scanner object to read input from the user
            Scanner scanner = new Scanner(System.in);
            
            // Ask for the IP address of the server
            System.out.print("Enter the IP address of the server: ");
            String serverIP = scanner.nextLine();
            
            // Ask for the port of the server
            System.out.print("Enter the port of the server: ");
            int serverPort = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            // Create a car object
            Voiture voiture = new Voiture("Essence", "Toyota");
            
            // Create a client socket
            DatagramSocket clientSocket = new DatagramSocket();
            
            // Get the InetAddress object of the server
            InetAddress serverAddress = InetAddress.getByName(serverIP);
            
            // Convert the car object to a byte array
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(voiture);
            byte[] data = outputStream.toByteArray();
            
            // Send the data to the server
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            clientSocket.send(packet);
            
            System.out.println("Car object sent to the server.");
            
            // Close the client socket
            clientSocket.close();
            
            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
