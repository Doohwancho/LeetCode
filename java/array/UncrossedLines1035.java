package array;

import java.util.ArrayList;
import java.util.List;

public class UncrossedLines1035 {
	/*
	//<Trial01>
	
	//[1,1,2,1,2]
	//[1,3,2,3,1]
	
	//���� ����. A[1]�� �����ϰ� �Ѱܾ� �ϴµ� B[4]�� �ɸ��� �״�� ����.
	
    private int search(int[] A, int[] B, int i_, int j_,int total){
        for(int i = i_; i < A.length; i++){
            for(int j = j_; j < B.length; j++){
                if(A[i] == B[j]){
                    total += search(A,B,i+1,j+1,total);
                    return total+1;
                }
            }
        }
        return total;
    }
    
    public int maxUncrossedLines(int[] A, int[] B) {
        //[2,5,1,2,5]
        //[5,2,1,5,2]    [X,5,2,1,5,2]
        
        int total = 0;
        for(int i = 0; i < A.length; i++){
            total = Math.max(total, search(A,B,i,i,0)); 
        }
        
        return total;
    }
    */
	
	/*
	//<Trial02>
	 
	//brute-force
	
	//time-limit-exceeded

    private int search(int[] A, int[] B, int i_, int j_,List<Integer> list, int[] rst){
        for(int i = i_; i < A.length; i++){
            for(int j = j_; j < B.length; j++){
                if(A[i] == B[j]){
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(1);
                    rst[0] = Math.max(rst[0], tmp.size());
                    search(A,B,i+1,j+1,tmp, rst);
                }
            }
        }
        return list.size();
    }
    
    public int maxUncrossedLines(int[] A, int[] B) {
        int[] rst = new int[1];
        for(int i = 0; i < A.length; i++){
            search(A,B,i,i,new ArrayList<>(), rst); 
        }
        
        return rst[0];
    }
    */
	
	//<����Ǯ��1 by lee215>
	
	//LCS(longest common subsequence algorithm)
	
	//https://www.youtube.com/watch?v=NnD96abizww
	
	//Time O(N^2), Space O(N^2)
	
	//dp[i][j] denote the longest common subsequence between the first i elements of A and the first j elements of B
	//In the case of Example2
	//Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
	//below is the correspond martix dp[][]
	//0 0 0 0 0 0 0
	//0 0 0 1 1 1 1
	//0 0 1 1 1 2 2
	//0 0 1 1 2 2 2
	//0 0 1 2 2 2 3
	//0 0 1 2 2 3 3
	//so the answer is dp[5][6]=3
	
	//�»󿡼�+1�Ҷ��� ���� ������� �����ϸ�, ��� lcs�� ����������� Ȯ�ΰ���. ������ ���� ��ũ ����.
	
	//trial02ó�� 3�� loop�� �� layer���� arraylist�� A,B�� ��°�� ������ �� �ʿ䰡 ��� ������ ������.
	
	//Runtime: 4 ms, faster than 96.98% of Java online submissions for Uncrossed Lines.
	//Memory Usage: 40.8 MB, less than 6.33% of Java online submissions for Uncrossed Lines.
	
    public static int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length, dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        return dp[m][n];
    }
    
    public static void main(String[] args) {
		int[] A = new int[] {1,3,7,1,7,5};
		int[] B = {1,9,2,5,1};
		System.out.println(maxUncrossedLines(A,B));
	}
}
