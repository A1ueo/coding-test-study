package d250826.b2606;

import java.io.*;
import java.util.*;

/* 바이러스
 * 첫째 줄에는 컴퓨터의 수가 주어진다.
 * 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로
 * 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는
 * 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서
 * 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
 */
public class Main {

	static Map<String, Set<String>> map;
	static Set<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 나와 연결된 객체들을 담을 map
		map = new HashMap<String, Set<String>>();
		for (int i = 1; i <= n; i++)
			map.put(String.valueOf(i), new HashSet<>());

		for (int i = 0; i < m; i++) {
			String[] tmp = br.readLine().split(" ");

			// 모두 연결해놓은 후, 순회해야되기 때문에
			// 먼저 서로의 set에 넣어놓음
			map.get(tmp[0]).add(tmp[1]);
			map.get(tmp[1]).add(tmp[0]);
		}

		// 감염된 객체들을 담을 set
		set = new HashSet<String>();
		set.add("1");
		method("1");

		// 1번은 제외하고 크기를 출력
		System.out.println(set.size() - 1);
	}

	static void method(String curr) {
		for (String s : map.get(curr)) {
			set.add(s);
			for (String c : set) {
				// 트리와는 다르게 루프가 발생하기 때문에
				// set에 있는 모든 값을 지워주어야됨
				map.get(s).remove(c);
			}
			// 본인과 연결된 다른 객체들에게 메서드를 실행시킴
			method(s);
		}
	}
}
