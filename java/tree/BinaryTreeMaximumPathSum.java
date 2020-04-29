package thirtyDayChallenge;

public class BinaryTreeMaximumPathSum {
	
	/*
	//<Trial01>
	
	//��.. �Ʒ����� ���� ���ߵǳ�
	
    int rst = Integer.MIN_VALUE;
    
    private int mps(TreeNode root){
        if(root == null) return 0;
        int l = mps(root.left);
        int r = mps(root.right);
        rst = Math.max(rst, Math.max(root.val, root.val+l+r));
        return root.val + l + r;
    }
    
    public int maxPathSum(TreeNode root) {
        mps(root);
        return rst;
    }
    */
	
	//<����Ǯ��1 by jeantimex>

	//�� ������ ����:��� ����� ���� ���̳ʽ��� ��������.
	
	//93 / 93 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 41.6 MB

	
    
    int rst = Integer.MIN_VALUE;
    
    private int mps(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(0, mps(root.left)); //���̳ʽ� ���� ���´ٸ�, ��¥�� ���ص� ���ǹ� �ϴϱ� 0���� �ٲ���.  ? -> �׷� parent node�� 2�̰� parent node.left�� -1�̸� ��� �ϳ�? node.left�� Math.max(0, node.left)�� 0�̵Ǵ�, 2+0+0(null)�Ͽ� 2����.
        int r = Math.max(0, mps(root.right)); 
        rst = Math.max(rst, root.val+l+r);   //children���� ���°� ���Ѱ� ���� ũ�ٸ�, ������Ʈ �����ִ� ��.
        return root.val+Math.max(l, r); //�ؿ��� ���� ���� �佺�Ҷ� left child�� right child�� �� ū�� �����ؼ� ��������
    }
    
    public int maxPathSum(TreeNode root) {
        mps(root);
        return rst;
    }
    
}
