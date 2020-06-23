package juneChallenge;

public class CountCompleteTreeNodes {

	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	 
	/*
	//<����Ǯ��1>
	
	//�׳� ��� ��� ���鼭 +1�� ���ָ� ����. �ؿ��� ����.
	
	//�ƴϸ� �׳� pre/in/post order traversal�� �ϰų� ���鼭 �� node�鸦������ +1�� ���ָ� ����
	
	//�� �ٵ� �������� tree�� complete binary tree���
	
	//�̷� ������ ������� Ǫ�°ͺ��� �� �Ź��� ����� �����ٵ�
	
	//Runtime: 0 ms
	//Memory Usage: 42 MB
	
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    */ 
    
    
    //<����Ǯ��2 by StefanPochmann>
    
    //complete binary tree�� �� ���ʺ��� ä�����ٴ°� �̿��ؼ� height()�Լ��� �� �������� ����.
    
    //h < 0 ? 0�� root==null�̸� 0�� ��ȯ���ְ� �װ� �ƴ϶��
    
    //height(root.right) == h-1 ? (1 << h) + countNodes(root.right) �� ��
    
    //���⼭ height(root.right)�� ���� ��, == h-1�̶�°�, left child�� right child�� ���� ���� ������ ���̶�°���.
    
    //root.right�Ҷ� ��ĭ ���������ϱ�.
    
    //�������̶��, �������� �� �� �ִٴ� ���� ������ �� ä�����ٴ� ���̴ϱ�, ���ʿ� �ִ¾ֵ��� �� ����. (1<<h)��. 
	  
	//�������, 
	  
//	     1
//	    / \
//	   2   3
//	  / \  /
//	 4  5 6
	  
	
	//1���� 3���� height(root.right)������ ��,
	  
	//height�� 2�ϱ�, 1<<2�� ���ؼ� 4�� ����. �� 4�� ���ʿ� �ִ� (1,2,4,5)��.
	  
	//�׷� node(3)���� �Ȱ����� ���� �ݺ���. ���� ���� �ȸ���������. 
	  
//	   3  
//	  / \ 
//	 6   
    
	//���� ���� ������ ������ �ȸ����ϱ� 
	  
	//���� �ȸ��� ���� ����, : (1 << h-1) + countNodes(root.left);�� �ϴ°�.
  
	//(1<<h-1)�� �ϴ� 1�� ���ϰ�(4+1�ؼ� ����5) root.left�� ��
	  
	//�׷� height�� 0�� ������, height(root.right) == h-1 �� �Ǵϱ� (1 << h) + countNodes(root.right)�� �ؼ� �� 1�� ������
	  
	//�׷��� 4+1+1�ؼ� 6�̶�� ���ε�..
	  
	//� ���� �����
	  
	//��� ��� �� �ȵ��Ƽ� ����ȭ�� �ߵǱ� �M��
	  
    //Runtime: 0 ms
    //Memory Usage: 41.6 MB 
    
    
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
    
}
