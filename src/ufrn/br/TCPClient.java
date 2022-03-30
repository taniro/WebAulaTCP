package ufrn.br;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        String host = "tapioca.eaj.ufrn.br";
        int port = 80;

        Socket clientSocket = new Socket(host, port);
        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
        pw.println("GET / HTTP/1.1");
        pw.println("Host:tapioca.eaj.ufrn.br");
        pw.println("");
        pw.flush();

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        byte[] data;
        while (true){
            data = in.readNBytes(512);
            if (data.length < 1) {
                break;
            }
            System.out.println(new String(data, StandardCharsets.UTF_8));
        }
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String t;
        while ((t = br.readLine()) != null) {
            System.out.println(t);
        }
         */
        clientSocket.close();
    }
}
