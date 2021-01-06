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
	
	public void run()
	{
		String clienttoServer = "Waiting for email sending requests";
		String serverMsgPrefix = "**SERVER**: ";
		while(true)
		{
			try
			{
            	System.out.println("******************************************\n");
            	email = (Email) input.readObject();
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

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) 
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
