package oop.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverScoket;
	private Socket clientScoket;
	
	public Server(int port)
	{
		try {
			this.serverScoket = new ServerSocket(port);
			
			System.out.println("Èekám na pøipojení klienta . . .");
			clientScoket = this.serverScoket.accept();
			System.out.println("Klient se pøipojil(" + clientScoket.getInetAddress().getHostAddress() + ")");
			
		} catch (IOException e) {
			new Error("Port je již používá jinný program ! ");
		}
	}
	
	public int getDataFromClient()
	{
		
		try {
			brodcast(21); //2 = request, 1 = data from client
			int tmp = 0;
			while (tmp == 0){
				BufferedReader in = new BufferedReader(new InputStreamReader(clientScoket.getInputStream()));
				tmp = Integer.parseInt(in.readLine());
			}
			
			if(tmp != 0)
			{
				return tmp;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public void brodcast(int what)
	{
		try {
			
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter((clientScoket.getOutputStream())));
			out.write(what + "\r\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
