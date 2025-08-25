package d250819.b11725;

import java.io.*;
import java.util.*;

/* 트리의 부모 찾기
 * 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 */
public class Main {

	static Map<String, Set<String>> map;
	static Map<String, String> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		map = new HashMap<String, Set<String>>(n);
		for (int i = 1; i <= n; i++) map.put(String.valueOf(i), new HashSet<>());
		// 누가 부모인지 모르기 때문에, 서로의 set에 넣음
		for (int i = 0; i < n - 1; i++) {
			String[] tmp = br.readLine().split(" ");
			
			map.get(tmp[0]).add(tmp[1]);
			map.get(tmp[1]).add(tmp[0]);
		}
		
		result = new HashMap<String, String>(n);
		// 부모 번호를 result에 넣고 set에서 지움
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
