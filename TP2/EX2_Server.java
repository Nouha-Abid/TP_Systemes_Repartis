import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            // Create a Scanner object to read input from the user
            Scanner scanner = new Scanner(System.in);
            
            // Ask for the port to bind the server socket to
            System.out.print("Enter the port to bind the server socket to: ");
            int serverPort = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            // Create a server socket
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            
            // Buffer for receiving data
            byte[] receiveData = new byte[1024];
            
            // Receive packet from the client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            
            // Convert received data into car object
            ByteArrayInputStream inputStream = new ByteArrayInputStream(receiveData);
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            Voiture voiture = (Voiture) objectInput.readObject();
            
            // Process received data
            System.out.println("Car object received from the client:");
            System.out.println("Type: " + voiture.getType());
            System.out.println("Model: " + voiture.getModel());
            
            // Close the server socket
            serverSocket.close();
            
            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
