package september;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumber {

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
	
	//brute-force
	
	//string���� +=���ָ� �ʹ� �����ɸ��ϱ�, stringbuilder�� ����ؼ�
	
	//��ĭ�� ������������ root.val�ٿ���.
	
	//���� ���ƿ��� sb.deleteCharAt(sb.length() - 1); �� �ش� ��Ʈ �ؿ� �̹� �ٳ�� �ֵ��� ���ְ�.
	
	//if (root.left == null && root.right == null) {
//		list.add(new StringBuilder(sb));
//		return;
//	}
	
	//���� list.add(sb);�� ���ϰ� list.add(new StringBuilder(sb));�� �� ������
	
	//���� stringbuilder�� �������� ������, �����Ͱ� ���� �ּڰ��� ����Ű�� ������,
	
	//���� ��� ���鼭 sb.append(root.val)�� ��, 
	
	//����Ʈ�� �̹� �� �ִ� stringbuilder���� �ٲ�� ����.
	
	//binary number -> int�� ��,
	
	//Integer.parseInt(String(binary number), 2);
	
	//�Լ��� �̿���.

	// Runtime: 2 ms
	// Memory Usage: 38.8 MB

	List<StringBuilder> list;

	private void dfs(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val);

		if (root.left == null && root.right == null) {
			list.add(new StringBuilder(sb));
			return;
		}
		if (root.left != null) {
			dfs(root.left, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (root.right != null) {
			dfs(root.right, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	public int sumRootToLeaf(TreeNode root) {
		if (root == null)
			return 0;
		list = new ArrayList<>();
		dfs(root, new StringBuilder());
		int rst = 0;
		for (StringBuilder sb : list) {
			rst += Integer.parseInt(sb.toString(), 2);

		}

		return rst;
	}
	
	
	//<����Ǯ��2 by lee215>
	
	//���ΰ��� �׻� ��ź�簡 ���������� ����� �����س��±���
	
	//��¥�� �������� �ڸ����� �������� �������� *2���ݾ�
	
	//�װ� val = val*2 + root.val�� ǥ���ѰŰ�
	
	//���� �������ٰ� leaf(��Ʈ�Ӹ�)�� ���²� �����ذ� ��ȯ�ϰ�, (root.left == null && root.right == null ? val)
	
	//�� ��ȯ�� �Ű� ���� �ö���鼭 dfs(root.left, val) + dfs(root.right, val) �� �� ������ 
	
	//�� ���� ��ȯ�ǰ� ��.
	
	//O(N)
	
	//Runtime: 0 ms
	//Memory Usage: 38.6 MB
	
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if(root == null) return 0;
        val = val*2 + root.val;
        return root.left == null && root.right == null ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}
