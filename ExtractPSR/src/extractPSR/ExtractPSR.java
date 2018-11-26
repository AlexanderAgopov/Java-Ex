package extractPSR;

public class ExtractPSR {
	/*
	 * This class implements a method called "urlExtractor" which extracts in
	 * separate strings the names of the protocol, the server and the resource of a
	 * given URL and prints them in separate lines.
	 */

	public static void main(String[] args) {
		// Implementation example
		String urlEx = "https://www.github.com/AlexanderAgopov/Java-Ex";
		urlExtractor(urlEx);

	}

	public static void urlExtractor(String URL) {
		int protocolEnd = URL.indexOf("://");
		String protocol = URL.substring(0, protocolEnd);
		System.out.println("Protocol: " + protocol);
		String URLpart2 = URL.substring(protocolEnd + 3);// string which only contains the part of the URL
															// after the protocol and "://" expression ("://" is 3 chars
															// so 3 is added to the integer number representing the
															// index of the string "URL" on which the name of the
															// protocol ends).
		int serverEnd = URLpart2.indexOf("/");
		String server = URLpart2.substring(0, serverEnd);
		System.out.println("Server: " + server);
		String resource = URLpart2.substring(serverEnd, URLpart2.length());
		System.out.println("Resource: " + resource);

	}

}
