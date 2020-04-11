package thirtyDayChallenge;

public class DiameterOfBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	/*
	//<Trial01>
	
	//root�� �������鼭 longest path�� ã�°� �´µ�
	
	//root ���������鼭 logest pathã�� ��� ����
	
	private int longestPath(TreeNode root, int level) {
		if (root == null)
			return level;
		int curLevel = level;
		if (root.left != null)
			level = Math.max(level, longestPath(root.left, curLevel + 1));
		if (root.right != null)
			level = Math.max(level, longestPath(root.right, curLevel + 1));

		return level;
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int rst = 0;
		if (root.left != null)
			rst += longestPath(root.left, 1);
		if (root.right != null)
			rst += longestPath(root.right, 1);
		return rst;
	}
	*/
	
	
	/*
	//<����Ǯ��1>

	//106 / 106 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 39.3 MB
	
	int rst = 0;
    
    private int longestPath(TreeNode root, int level){
        if(root == null) return level;
        int curLevel = level; //level�� �׳� �Ķ���ͷ� �ȳѱ�� curLevel�� ������, left�Ŀ� right���� left�� right�� ������ ��ġ�� ����
        int left = 0;
        int right = 0;
        if(root.left != null) left = longestPath(root.left, curLevel);
        if(root.right != null) right = longestPath(root.right, curLevel);
        rst = Math.max(rst, left+right);               //�� node���� left+right�� �ִ�ġ�� .max()�� ������Ʈ
        return Math.max(left,right)+1;                 //�� node�� left�� Ȥ�� right���� �� ū ���� �� ������+1�ؼ� ��ȯ
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root, 0);
        return rst;
    }
    */
	
	
	//<����Ǯ��2 by shawngao>
	
	//���� ����, �� ����� ����
	
	//ó���� �Ķ���Ϳ� +1�� ���� �������� ���µ�, �׷��°� ����
	
	//�� �ؿ������� ��ͷ� +1�� �ؼ� �ö󰡸鼭
	
	//left,right�� max�� ������Ʈ �����ִ°� �� ���� ������
	
	//�Ķ���Ϳ� level�� ���ֹ���
	
	//����Ǯ�� 1���� return level���� return 0�ص� accepted��
	
	//�Ķ���� �ʿ���� �����
	
	int rst = 0;
    
    private int longestPath(TreeNode root){
        if(root == null) return 0;
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        rst = Math.max(rst, left+right);               
        return Math.max(left,right)+1;                 
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return rst;
    }
	
    
}
