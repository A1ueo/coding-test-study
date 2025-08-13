package s4.b25192;

import java.io.*;
import java.util.*;

/* 인사성 밝은 곰곰이
* 첫 번째 줄에는 채팅방의 기록 수를 나타내는 정수 
* N 이 주어진다. (1 ≤ N ≤ 100,000)
* 두 번째 줄부터 N 개의 줄에 걸쳐 새로운 사람의 입장을 나타내는 ENTER, 
* 혹은 채팅을 입력한 유저의 닉네임이 문자열로 주어진다. (1 ≤ 문자열 길이 ≤ 20)
* 첫 번째 주어지는 문자열은 무조건 ENTER이다.
*/
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Set<String> set = null;
		int count = 0;
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();

			if("ENTER".equals(tmp)) {
				set = new HashSet<>();
			} else if (tmp != null && !set.contains(tmp)) {
				set.add(tmp);
				count++;
			}
		}

		System.out.println(count);
	}
}
