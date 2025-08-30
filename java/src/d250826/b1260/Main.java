package d250826.b1260;

import java.io.*;
import java.util.*;


public class Main {
	
	static HashMap<Integer, Set<Integer>> map;	// 입력을 저장할 Map
	static StringBuilder dfsStr;
	static StringBuilder bfsStr;
	static Queue<Integer> que;	// BFS 순서를 저장할 Queue

	/* DFS와 BFS
	 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000),
	 * 탐색을 시작할 정점의 번호 V가 주어진다.
	 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
	 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
	 * 입력으로 주어지는 간선은 양방향이다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] buff = br.readLine().split(" ");
		int n = Integer.parseInt(buff[0]);
		int m = Integer.parseInt(buff[1]);
		int v = Integer.parseInt(buff[2]);

		map = new HashMap<Integer, Set<Integer>>(n);
		for (int i = 1; i <= n; i++)
			// 반복문에서 꺼낼 때 정렬이 되어있음, Comparator로 정렬 방법을 정할 수 있음
			map.put(i, new TreeSet<>(Comparator.naturalOrder()));

		for (int i = 0; i < m; i++) {
			buff = br.readLine().split(" ");

			// 숫자로 정렬해야되기 때문에 Integer로 넣어야 됨
			map.get(Integer.valueOf(buff[0])).add(Integer.valueOf(buff[1]));
			map.get(Integer.valueOf(buff[1])).add(Integer.valueOf(buff[0]));
		}

		// DFS
		dfsStr = new StringBuilder();
		dfsStr.append(v);
		dfs(v);
		System.out.println(dfsStr);

		// BFS
		bfsStr = new StringBuilder();
		bfsStr.append(v);
		que = new ArrayDeque<Integer>();	// BFS로 순회하기 위한 Queue
		map.get(v).add(-2);	// 첫 번째는 방문을 표시하고 메서드를 실행함
		bfs(v);
		System.out.println(bfsStr);
	}

	static void dfs(int curr) {
		map.get(curr).add(-1);	// set에 -1이 들어있으면 DFS에서 이미 방문한 객체
		for (int s : map.get(curr)) {	// TreeSet이기 때문에 정렬 순서대로 나옴
			if (s != -1 && !map.get(s).contains(-1)) {
				dfsStr.append(" " + s);
				dfs(s);
			}
		}
	}

	static void bfs(int curr) {
		for (int s : map.get(curr)) {
			if (s != -1 && s != -2 && !map.get(s).contains(-2)) {
				bfsStr.append(" " + s);
				map.get(s).add(-2);	// set에 -2가 들어있으면 BFS에서 이미 방문한 객체
				que.offer(s);
			}
		}

		if (!que.isEmpty()) {
			bfs(que.poll());
		}
	}
}

