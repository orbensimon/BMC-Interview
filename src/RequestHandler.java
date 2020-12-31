import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler extends Thread {
	final DataInputStream input; 
    final DataOutputStream output; 
    final Socket s; 
    Email email;
	
	/*public RequestHandler(Socket s, ObjectInputStream input, ObjectOutputStream output)
	{
		this.s = s;
		this.input = input;
		this.output = output;
	}*/
	public RequestHandler(Socket s2, DataInputStream input2, DataOutputStream output2)
	{
		this.s = s2;
		this.input = input2;
		this.output = output2;
		
	}
	public void run()
	{
		String clienttoServer;
		while(true)
		{
			try
			{
				System.out.println("IN REQHANDLER RUN METHOD");
				output.writeUTF("Email received at server and sent to destenation ");
				//email = (Email) input.readObject();
				clienttoServer = input.readUTF();
				System.out.println("Msg from client: " + clienttoServer);
				if(clienttoServer.equals("exit"))
				{
					System.out.println("Client" + this.s + "exit");
					this.s.close();
					break;
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			this.input.close();
			this.output.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}