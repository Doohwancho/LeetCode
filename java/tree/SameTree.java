package julyChallenge;

public class SameTree {

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

	// ũ �̰���. �ϼ� ��ų

	// Runtime: 0 ms
	// Memory Usage: 38.8 MB

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		else if (p == null || q == null) return false; // ���� �ϳ��� null�̰ų� ���� �ٸ� ��츸 false, ������ ���� ��� true��ȯ.
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // �� child��� true���� ���;� ����
	}
	
	//<����Ǯ��2 by ijaz20>
	
	//������ ���ٷ� ������ ��.
	
	//p==q || ó���� ������ null���� ���� �� �־. 
	
	// Runtime: 0 ms
	// Memory Usage: 38.8 MB
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p == q || (p!= null && q!=null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
	
	
}
