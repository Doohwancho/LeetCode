package augustChallenge;

public class SumOfLeftLeaves {

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
	
	
	//<����Ǯ��1>
	
	//dfs
	
	//bfs�� �ϰ������, �⺻���� bfsƲ�� �Ʒ��� ����ϰ� ���鼭
	
	//if(node.left != null && node.left.left == null && node.left.right == null) rst += node.left.val;
	
	//���ָ� ��
	
	//Runtime: 0 ms
	//Memory Usage: 37.5 MB

	private int dfs(TreeNode node, boolean flag) {
		if (node == null) return 0;
			
		int rst = 0;
		if (flag && node.left == null && node.right == null) {
			return node.val;
		}
		rst += dfs(node.left, true);
		rst += dfs(node.right, false);
		
		return rst;
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return dfs(root, false);
	}
}
