
public class WallaVendor extends Email {

	public WallaVendor() {
		
	}
	public WallaVendor(String dest, String src, String body)
	{
		this.dest = dest;
		this.src = src;
		this.body = body;
		port = "587";
		serverAddress = "out.walla.co.il";
		setUserName("admin");
		setPassword("admin");
		emailPostfix = "@walla.co.il";
	}

}
