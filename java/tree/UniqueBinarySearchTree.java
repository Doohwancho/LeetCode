package juneChallenge;

public class UniqueBinarySearchTree {

	//<����Ǯ��1 by mo10>
	
	//�̰� ���� �䵵 ��� Ǯ�̺�.
	
	/*
	Then assume we have the number of the first 4 trees: dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14 , how do we get dp[5] based on these four numbers is the core problem here.
	
	The essential process is: to build a tree, we need to pick a root node, then we need to know how many possible left sub trees and right sub trees can be held under that node, finally multiply them.
	
	To build a tree contains {1,2,3,4,5}. First we pick 1 as root, for the left sub tree, there are none; for the right sub tree, we need count how many possible trees are there constructed from {2,3,4,5}, 
	
	apparently it's the same number as {1,2,3,4}. So the total number of trees under "1" picked as root is dp[0] * dp[4] = 14. (assume dp[0] =1). 
	
	Similarly, root 2 has dp[1]*dp[3] = 5 trees. root 3 has dp[2]*dp[2] = 4, root 4 has dp[3]*dp[1]= 5 and root 5 has dp[0]*dp[4] = 14. 
	
	Finally sum the up and it's done.
	 */
	
	//�״ϱ� �̰� �����ϸ�
	
	//dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14 �̰ű��� ������ ���� �����ѵ�, ������ ��� �ƴ��İ� ������ ���ݾ�?
	
	//dp[5]�� ����, 1�� root�϶�, ������ 2,3,4,5���� binary tree�ϱ� �� ���������� ������?
	
	//�׷�����, 2,3,4,5�� ���ο� 1,2,3,4��� �����ϰ� ����� ���� ����, dp[4]�� 14�ϲ� �Ƴ�?
	
	//�� �����ʿ� ���� �� �ִ� ����� ����, ���ʿ� ���� �� �ִ� ����� ���� ���Ϸ�.
	
	//�׷��� dp[5]�϶� ���� 1�� * ������ 14�� �ؼ� 14����,
	
	//dp[5]�϶� root�� 2���, ���ʿ� 1�� ���ڰ�, �����ʿ� 3,4,5�� ���ϱ�, dp[1] * dp[3]�ؼ� 5�� �ǰڰ�,
	
	//dp[5]�϶� root�� 3�̶��, ���ʿ� 1,2�� ���� �����ʿ� 4,5�� ���ϱ�, dp[2] * dp[2]�ؼ� 4�� ����
	
	//�̷������� root�� 1,2,3,4,5�϶� 14+5+4+5+14�ؼ� 42 �̷����ΰ�
	
	//���� �ű����
	
	//Runtime: 0 ms 
	//Memory Usage: 35.8 MB
	
	 public int numTrees(int n) {
		int [] dp = new int[n+1];
	    dp[0]= 1;
	    dp[1] = 1;
	    for(int level = 2; level <=n; level++)
	        for(int root = 1; root<=level; root++)
	            dp[level] += dp[level-root]*dp[root-1];
	    return dp[n];
	}
}
