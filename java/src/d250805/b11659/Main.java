package d250805.b11659;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] buff = br.readLine().split(" ");

		int n = Integer.parseInt(buff[0]);
		int m = Integer.parseInt(buff[1]);

		buff = br.readLine().split(" ");

		int[] arr = Arrays.stream(buff).mapToInt(Integer::parseInt).toArray();

		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int preStart = 0, preEnd = 0;
		for (int i = 0; i < m; i++) {
			buff = br.readLine().split(" ");
			int start = Integer.parseInt(buff[0]) - 1;
			int end = Integer.parseInt(buff[1]);

			if (i == 0) {
				for (int j = start; j < end; j++) {
					sum += arr[j];
				}
			} else {
				if (preStart < start) {
					for (int j = preStart; j < start; j++) {
						sum -= arr[j];
					}
				}
	
				if (preEnd > end) {
					for (int j = end; j < preEnd; j++) {
						sum -= arr[j];
					}
				}
	
				if (start < preStart) {
					for (int j = start; j < preStart; j++) {
						sum += arr[j];
					}
				}
	
				if (preEnd < end) {
					for (int j = preEnd; j < end; j++) {
						sum += arr[j];
					}
				}
			}

			preStart = start;
			preEnd = end;

			sb.append(sum).append('\n');
		}

		System.out.println(sb);
	}
}

