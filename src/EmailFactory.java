
public class EmailFactory {
	
	public Email getEmail(String vendorIdentify, String dest, String src, String body)
	{
		if(vendorIdentify.toLowerCase().equals("gmail"))
			return new GmailVendor(dest,src,body);
		else if(vendorIdentify.toLowerCase().equals("yahoo"))
			return new YahooVendor(dest,src,body);
		else if(vendorIdentify.toLowerCase().equals("walla"))
			return new WallaVendor(dest,src,body);
		else
			return new GmailVendor("",vendorIdentify,"");
	}
}
