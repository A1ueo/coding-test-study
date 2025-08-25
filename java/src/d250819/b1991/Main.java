package d250819.b1991;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<String> pre = new LinkedList<>();
		List<String> in = new LinkedList<>();
		List<String> post = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");

			if (i == 0) {
				pre.add(tmp[0]);
				in.add(tmp[0]);
				post.add(tmp[0]);
			}

			// 전위
			int pointer;
			if ((pointer = pre.indexOf(tmp[0])) != -1) {
				if (!".".equals(tmp[1])) pre.add(pointer + 1, tmp[1]);
				if (!".".equals(tmp[2])) {
					if (!".".equals(tmp[1])){
						pre.add(pointer + 2, tmp[2]);
					} else {
						pre.add(pointer + 1, tmp[2]);
					}
				}
			}

			// 중위
			if ((pointer = in.indexOf(tmp[0])) != -1) {
				if (!".".equals(tmp[1])) {
					in.add(pointer, tmp[1]);
					pointer++;
				}
				if (!".".equals(tmp[2])) {
					in.add(pointer + 1, tmp[2]);
				}
			}

			// 후위
			if ((pointer = post.indexOf(tmp[0])) != -1) {
				if (!".".equals(tmp[1])) {
					post.add(pointer, tmp[1]);
					pointer++;
				}
				if (!".".equals(tmp[2])) {
					post.add(pointer, tmp[2]);
					pointer++;
				}
			}
		}

		StringBuilder preSb = new StringBuilder();
		StringBuilder inSb = new StringBuilder();
		StringBuilder postSb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			preSb.append(pre.get(i));
			inSb.append(in.get(i));
			postSb.append(post.get(i));
		}

		System.out.println(preSb);
		System.out.println(inSb);
		System.out.println(postSb);
	}
}

