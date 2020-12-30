
public abstract class Email implements Runnable {
	public String serverAddress;
	public String userName;
	public String password;
	public String emailPostfix;
	public String dest;
	public String src;
	public String body;
	public void run() {
		for(int i=0; i<2000; i++)
			System.out.printf("%d ", i);
	}
	public static String getVendorName(String srcEmail) {
		return srcEmail.substring(srcEmail.lastIndexOf('@')+1,srcEmail.indexOf('.'));
	}
}
