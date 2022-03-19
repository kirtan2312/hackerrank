package monthprepkit.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	// convert time from 12hour format to military(24 hour) format
	public static String timeConversion(String s) {
		String ampm = s.substring(s.length() - 2);
		String hour = s.substring(0, s.indexOf(":"));
		String afterHourString = s.substring(s.indexOf(":"), s.length() - 2);
		int intHour = Integer.parseInt(hour);
		if (ampm.equals("PM")) {
			if (intHour == 12) {
				return "12" + afterHourString;
			}
			return String.valueOf(12 + Integer.parseInt(hour)) + afterHourString;
		}
		if (intHour == 12) {
			return "00" + afterHourString;
		}
		return hour + afterHourString;
	}
}
