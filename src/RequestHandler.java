import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler extends Thread {
	//final DataInputStream input; 
    //final DataOutputStream output;
	final ObjectInputStream input;
	final ObjectOutputStream output;
    final Socket s; 
    public Email email;
    public MailSender mailSender;
	
	public RequestHandler(Socket s, ObjectInputStream input, ObjectOutputStream output)
	{
		this.s = s;
		this.input = input;
		this.output = output;
	}
	/*public RequestHandler(Socket s2, DataInputStream input2, DataOutputStream output2)
	{
		System.out.println("New user connected\n");
		this.s = s2;
		this.input = input2;
		this.output = output2;
		
	}*/
	public void run()
	{
		String clienttoServer = "Waiting for email sending requests";
		String serverMsgPrefix = "**SERVER**: ";
		while(true)
		{
			try
			{
            	System.out.println("******************************************\n");
				//output.writeUTF(serverMsgPrefix + clienttoServer+"\n\n");
				//email = (Email) input.readObject();
				//clienttoServer = input.readUTF();
            	//output.writeObject(new String("Ready for new request"));
            	email = (Email) input.readObject();
				/*if(clienttoServer.length() != 0 && !clienttoServer.equals("exit"))
				{
					System.out.println("New Email request:\n" + "From client: " + s +  "\nEmail details:\n" + clienttoServer + "\n");
					output.writeUTF("Email request established. sending email");
				}*/
            	if(email != null && !email.src.equals("exit") && !email.src.equals("pass"))
            	{
            		System.out.println("Email request received, forwarding email to appropriate smtp server");
            		MailSender.send(email);
            	}
            	else if(email.src.equals("exit"))
				{
					System.out.println("Client " + this.s + " " + "Exit");
					this.s.close();
					break;
				}
				else if(email.src.equals("pass"))
				{
					System.out.println("Client input invalid\n");
				}
				//clienttoServer = "Waiting for email sending requests";
			}
			catch (IOException e)
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
