package d250812.b26069;

import java.io.*;
import java.util.*;

/* 붙임성 좋은 총총이
* 첫번째 줄에는 사람들이 만난 기록의 수 (1 ≤ N ≤ 100,000)이 주어진다.
* 두번째 줄부터 N개의 줄에 걸쳐 사람들이 만난 기록이 주어진다. 
* i + 1번째 줄에는 i번째로 만난 사람들의 이름 
* A_i와 B_i가 공백을 사이에 두고 주어진다. 
* A_i와 B_i는 숫자와 영문 대소문자로 이루어진 최대 길이 
* 20의 문자열이며, 서로 같지 않다.
* 총총이의 이름은 ChongChong으로 주어지며, 기록에서 1회 이상 주어진다.
* 동명이인은 없으며, 사람의 이름은 대소문자를 구분한다. 
* (ChongChong과 chongchong은 다른 이름이다.)
*/
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			if ("ChongChong".equals(tmp[0])) {
				set.add(tmp[0]);
			} else if ("ChongChong".equals(tmp[1])) {
				set.add(tmp[1]);
			}

			if (set.contains(tmp[0])) {
				set.add(tmp[1]);
			} else if (set.contains(tmp[1])) {
				set.add(tmp[0]);
			}
		}

		System.out.println(set.size());
	}
}

