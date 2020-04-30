package thirtyDayChallenge;

public class CheckIfStringIsValidSeqFromRootToLeavesInBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// <����Ǯ��1>
	
	// �̰���~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	//recursive
	
	//������ ������������ arr�� idx�� +1�� ���ָ鼭, return�� ���� �տ��ִ� root.val == arr[idx]�� true�� �ٲ���.
	
	//�ٵ� root���� root.left�� �´°��� root.right�� �´°��� �𸣴ϱ�, �ΰ��� �ϳ��� �¾Ƶ� true�ǰ� or������ ����.
	
	//�׷��� leaf�� ���� ����(root.left�� root.right�� ��� null�ϋ�����) ��.
	
	//�׷��� ���ܿ� �ɸ���, �ι��� if���� true�� �Ǹ鼭, �ٽ� �ö�.

	// 63 / 63 test cases passed.
	// Status: Accepted
	// Runtime: 0 ms
	// Memory Usage: 40.4 MB

	private boolean check(TreeNode root, int[] arr, int idx) {
		if (root == null || idx == arr.length) return false;
		if (idx == arr.length - 1 && root.val == arr[idx] && root.left == null && root.right == null) return true;
		return root.val == arr[idx] && (check(root.left, arr, idx + 1) || check(root.right, arr, idx + 1));
	}

	public boolean isValidSequence(TreeNode root, int[] arr) {
		return check(root, arr, 0);
	}
}
