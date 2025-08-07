package d250805.b2559;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] buff = br.readLine().split(" ");
		int n = Integer.parseInt(buff[0]);
		int k = Integer.parseInt(buff[1]);

		int sum = 0;
		int max;
		int num;

		buff = br.readLine().split(" ");

		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			num = Integer.parseInt(buff[i]);
			sum += num;
			que.offer(num);
		}

		max = sum;

		for (int i = k; i < n; i++) {
			sum -= que.poll();
			num = Integer.parseInt(buff[i]);
			sum += num;
			que.offer(num);
			if (max < sum) max = sum;
		}

		System.out.println(max);
	}
}

