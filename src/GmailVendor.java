
public class GmailVendor extends Email {

	public GmailVendor() {
		System.out.println("Gmail vendor");
	}	
	public GmailVendor(String dest, String src, String body)
	{
		System.out.println("Gmail vendor");
		this.dest = dest;
		this.src = src;
		this.body = body;
		serverAddress = "smtp.gmail.com";
		userName = "admin";
		password = "admin";
		emailPostfix = "@gmail.com";
	}
}
