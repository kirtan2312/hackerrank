package monthprepkit.week1;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'plusMinus' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void plusMinus(List<Integer> arr) {
		int totalElements = arr.size();
		int zeros = 0;
		int positives = 0;
		int negatives = 0;
		for (Integer ele : arr) {
			if (ele != 0) {
				ele = ele > 0 ? positives++ : negatives++;
			} else {
				zeros++;
			}
		}
		System.out.format("%.6f\n", Double.valueOf(positives) / Double.valueOf(totalElements));
		System.out.format("%.6f\n", Double.valueOf(negatives) / Double.valueOf(totalElements));
		System.out.format("%.6f", Double.valueOf(zeros) / Double.valueOf(totalElements));
	}

}

public class PlusMinus {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.plusMinus(arr);

		bufferedReader.close();
	}
}
