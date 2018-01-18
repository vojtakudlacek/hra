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
			new Error("Na danné ip addrese a portu nebìží žádný server ! ");
		}
		
		
	}
	public void sendDataToServer(int what)
	{
		try {
			
			while(getDataFromServer() == 21)
			{
				System.out.println("AAA");
			}
			
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
			
			String temp = String.valueOf(what);
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
