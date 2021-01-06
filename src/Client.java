import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
	public static void main(String args[])
	{
		try 
		{
			String to;
			String from;
			String body;
			String vendor;
			Email email;
			EmailFactory emailFactory = new EmailFactory();
			Scanner in = new Scanner(System.in);
			InetAddress ip = InetAddress.getByName("localhost");
			Socket s = new Socket(ip,25); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            //DataInputStream input = new DataInputStream(s.getInputStream()); 
  
            // sends output to the socket 
            //DataOutputStream output = new DataOutputStream(s.getOutputStream());
            ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s.getInputStream());
           
            
            while(true)
            {
            	System.out.println("******************************************\n");
            	//System.out.println(input.readObject().toString() + "\n\n");
            	System.out.println("////***   TO EXIT, SET 'FROM:' LABEL TO '@EXIT..'    ***///\n\n");
            	System.out.println("To:<customer email>");
    			to = in.nextLine();
    			System.out.println("From:<your name>@<vendor email postfix>");
    			from = in.nextLine();
    			System.out.println("Body:<any information you like>");
    			body = in.nextLine();
    			vendor = Email.getVendorName(from);
    			email = emailFactory.getEmail(vendor, to, from ,body);

    			if(Email.emailValidation(to, from, body) || vendor.toLowerCase().equals("exit") )
    			{
    				
        			if(vendor.toLowerCase().equals("exit"))
        			{
        				email.src = vendor;
        				System.out.println("Closing connection:" + s);
        				//output.writeUTF("exit");
        				output.writeObject(email);
        				s.close();
        				break;
        			}
        			//email = emailFactory.getEmail(vendor, to, from ,body);
        			//output.writeUTF("User name:\n" + email.userName + "\nTo:\n" + to +"\nFrom:\n" + from +"\nBody:\n" + body + "\nServer address:\n" + email.serverAddress);
        			output.writeObject(email);
    			}
    			else
    			{
    				email.src = "pass";
    				System.out.println("Email construction failed\n" + "Email properties not valid. please check email fields.\n");
    				//output.writeUTF("");
    				output.writeObject(email);
    			}
    			
            }
            input.close();
            output.close();
            in.close();
		}
		catch(UnknownHostException u) 
        { 
            u.printStackTrace();
        } 
        catch(IOException i) 
        { 
            i.printStackTrace(); 
        } 
		
	}

}
