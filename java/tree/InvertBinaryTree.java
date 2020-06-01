package juneChallenge;

public class InvertBinaryTree {
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
	
	/*
	//<����Ǯ��1>
	
	//�׳� pre/post order�� �ϰų� �Ѹ鼭
	
	//left child�� right child ��ġ�� �ٲ��ָ� ��.
	
	//Runtime: 0 ms
	//Memory Usage: 36.7 MB

	private void flip(TreeNode root) {
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}

	private void preorder(TreeNode root) {
		if (root == null) return;
		flip(root);
		preorder(root.left);
		preorder(root.right);
	}

	public TreeNode invertTree(TreeNode root) {
		preorder(root);
		return root;
	}
	*/
	
	//<����Ǯ��2 by SOY>
	
	//bottom up approach
	
	//Runtime: 0 ms
	//Memory Usage: 37.1 MB
	
    private TreeNode invert(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = root.right;
        root.right = invert(root.left);
        root.left = invert(tmp);
        return root;
    }
    
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
}
