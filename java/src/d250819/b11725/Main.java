package d250819.b11725;

import java.io.*;
import java.util.*;

public class Main {

	static Map<String, Set<String>> map;
	static Map<String, String> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		map = new HashMap<>(n);
		for (int i = 1; i <= n; i++) map.put(String.valueOf(i), new HashSet<>());
		
		for (int i = 0; i < n - 1; i++) {
			String[] tmp = br.readLine().split(" ");
			
			map.get(tmp[0]).add(tmp[1]);
			map.get(tmp[1]).add(tmp[0]);
		}
		
		result = new HashMap<>(n);
		method("1");

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(result.get(String.valueOf(i)) + "\n");
		}

		System.out.println(sb);
	}

	static void method(String num) {
		for (String s : map.get(num)) {
			result.put(s, num);
			map.get(s).remove(num);
			method(s);
		}
	}
}
