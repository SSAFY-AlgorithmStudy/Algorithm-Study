import java.io.*;

public class Main {

	static class Node {
		int num;
		Node left;
		Node right;

		public Node(int num) {
			this.num = num;
		}
	}

	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int rootNum = Integer.valueOf(bf.readLine());
		Node root = new Node(rootNum);

		String input;
		while ((input = bf.readLine()) != null && input.length() != 0) {
			int cur = Integer.valueOf(input);
			addNode(root, new Node(cur));
		}

		postOrder(root);
		
		System.out.println(answer);
	}

	private static void postOrder(Node root) {
		if (root.left != null)
			postOrder(root.left);

		if (root.right != null)
			postOrder(root.right);

		answer.append(root.num).append('\n');
	}

	private static void addNode(Node parent, Node child) {
		if (parent.num > child.num) {
			if (parent.left == null) {
				parent.left = child;
				return;
			} else {
				addNode(parent.left, child);
			}
		} else {
			if (parent.right == null) {
				parent.right = child;
				return;
			} else {
				addNode(parent.right, child);
			}
		}
	}
}