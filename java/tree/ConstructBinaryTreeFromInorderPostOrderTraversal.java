package julyChallenge;

public class ConstructBinaryTreeFromInorderPostOrderTraversal {

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
	 
	 
	//<����Ǯ��1 by jinwu>
	
	//� �𸣰ڳ�;;
	  
	//inorder = [9,3,15,20,7]
	//postorder = [9,15,7,20,3]
	
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	  
	// post order�� �������� pre order�� �ٲ�
	
	//1) root.right�������� postorder���ִ� ���ڸ� �������� ����. inEnd > inStart�� �ɶ�����. 
	//   inEnd > inStart�� inStart�� inorder.length-1�̰�, inEnd�� �� iterate���� for������ inorder[i] == postorder[postStart]�Ҷ����� ���Ŀ��.
	//   �ٵ� ��?
	  
	//2) �ٽ� root�� �ö���鼭 left child�� ���� ä����.
	
	//Runtime: 0 ms
	//Memory Usage: 39.5 MB
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart){
        
        if(postStart < 0 || inEnd > inStart) return null;
        
        TreeNode root = new TreeNode(postorder[postStart]);
        
        int idx = 0;
        for(int i = inStart; i >= inEnd; i--){
            if(inorder[i] == postorder[postStart]){ //inorder�� root�������� ���� ������ �����ϱ�, root�� idx�� �ΰ�
                idx = i;
                break;
            }
        }
        
        root.right = buildTree(inorder, inStart, idx+1, postorder, postStart-1); //�������� postorder�������� ������ �ǳ�
        root.left = buildTree(inorder, idx-1, inEnd, postorder, postStart-1-(inStart - idx));  //idx-1�� �߿�. inorder���� root�� ���ʾֱ������ ��.
        return root;
    }
}
