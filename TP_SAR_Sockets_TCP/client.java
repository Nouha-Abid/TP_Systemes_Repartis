import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
   
        String serverAddress = "localhost";
        int serverPort = 5612;
        System.out.print("Entrez votre âge : ");
        int age = Integer.parseInt(System.console().readLine());
        System.out.print("Entrez votre nom : ");
        String name = System.console().readLine();
        Socket socket = new Socket(serverAddress, serverPort);

        OutputStream out = socket.getOutputStream();
        out.write((age + "," + name).getBytes());

        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int bytesRead = in.read(data);
        int uniqueId = Integer.parseInt(new String(data, 0, bytesRead));

        System.out.println("Votre id est : " + uniqueId);

        socket.close();
    }
}
