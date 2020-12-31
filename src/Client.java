import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.*;
public class Client {
	public static void main(String args[])
	{
		try 
		{
			String to;
			String from;
			String body;
			boolean exitFlag = false;
			String vendor;
			EmailFactory emailFactory = new EmailFactory();
			Scanner in = new Scanner(System.in);
			InetAddress ip = InetAddress.getByName("localhost");
			Socket s = new Socket(ip,25); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            DataInputStream input = new DataInputStream(s.getInputStream()); 
  
            // sends output to the socket 
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            
            while(true)
            {
            	//System.out.println("IN CLIENT WHILE LOOP");
            	System.out.println(input.readUTF() + "\n\n");
            	System.out.println("////***   TO EXIT, SET 'FROM:' LABEL TO '@EXIT..'    ***///\n\n");
            	System.out.println("To:<customer email>");
    			to = in.nextLine();
    			System.out.println("From:<your name>@<vendor email postfix>");
    			from = in.nextLine();
    			System.out.println("Body:<any information you like>");
    			body = in.nextLine();
    			vendor = Email.getVendorName(from);
    			if(Email.emailValidation(to, from, body) || vendor.toLowerCase().equals("exit") )
    			{
    				
        			if(vendor.toLowerCase().equals("exit"))
        			{
        				System.out.println("Closing connection:" + s);
        				output.writeUTF("exit");
        				s.close();
        				break;
        			}
        			Email email = emailFactory.getEmail(vendor, to, from ,body);
        			output.writeUTF("User name:\n" + email.userName + "\nTo:\n" + to +"\nFrom:\n" + from +"\nBody:\n" + body + "\nServer address:\n" + email.serverAddress);
    			}
    			else
    			{
    				System.out.println("Email construction failed\n" + "Email proporties not valid. please check email fields.\n");
    				output.writeUTF("");
    			}
    			
               // String serverMsg = input.readUTF();
                //System.out.println(serverMsg);
            }
            input.close();
            output.close();
            in.close();
		}
		catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
		/*ExecutorService threadPoolEmailSending = Executors.newFixedThreadPool(3);
		while(!exitFlag)
		{
			System.out.println("To:<customer email>");
			to = in.nextLine();
			System.out.println("From:<your name>@<vendor email postfix>");
			from = in.nextLine();
			System.out.println("Body:<any information you like>");
			body = in.nextLine();
			vendor = Email.getVendorName(from);
			Email email = emailFactory.getEmail(vendor, to, from ,body);
			// check mail validation
			try {
			out.writeUTF(vendor);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			threadPoolEmailSending.execute(email);
		}
		threadPoolEmailSending.shutdown();*/
		
	}

}
