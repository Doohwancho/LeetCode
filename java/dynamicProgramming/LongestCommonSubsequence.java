package thirtyDayChallenge;

public class LongestCommonSubsequence {
	
	
	//<����Ǯ��1>
	
	//dynamic programming
	
	//÷�� subsequence��淡 substringó�� �پ��־�� �Ǵ��� �˾Ҵµ�, ������ ���ٸ� ������ �־ ��� ����.
	
	//�׷��� ������ else���� dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);�� ��
	
	//������ ���Դ��� ������ �־ ���������־�� �ϱ� ����.
	
	//Input: text1: "abcde", text2: "ace"
	//Output: 3
	
	//Stdout:
	//0 0 0 0 
	//0 1 1 1 
	//0 1 1 1 
	//0 1 2 2 
	//0 1 2 2 
	//0 1 2 3 
	
	//37 / 37 test cases passed.
	//Status: Accepted
	//Runtime: 1374 ms
	//Memory Usage: 44.5 MB
	
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
    	int n = text2.length();
    	
    	int[][] dp = new int[m+1][n+1];
    	
    	for(int i = 1; i < m+1; i++) {
    		for(int j = 1; j < n+1; j++) {
    			if(text1.charAt(i-1) == text2.charAt(j-1)) {
    				dp[i][j] = dp[i-1][j-1]+1;
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
        
    	return dp[m][n];
    }
	
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "def";
		
		System.out.println(longestCommonSubsequence(s1, s2));
	}
}
