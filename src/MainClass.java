import java.util.Scanner;
import java.util.concurrent.*;
public class MainClass {
	public static String to;
	public static String from;
	public static String body;
	public static boolean exitFlag = false;
	public static String vendor;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		EmailFactory emailFactory = new EmailFactory();
		ExecutorService threadPoolEmailSending = Executors.newFixedThreadPool(3);
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
			threadPoolEmailSending.execute(email);
		}
		threadPoolEmailSending.shutdown();
		
	}

}
