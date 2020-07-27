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
	  
	//inorder = [9,3,15,20,7]
	//postorder = [9,15,7,20,3]
	
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	
	//1) root.right�������� postorder���ִ� ���ڸ� �������� ����. �ֳĸ� postorder�� ������ pre-order���ڳ�.
	  
	//   �������� �ֳĸ� inEnd > inStart�� �ɶ�����. 
	//   �ֳĸ� inorder�� �� �������� ���̴� ������, inorder�� ���� ������ left-root-right������ ���� ������, inorder���� �������� inStart�� �Ѿ ������,
	//   ���̻� �����ʿ� ���� �ְ� ���ٴ� ���̴ϱ�, �̶����� ���� child�� ä��� ��.  
	  
	//2) �ٽ� root�� �ö���鼭 left child�� ���� ä����. ä�ﶧ 
	//   root.left = buildTree(inorder, idx-1, inEnd, postorder, postStart-1-(inStart - idx)); �� ���ڳ�?
	//   ���⼭ inEnd�� inorder.length()��, inStart�� inorder.length()-1�̾��µ� �긦 ���� ���߸鼭 ������ �÷���.
	//   ���ߴ°� idx-1��. �ֳĸ� for��������   if(inorder[i] == postorder[postStart]) idx = i
	//   �ϸ� idx�� inorder���� root�� �ǰ�, ���ʿ� ���� child�� inorder���� idx���� ���ʿ� �־�� �Ǵϱ�(inorder�� left-root-right��)

	//   �׸��� postStart-1-(inStart - idx)�̰�.... �𸣰ڳ� ����
	
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
