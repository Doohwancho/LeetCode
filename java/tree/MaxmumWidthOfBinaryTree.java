package julyChallenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxmumWidthOfBinaryTree {
	
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
	 
	//<Trial01>
	
	//�������ظ� �߸��߳�
	
	//    1
	//   /  
	//  3    
	// / \       
	//5   3  
	
	//��ó�� �������� �ƿ� �� ����� ������ 5,3 �Ѹ� ó���ϴµ� ���࿡
	
	//    1
	//   / \ 
	//  3   2 
	// / \   \    
	//5   3   4
	
	//��ó�� �ѳ��̶��� ��������� �ٸ��ѳ� ���ó�� ġ�� ������? 5+3+null+4�ؼ� 4
	
    public int widthOfBinaryTree(TreeNode root) {
        int rst = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            rst = Math.max(rst, size);
            while(size > 0){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                size--;
            }
        }
        return rst;
    }
    
    
    //<Trial02>
    
//	    1
//	   / \
//	  3   2
//	 /     \  
//	5       9 
//	/         \
// 6           7
//   Output: 8
    
    //�� �� ���� �߸� �����߳�
    
    //�� �̰�쿡 4�� �̾ƹ�����?
    
    //�� �� ����� null�� ��� �ִ� �� �������̶� ������ �Ÿ����� ���ϸ� �Ǵ°ű���
    
    public int widthOfBinaryTree(TreeNode root) {
        int rst = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            rst = Math.max(rst, size);
            while(size > 0){
                TreeNode node = q.poll();
                if(node == null){
                    size--;
                    continue;
                }
                boolean flag = !(node.left == null && node.left == node.right);
                
                if(flag){
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);       
                }

                size--;
            }
        }
        return rst;
    }
    
    //<Trial03 - time limit exceeded>
    
    public int widthOfBinaryTree(TreeNode root) {
        int rst = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, cnt = 0;
            
            while(size > 0){
                TreeNode node = q.poll();
                if(node == null){
                    q.add(null);
                    q.add(null);
                    size--;
                    continue;
                }
                
                cnt++;
                l = Math.min(l, size);
                r = Math.max(r, size);
                
                q.add(node.left);
                q.add(node.right);
                size--;
            }
            
            if(cnt > 0){
                rst = Math.max(rst, r-l+1);   
            } else {
                break;
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��1 by shawngao>
    
    //Runtime: 3 ms
    //Memory Usage: 39.8 MB
    
    Map<Integer, int[]> map = new HashMap<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        findMax(root, 0, 0);
        
        int res = 1;
        for (int[] rec : map.values()) {
            res = Math.max(res, rec[1] - rec[0] + 1);
        }
        
        return res;
    }
    
    private void findMax(TreeNode root, int level, int pos) {
        if (root == null) return;
        
        int[] rec = map.get(level);
        if (rec == null) {
            rec = new int[2];
            rec[0] = Integer.MAX_VALUE;
            rec[1] = Integer.MIN_VALUE;
        }

        rec[0] = Math.min(rec[0], pos);
        rec[1] = Math.max(rec[1], pos);
        map.put(level, rec);
        
        findMax(root.left, level + 1, 2 * pos);   //�̺κ��� ������, �̷��� �ϸ� ���ʺ��� ���������� ������� 0,1,2,3,4,5 ������ ����
        findMax(root.right, level + 1, 2 * pos + 1);
    }
}
