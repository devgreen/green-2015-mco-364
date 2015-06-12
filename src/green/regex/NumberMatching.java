package green.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberMatching {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}");
		String text = "This is my number, 1-123-456-7890. call me. otherwise call me on 1 718 222 2222";
		Matcher m = p.matcher(text);
		boolean b = m.matches();
		System.out.println(b);

		while (m.find()) {
			String number = text.substring(m.start(), m.end());
			System.out.println(number);
		}
	}

}
