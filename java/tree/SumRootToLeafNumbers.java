package juneChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {

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
	
	//dfs(depth-first-search)

	//�Ķ���ͷ� String��� �Ѱ��ָ鼭 +root.val ���� ������
	
	//leaf�� ���� �����ϸ�(== left child, right child�� ���� ��) rst�� s+root.val�����ָ� ����
	
	//�� �ٵ� ���� �۷ι� ���� �Ⱦ��� �ͱ� �ѵ�

	// Runtime: 14 ms
	// Memory Usage: 40 MB

	int rst = 0;

	private void dfs(TreeNode root, String s) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			rst += Integer.parseInt(s + root.val);
		}
		dfs(root.left, s + root.val);
		dfs(root.right, s + root.val);
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		dfs(root, "");
		return rst;
	}
	
	//<����Ǯ��2>
	
	//int[]�� �Ķ���ͷ� �Ѱ��ָ�, �ּڰ��� �Ѱ��ִ°Ŷ� �۷ι� ������ �Ƚᵵ ������~
	
	//�׸��� String�Ἥ ���̴��� �׳� �Ķ���ͷ� ������ *10�ϰ� root.val���ϸ� �ξ� �����ڳ�~
	
	//Runtime: 0 ms
	//Memory Usage: 37.5 MB
	
    private void helper(TreeNode root, int[] rst, int n){
        if(root == null) return;
        if(root.left == null && root.right == null){
            rst[0] += n*10 + root.val;
        }
        helper(root.left, rst, n*10+root.val);
        helper(root.right, rst, n*10+root.val);
    }
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] rst = new int[1];
        helper(root, rst, 0);
        return rst[0];
    }
	
	
	
	//<����Ǯ��3>
	
	//bfs(breadth-first-search)
	
	//Runtime: 10 ms
	//Memory Usage: 38.4 MB
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int rst = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<String> qString = new LinkedList<>();
        
        q.add(root);
        qString.add(String.valueOf(root.val));
        
        while(!q.isEmpty()){
            TreeNode r = q.poll();
            String s = qString.poll();
            
            if(r.right != null){
                q.add(r.right); 
                qString.add(s+r.right.val);
            } 
            if(r.left != null){
                q.add(r.left);     
                qString.add(s+r.left.val);
            } 
            
            if(r.left == null && r.right == null){
                rst += Integer.parseInt(s);
            }
        }
        return rst; 
    }
    
    
}
