import java.util.regex.Pattern;

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
		String ret;
		try {
			return srcEmail.substring(srcEmail.lastIndexOf('@')+1,srcEmail.indexOf('.'));
		}
		catch(StringIndexOutOfBoundsException e)
		{
			
			return "";
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
}
