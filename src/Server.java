import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
	
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(25);
		while(true)
		{
			Socket s = null;
			try
			{
				s = serverSocket.accept();
				
				System.out.println("Client connected " + s);
				DataInputStream input = new DataInputStream(s.getInputStream());
				DataOutputStream output = new DataOutputStream(s.getOutputStream());
				//ObjectInputStream input = new ObjectInputStream(s.getInputStream());
				//ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
				
				Thread t = new RequestHandler(s,input,output);
				t.start();
			}
			catch(Exception e)
			{
				s.close();
				e.printStackTrace();
			}
		}
	}
}
