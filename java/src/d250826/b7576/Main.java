package d250826.b7576;

import java.io.*;
import java.util.*;

/* 토마토
 * 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
 * M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
 * 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
 * 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
 * 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buff = br.readLine().split(" ");

		int n = Integer.parseInt(buff[0]);
		int m = Integer.parseInt(buff[1]);

		String[][] arr = new String[m][n];
		Queue<Pair> que = new ArrayDeque<>();	// 좌표를 저장할 큐
		for (int i = 0; i < m; i++) {
			arr[i] = br.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				if (Objects.equals(arr[i][j], "1")) {	// 1이 들어있는 좌표만 저장
					que.add(new Pair(j, i, 0));
				}
			}
		}

		int result = 0;	// 출력할 결과
		while (!que.isEmpty()) {
			Pair pair = que.poll();
			int x = pair.x;
			int y = pair.y;
			int step = pair.step;

			if (x + 1 < n) {	// 범위 내의 좌표면 1로 바꾸고 큐에 추가
				if (Objects.equals(arr[y][x + 1], "0")) {
					arr[y][x + 1] = "1";
					que.add(new Pair(x + 1, y, step + 1));
				}
			}
			if (y + 1 < m) {
				if (Objects.equals(arr[y + 1][x], "0")) {
					arr[y + 1][x] = "1";
					que.add(new Pair(x, y + 1, step + 1));
				}
			}
			if (x - 1 >= 0) {
				if (Objects.equals(arr[y][x - 1], "0")) {
					arr[y][x - 1] = "1";
					que.add(new Pair(x - 1, y, step + 1));
				}
			}
			if (y - 1 >= 0) {
				if (Objects.equals(arr[y - 1][x], "0")) {
					arr[y - 1][x] = "1";
					que.add(new Pair(x, y - 1, step + 1));
				}
			}

			result = step;	// 현재 단계를 저장
		}

		for (String[] a : arr) {
			for (String s : a) {
				if (Objects.equals(s, "0")) {	// 0이 남아있으면 -1을 출력
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(result);
	}
}

class Pair {	// 좌표를 저장할 클래스
	int x;
	int y;
	int step;

    public Pair(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
    }
}

