
public class GmailVendor extends Email {

	public GmailVendor() {
		System.out.println("Gmail vendor");
	}	
	public GmailVendor(String dest, String src, String body)
	{
		//System.out.println("Gmail vendor");
		this.dest = dest;
		this.src = src;
		this.body = body;
		port = "465";
		serverAddress = "smtp.gmail.com";
		userName = "or21290@gmail.com";
		password = "or305605743";
		emailPostfix = "@gmail.com";
	}
}
