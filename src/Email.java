

public abstract class Email {
	public String serverAddress;
	public String userName;
	public String password;
	public String emailPostfix;
	public String dest;
	public String src;
	public String body;
	public Server server;

	public static String getVendorName(String srcEmail) {
		return srcEmail.substring(srcEmail.lastIndexOf('@')+1,srcEmail.indexOf('.'));
	}
}
