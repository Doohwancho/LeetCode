package juneChallenge;

public class SearchInABinarySearchTree {

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
	
	//pre-order traversal

	// Runtime: 0 ms
	// Memory Usage: 39.9 MB

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) return null;
		if (root.val == val) return root;
		TreeNode t = searchBST(root.left, val);
		return t != null ? t : searchBST(root.right, val);
	}
	
	
	//<����Ǯ��2>
	
	//binary search
	
	//�� ���� �̸��� binary search tree��� �����־���
	
	//�׷� ���� pre/in/post-order traversal �� �ʿ䰡 ����
	
	//����������� ���� ���ݾ�. root.val�̶� val���ϸ�
	
	//root.val���� val�� �� ������ �������� ��������, root.val���� val�� �� ũ�� ������ ���� ���� ����
	
	//Runtime: 0 ms
	//Memory Usage: 40 MB
	
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        return root.val > val ? searchBST(root.left, val): searchBST(root.right, val);
    }
}
