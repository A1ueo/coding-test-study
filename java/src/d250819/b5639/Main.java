package d250819.b5639;

import java.io.*;

/* 이진 검색 트리
 * 트리를 전위 순회한 결과가 주어진다.
 * 노드에 들어있는 키의 값은 106보다 작은 양의 정수이다.
 * 모든 값은 한 줄에 하나씩 주어지며, 노드의 수는 10,000개 이하이다.
 * 같은 키를 가지는 노드는 없다.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Tree tree = new Tree();

		String buff;
		while ((buff = br.readLine()) != null && !"".equals(buff)) {
			tree.add(new Node(buff));
		}

		System.out.println(tree.postOrder());
	}
}

class Node {
	int value;
	Node left;
	Node right;

	public Node(String str) {
		this.value = Integer.parseInt(str);
	}
}

class Tree {
	Node root;
	StringBuilder sb;

	void add(Node node) {
		if (root == null) root = node;
		else add(root, node);
	}

	void add(Node curr, Node node) {
		if (curr.value > node.value) {
			if (curr.left == null) curr.left = node;
			else add(curr.left, node);
		} else {
			if (curr.right == null) curr.right = node;
			else add(curr.right, node);
		}
	}

	StringBuilder postOrder() {
		sb = new StringBuilder();
		postOrder(root);
		return sb;
	}

	void postOrder(Node curr) {
		if (curr.left != null) postOrder(curr.left);
		if (curr.right != null) postOrder(curr.right);
		sb.append(curr.value + "\n");
	}
}
