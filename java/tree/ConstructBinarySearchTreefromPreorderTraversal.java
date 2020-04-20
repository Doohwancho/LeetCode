package thirtyDayChallenge;

public class ConstructBinarySearchTreefromPreorderTraversal {

	// <����Ǯ��1 by lee215>
	
	//binary search tree�� left child�� �θ𺸴� ������, right child�� �θ𺸴� ū������ ������.

	// 110 / 110 test cases passed.
	// Status: Accepted
	// Runtime: 0 ms
	// Memory Usage: 37.4 MB

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	int i = 0;

	public TreeNode bstFromPreorder(int[] A) {
		return bstFromPreorder(A, Integer.MAX_VALUE); //tree.right�� �ִ�ġ�� �䷱������ �����س���
	}

	public TreeNode bstFromPreorder(int[] A, int bound) {
		if (i == A.length || A[i] > bound) return null;
		TreeNode root = new TreeNode(A[i++]);
		root.left = bstFromPreorder(A, root.val); //tree.left�� �ִ�ġ�� �翬�� �θ� ���ڰ�
		root.right = bstFromPreorder(A, bound);
		return root;
	}
}
