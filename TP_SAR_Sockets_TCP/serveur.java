import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class serveur{

    public static void main(String[] args) throws IOException {

        int serverPort = 5612;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        Map<Integer, person> people = new HashMap<>();

        while (true) {
          
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            byte[] data = new byte[1024];
            int bytesRead = in.read(data);
            String[] personData = new String(data, 0, bytesRead).split(",");
            int age = Integer.parseInt(personData[0]);
            String name = personData[1];

            int uniqueId = people.size() + 1;
            people.put(uniqueId, new person(age, name));
            OutputStream out = socket.getOutputStream();
            out.write(String.valueOf(uniqueId).getBytes());

            socket.close();
        }
    }
}

