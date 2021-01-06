
public class GmailVendor extends Email {

	public GmailVendor() {
		System.out.println("Gmail vendor");
	}	
	public GmailVendor(String dest, String src, String body)
	{

		this.dest = dest;
		this.src = src;
		this.body = body;
		port = "465";
		serverAddress = "smtp.gmail.com";
		setUserName("admin");
		setPassword("admin");
		emailPostfix = "@gmail.com";
	}
}
