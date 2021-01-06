import java.io.Serializable;
import java.util.regex.Pattern;

public abstract class Email implements Serializable {
	public String serverAddress;
	private String userName;
	private String password;
	public String emailPostfix;
	public String dest;
	public String src;
	public String body;
	public String port;
	public Server server;
	

	public static String getVendorName(String srcEmail) {
		try {
			return srcEmail.substring(srcEmail.lastIndexOf('@')+1,srcEmail.indexOf('.'));
		}
		catch(StringIndexOutOfBoundsException e)
		{
			return "Invalid vendor name";
		}
		
	}
	public static boolean emailValidation(String to, String from, String body)
	{
		String emailRegEx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		Pattern pat = Pattern.compile(emailRegEx);
		if(!pat.matcher(to).matches())
			return false;
		else if(!pat.matcher(from).matches())
			return false;
		else if(body.length() == 0)
			return false;
		
		return true;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
