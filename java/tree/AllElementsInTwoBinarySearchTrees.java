package september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AllElementsInTwoBinarySearchTrees {

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

	// queue
	
	//bst�� inorder�� ���� ���� ���� ���ں��� ������������ ���ʴ�� ����.
	
	//root1�� inorder�� ���鼭 queue�� ���ʴ�� ������������ ����
	
	//�׸��� root2�� inorder�� ���ʴ�� �� ��, queue�� ���� ���� ���� ���ϸ鼭,
	
	//���� �� �������� list�� �־���.
	
	//�� �������� root2�� �� ���Ƶ� q�� ��Ⱑ �������� �� �ֱ� ������
	
	//(q�� ������ root2�� ���� ū ������ �� ū ���)
	
	//������ �ֵ��� �־���
	
	//O(n*m)
	
	//---
	
	//ã�ƺ��� merge solution�̶�� �ֳ�. �ٵ� �³׵��� root1, root2�Ѵ� queue�� �ְ�, merge�ϴ� ��.
	
	//�ڵ尡 �� �����ϰ� �����ϳ�, ����Ǯ��1�� n�� m�� �ϳ���ŭ iterate���ص� �Ǳ� ������ ������ ���Ÿ�ŭ �� ����.
	
	//99% runtime distribution
	
	//Runtime: 6 ms
	//Memory Usage: 42.6 MB

	Queue<Integer> q;
	List<Integer> rst;

	private void dfs(TreeNode root) {
		if (root == null)
			return;
		dfs(root.left);
		while (q.size() > 0 && q.peek() < root.val) {
			rst.add(q.poll());
		}
		rst.add(root.val);
		dfs(root.right);
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		q.add(root.val);
		inOrder(root.right);
	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		q = new LinkedList<>();
		rst = new ArrayList<>();
		inOrder(root1);
		dfs(root2);
		while (q.size() > 0) {
			rst.add(q.poll());
		}
		return rst;
	}
	
	
	
	//<����Ǯ��2>
	
	//PriorityQueue
	
	//������ ���������� �ڵ尡 ��������
	
	//Runtime: 35 ms  - 20.79% time distribution
	//Memory Usage: 42.2 MB
	
    PriorityQueue<Integer> q;

    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        q.offer(root.val);
        inOrder(root.right);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        q = new PriorityQueue<>((a,b)->a-b);
        inOrder(root1);
        inOrder(root2);
        
        List<Integer> rst = new ArrayList<>();
        while(q.size() > 0) {
			rst.add(q.poll());
		}
        
        return rst;
    }
    
    //<����Ǯ��3>
    
    //root1->root2(bst ��Ģ�� �°�)
    
    //�׸��� root2�� in-order-traversal�� ���鼭,
    
    //������� list�� �־� return.
    
    //������ ���� �־����� �̷� ��ĵ� ����.
    
    //O(n*(m+1)) 
    
    //Runtime: 207 ms
    //Memory Usage: 42.4 MB
    
    List<Integer> rst;
    TreeNode root2_static;
    TreeNode root2_prev;
    
    
    private void insert(TreeNode root1, TreeNode prev, int val){
        if(root1 == null) {
            if(val < prev.val){
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
            return;
        }
        if(val < root1.val){
            prev = root1;
            insert(root1.left, prev, val);
        } else {
            prev = root1;
            insert(root1.right, prev, val);
        }
    }
    
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        insert(root2_static, root2_prev, root.val);
        dfs(root.right);
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        rst.add(root.val);
        inOrder(root.right);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            rst = new ArrayList<>();
            inOrder(root1);
            return rst;
        } else {
            root2_static = root2;
            root2_prev = root2;
        }
        
        dfs(root1);
        
        rst = new ArrayList<>();
        inOrder(root2);
        return rst;
    }
}
