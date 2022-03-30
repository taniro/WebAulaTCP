package ufrn.br;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {

		ServerSocket socket = new ServerSocket(8080);

		while(true){
			Socket conexao = socket.accept();

			PrintWriter pw = new PrintWriter(conexao.getOutputStream());
			pw.println("HTTP/1.1 200 OK");
			pw.println("Content-Type: text/html; charset: utf-8");
			pw.println("");
			pw.println("<html><body><h1>World, hello</h1></body></html>");
			pw.flush();
		}
	}
}
