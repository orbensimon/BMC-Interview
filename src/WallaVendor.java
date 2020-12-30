
public class WallaVendor extends Email {

	public WallaVendor() {
		
	}
	public WallaVendor(String dest, String src, String body)
	{
		System.out.println("Walla vendor");
		this.dest = dest;
		this.src = src;
		this.body = body;
		serverAddress = "smtp.walla.co.il";
		userName = "admin";
		password = "admin";
		emailPostfix = "@walla.co.il";
	}

}
