package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence392 {
	
	//<����Ǯ��1>
	
	//two-pointers
	
	//O(N+M) == O(N)
	
	//Runtime: 1 ms, faster than 78.16% of Java online submissions for Is Subsequence.
	//Memory Usage: 37 MB, less than 50.13% of Java online submissions for Is Subsequence.
	
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        char[] s_ = s.toCharArray();
        char[] t_ = t.toCharArray();
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(s_[i] == t_[j]){
                i++;
                j++;
            } else {
                j++;    
            }
        }
        return i == s.length();
    }
    
    
    //<����Ǯ��2>
    
    //dp
    
    //O(N*M)
    
    //Runtime: 4 ms, faster than 9.04% of Java online submissions for Is Subsequence.
    //Memory Usage: 39 MB, less than 10.38% of Java online submissions for Is Subsequence.
    
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];   
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;    
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    
                }
            }
        }
        return dp[m][n] == m;
    }
    
    
    //<����Ǯ��3>
    
    //dp + memoization
    
    //O(N+M) == O(N)
    
    //Runtime: 1 ms, faster than 78.16% of Java online submissions for Is Subsequence.
    //Memory Usage: 39.4 MB, less than 5.68% of Java online submissions for Is Subsequence.
    
    static String S;
    static String T;
    static int[] mem;
    
    private void init(String s, String t){
        S = s;
        T = t;
        mem = new int[t.length()];
        for(int i = 0; i < mem.length; i++){
            mem[i] = -1;
        }
    }
    
    private int dp(int i, int j){
        if(i == S.length() || j == T.length()) return 0;
        if(mem[j] != -1) return mem[j];
        mem[j] = 0;
        
        if(S.charAt(i) == T.charAt(j)){
            mem[j] = Math.max(mem[j], dp(i+1, j+1)+1);
        } else {
            mem[j] = Math.max(mem[j], dp(i, j+1));
        }
        return mem[j];
    }
    
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        init(s,t);
        dp(0, 0);
        return mem[0] == s.length();
    }
    
    
    
    //<����Ǯ��4 by karprbain1>
    
    //binary search
    
    //t�� map�� <���Ŀ�, �ش���ĺ��� �ε�����>�� ����. ������ �ε������� ������������ ��. t�� for������ �� �� �ε����� ���������� �����ϸ鼭 ���ϱ�.
    
    //�������� ���ĵ� �迭�� binary search ��� ����.
    
    //s�� ���ĺ��� �ѱ��� �ѱ��ڸ� for������ ���鼭, �ϴ� �ش� ���ĺ��� map�� �ִ��� ���� Ȯ���ϰ�(�������� ���ϸ� ã�� �ʿ� �����ϱ�. �ٷ� return false)
    
    //map�� ������, �ش� ���ĺ��� t�� �����ϱ�� �Ѵٴ� ���ε�, ������ ���� �� ���ݾ�? 
    
    //�ٵ� �츮�� �� ���� �ε����߿� �ּҰ��� ���� ��. 
    
    //�� �ּҰ��� ã�°� binary search�� �Ἥ ã��.
    
    //��... ����?
    
    //Runtime: 3 ms, faster than 12.90% of Java online submissions for Is Subsequence.
    //Memory Usage: 38.7 MB, less than 16.01% of Java online submissions for Is Subsequence.
    
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;

        Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

        //preprocess t
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }

        int prev = -1;  //index of previous character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(c) == null) { // if not found return false 
                return false;
            } else {
                List<Integer> list = map.get(c);
                prev = binarySearch(prev, list, 0, list.size() - 1);
                if (prev == -1) {
                    return false;
                }
                prev++;
            }
        }

        return true;
    }

    private int binarySearch(int index, List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start == list.size() ? -1 : list.get(start);
    }
}
