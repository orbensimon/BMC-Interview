
public class YahooVendor extends Email {

	public YahooVendor() {
		
	}
	public YahooVendor(String dest, String src, String body)
	{
		this.dest = dest;
		this.src = src;
		this.body = body;
		port = "465";
		serverAddress = "smtp.mail.yahoo.com";
		setUserName("admin");
		setPassword("admin");
		emailPostfix = "@yahoo.com";
	}


}
