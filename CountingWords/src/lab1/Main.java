package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Set<String> characters = new HashSet<>();
		List<String> characters2 = new ArrayList<>();
		Map<String, Integer> countedText = new TreeMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("text_to_count.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("counts.csv"));)

		{
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] words = line.replaceAll("[^a-zA-Z ]", "").split(" ");
				for (String word : words) {
					if (!(word.equals(""))) {
						characters.add(word.toLowerCase());
						characters2.add(word.toLowerCase());
					}
				}
			}

			for (String chr : characters) {
				int count = 0;
				for (String chr2 : characters2) {
					if (chr.equals(chr2)) {
						count++;
					}
				}
				countedText.put(chr, count);
				System.out.println(chr + "," + count);
			}

			for (String key : countedText.keySet()) {
				writer.write(key + "," + countedText.get(key) + "\n");
			}
			writer.flush();
			System.out.println("Writing process has finished!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
