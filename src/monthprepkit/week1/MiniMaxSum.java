package monthprepkit.week1;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MiniMaxSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		miniMaxSum(arr);

		bufferedReader.close();
	}

	// min and max sum of four elements in list
	private static void miniMaxSum(List<Integer> arr) {
		Collections.sort(arr);
		long totalSum = 0;
		totalSum = arr.stream().mapToLong(e -> e).sum();
		System.out.println(totalSum - arr.get(arr.size() - 1) + " " + (totalSum - arr.get(0)));
	}
}
