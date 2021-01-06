
public class WallaVendor extends Email {

	public WallaVendor() {
		
	}
	public WallaVendor(String dest, String src, String body)
	{
		//System.out.println("Walla vendor");
		this.dest = dest;
		this.src = src;
		this.body = body;
		port = "587";
		serverAddress = "out.walla.co.il";
		userName = "admin";
		password = "admin";
		emailPostfix = "@walla.co.il";
	}

}
