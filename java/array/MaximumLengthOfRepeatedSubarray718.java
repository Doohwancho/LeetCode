package array;

public class MaximumLengthOfRepeatedSubarray718 {
	
	/*
	//<Trial01>
	
	//Brute-force
	
	//�� �Ϸ��µ� ����� ���� ��~~~~�� ���Ƽ� �ȉ�.
	
	public int findLength(int[] A, int[] B) {
        int rst = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0, i_ = i, sub = 0; i_ < A.length && j < B.length; j++){
                if(A[i_] == B[j]){
                    i_++;
                    sub++;
                } else{
                    i_ = i;
                    sub = 0;
                }
                rst = Math.max(rst, sub);
            }
        }
        return rst;
    }
    */
	/*
	
	//<����Ǯ��1 by alexander>
	
	//Your input
	//[1,2,3,2,1]
	//[3,2,1,4,7]
	
	//stdout
	
	//0 0 1 0 0 0 
	//0 1 0 0 0 0 
	//3 0 0 0 0 0 
	//0 2 0 0 0 0 
	//0 0 1 0 0 0 
	//0 0 0 0 0 0 
	
	//Output : 3
	
	//�̷������...!
	
	//Runtime: 55 ms, faster than 29.85% of Java online submissions for Maximum Length of Repeated Subarray.
	//Memory Usage: 54 MB, less than 25.00% of Java online submissions for Maximum Length of Repeated Subarray.
	
    public int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                max = Math.max(max, dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0);
        return max;        
    }
    */
    
    //<����Ǯ��2 by alexander>
    
    //����Ǯ��1�� 2������ 1�������� ���� ����. 20ms������ 13.1MB�޸� ����
    
    //������ �Ȱ���. dp�� for������ ���� �Ʒ��� ���� ����.
    
	//Your input
	//[1,2,3,2,1]
	//[3,2,1,4,7]
    
	//0 0 1 0 0 0 
	//0 2 0 0 0 0 
	//3 0 0 0 0 0 
	//0 1 0 0 0 0 
	//0 0 1 0 0 0 
    
    //1���� 2���°� �˰ڴµ� 1�� �� �ٽ� 0�̵���? ���ϱ� j�� ����Ǯ��1���� �ٸ��� �����ϴ� ����̳�
    
    //�ȶ��ϳ� �� ģ��
    
    //Runtime: 35 ms, faster than 88.91% of Java online submissions for Maximum Length of Repeated Subarray.
    //Memory Usage: 40.9 MB, less than 80.00% of Java online submissions for Maximum Length of Repeated Subarray.
    
    public int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dp[j] = a[i] == b[j] ? 1 + dp[j + 1] : 0);
        return max;        
    }
}
