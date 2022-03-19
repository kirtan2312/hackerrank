package monthprepkit.week1;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SparseArrays {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<Integer> res = matchingStrings(strings, queries);

		bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}

	// find frequency of queries in given strings list.
	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		List<Integer> result = new ArrayList<>();
		for (String query : queries) {
			result.add(Collections.frequency(strings, query));
		}
		return result;
	}
}
