package julyChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

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
	
	//bfs - level order traversal
	
	//Runtime: 2 ms
	//Memory Usage: 40.7 MB
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //��ȿ�� �˻�
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> rst = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size(); //�̰� �� �� ��ü�� ������
            while(size > 0){ //�ش� �� ��ü ��带 ���鼭
                TreeNode node = q.poll(); //
                if(node.left != null){ //left child, right child�� ���� ��(temp)�� ����ְ�
                    q.add(node.left);
                    temp.add(node.left.val);
                }

                if(node.right != null){
                    q.add(node.right);
                    temp.add(node.right.val);
                }                
                size--;
            }
            if(temp.size() > 0) rst.add(0, new ArrayList<>(temp)); //�ش� �� �ֵ��� �� ������� rst�� �������� ��ƾ� �ϴϱ�, ù��°�� �ھƵ�.
        }
        
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        rst.add(tmp);
        
        return rst;
    }
}
