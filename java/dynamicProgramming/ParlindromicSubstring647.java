package dynamicProgramming;

public class ParlindromicSubstring647 {
	
	
	//<����Ǯ��1 by shawngao>
	
	//for������ ���ĺ� �ϳ��ϳ� ���鼭, i��°�� palindrome�� �߾� �������� ���, i��° ���ؿ��� �糡�ܿ� �����ִ� �ִ���� palindrome���� ���� ���.
	
	//Runtime: 2 ms, faster than 96.87% of Java online submissions for Palindromic Substrings.
	//Memory Usage: 37.4 MB, less than 54.18% of Java online submissions for Palindromic Substrings.
	
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=extractPalindrome(s,i,i);//odd length
            count+=extractPalindrome(s,i,i+1);//even length
        }
        return count;
    }
    public int extractPalindrome(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
            count++;
        }
        return count;
    }
    
    //<����Ǯ��2 by li-_-il>
    
    //dp
    
    //testcase:"abcba"
    
    //  a b c b a
    //a 1 0 0 0 1
    //b 0 1 0 1 0
    //c 0 0 1 0 0
    //b 0 0 0 1 0
    //a 0 0 0 0 1
    
    //j - i  + 1 < 3 �� "aa"���� ���̰� 2 ������ string�� �ִ� ��쿡 ������ ����
    
    //�߿��� ������ 2����
    
    //s.charAt(i) == s.charAt(j) ���
    
    //dp[i + 1][j - 1] ��
    
    //�ϴ� ù��° s.charAt(i) == s.charAt(j) ��� palindrome�̷��� �ʼ������� �־�� ����
    
    //�׷� "abcba"���� ������ ���� ���ĺ� 'a','b','c','b','a'�� ī��Ʈ �ǰ���
    
    //�׷� �� ������ �����ؾ� �ϴ°� "bcb"�� "abcba"�� ��� �ֳ��ε�,
    
    //�װ� �����ϰ� ����°� �ι�° �� dp[i + 1][j - 1] ����
    
    //"bcb"�� ��� ī��Ʈ �ϴ��� �����غ���
    
    //�ϴ� 'c'���� s.charAt(i) == s.charAt(j)������ +1�� boolean[][]dp �� ����
    
    //�� ���� 'b'���ʿ��� for������ 'b' -> 'c' -> 'b' -> 'a' �� ��,
    
    //'b' -> 'c' -> ***'b'*** -> 'a'
    
    //�� �κп��� i��° 'b'�� j��° 'b'�� ��������? "bcb"�ϱ�
    
    //���⼭ i�� "bcb"���� ���� ���ʿ� ��ġ�� �ε�����, j�� ���� �����ʿ� ��ġ�� �ε�����. �׷��ϱ�, ���� �־��� string���� "abcba"���� i�� 1, j�� 3�� �ǰ���
    
    //���⼭ �츮�� �Ű����ϴ� �κ���, "bcb"�����ܰ谡 palindrome���� ���߰���?
    
    //���� "b??b"���� �糡�ܿ� b�� �Ȱ��Ƶ�, ��� ??�ΰ��� "bxyb"�� palindrome�� �ƴ��ݾ�. "baab"�� ���ܰ��� "aa"�� palindrome�̿��� �� �����ܰ��� "baab"�� ���� +1�� ���� �� ���ݾ�.
    
    //�� �����ܰ踦 ���°� dp[i+1][j-1]��. 
    
    //i(left most index)+1�̶� j(right most index)-1�� ���� �� ���ܰ谡 palindrome�̾��ٸ� 1�� �����־�����.
    
    //  a b c b a
    //a 1 0 0 0 1
    //b 0 1 0 1 0
    //c 0 0 1 0 0
    //b 0 0 0 1 0
    //a 0 0 0 0 1
    
    //���� i�� 1, j�� 3�� ��������, �� ���ܰ��� i�� 2, j�� 2�� ��, 'c'�� ��, palindrome�̾����Ƿ�, "bcb"�� palinedrome�̱��� �ؼ� +1 ���ذ���.
    
    //"abcba"�� ����������, �� ���ܰ��� "bcb"�ڸ��� +1�� �����ְ�, �糡���� 'a'�� ���� �����Ƿ�, +1���ذ���.
    
    //Runtime: 10 ms, faster than 39.71% of Java online submissions for Palindromic Substrings.
    //Memory Usage: 39.2 MB, less than 28.79% of Java online submissions for Palindromic Substrings.
    
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }
}
