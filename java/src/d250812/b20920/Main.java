package d250812.b20920;

import java.io.*;
import java.util.*;

/* 영단어 암기는 괴로워
 * 첫째 줄에는 영어 지문에 나오는 단어의 개수 N과 외울 단어의 길이 기준이 되는 
 * M이 공백으로 구분되어 주어진다. (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 10)
 * 둘째 줄부터 N+1번째 줄까지 외울 단어를 입력받는다. 
 * 이때의 입력은 알파벳 소문자로만 주어지며 단어의 길이는 10을 넘지 않는다.
 * 단어장에 단어가 반드시 1개 이상 존재하는 입력만 주어진다.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String buff = br.readLine();
		int n = Integer.parseInt(buff.split(" ")[0]);
		int m = Integer.parseInt(buff.split(" ")[1]);

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			buff = br.readLine();
			if (buff.length() >= m) {
				map.put(buff, map.getOrDefault(buff, 0) + 1);
			}
		}

		List<String> lst = new ArrayList<>(map.keySet());
		lst.sort((x, y) -> {
			if (Objects.compare(map.get(x), map.get(y), Comparator.reverseOrder()) > 0) {
				return 1;
			} else if (Objects.compare(map.get(x), map.get(y), Comparator.reverseOrder()) < 0) {
				return -1;
			} else {
				if (Objects.compare(x.length(), y.length(), Comparator.reverseOrder()) > 0) {
					return 1;
				} else if (Objects.compare(x.length(), y.length(), Comparator.reverseOrder()) < 0) {
					return -1;
				} else {
					return Objects.compare(x, y, Comparator.naturalOrder());
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : lst) {
			sb.append(s + '\n');
		}

		System.out.println(sb);
	}
}

