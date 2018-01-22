package oop.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	private Socket clientSocket;
	
	public Client(String ip,int port)
	{
		try {
			this.clientSocket = new Socket(ip, port);
			
		} catch (IOException e) {
			new Error("Na dann� ip addrese a portu neb�� ��dn� server ! ");
		}
	}
	public void sendDataToServer()
	{
		try {
			
			while(getDataFromServer() == 21);
			
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
			
			String temp = "toto je \r\n";
			out.write(temp);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getDataFromServer()
	{
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			return Integer.parseInt(in.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
		
	}

}
