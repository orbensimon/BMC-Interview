
public class YahooVendor extends Email {

	public YahooVendor() {
		
	}
	public YahooVendor(String dest, String src, String body)
	{
		//System.out.println("Yahoo vendor");
		this.dest = dest;
		this.src = src;
		this.body = body;
		port = "465";
		serverAddress = "smtp.mail.yahoo.com";
		userName = "admin";
		password = "admin";
		emailPostfix = "@yahoo.com";
	}


}
