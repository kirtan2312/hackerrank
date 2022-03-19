package monthprepkit.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Pangrams {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = bufferedReader.readLine();
		System.out.println(pangrams(s));

		bufferedReader.close();
	}

	// return panagram if string contains all alphabet characters.
	public static String pangrams(String s) {
		char[] characters = s.replaceAll(" ", "").toCharArray();
		Set<Character> set = new HashSet<>();
		for (char c : characters) {
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
				set.add(Character.toLowerCase(c));
			}
		}
		return set.size() == 26 ? "pangram" : "not pangram";
	}
}