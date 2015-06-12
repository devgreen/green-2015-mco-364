package green.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatching {
	
	private final static Pattern EMAILPATTERN = Pattern.compile("\\S+?@\\S+?\\.\\S+");

	public static void main (String [] args){
		
		//Pattern p = Pattern.compile("\\p{Alnum}*@\\p{Alnum}*\\.[a-zA-Z]*");
		//Pattern p2 = Pattern.compile(".+@.+\\..+");
		//Pattern p3 = Pattern.compile("\\S+?@\\S+?\\.\\S+");// add in ? to make sure when hit an @symbol it counts as the @ and not as a character
		String text = "this is my email. dgreen2197@gmail.com email me";
		String email = "dgreen2197@gmail.com";
		Matcher m = EMAILPATTERN.matcher(text);
		boolean b = m.matches();
		System.out.println (b);
		
		while (m.find()) {
			String number = text.substring(m.start(), m.end());
			System.out.println(number);
		}
		
		
		
	}
}
