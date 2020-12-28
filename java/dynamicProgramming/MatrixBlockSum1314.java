package dynamicProgramming;

public class MatrixBlockSum1314 {

	//<����Ǯ��1>
	
	//O(M^2*N)
	
	//Runtime: 5 ms, faster than 33.96% of Java online submissions for Matrix Block Sum.
	//Memory Usage: 40.1 MB, less than 71.18% of Java online submissions for Matrix Block Sum.
	
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] acc = new int[m+1][n+1];
        int[][] rst = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                acc[i+1][j+1] = mat[i][j] + acc[i+1][j];
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int p = Math.max(0, i-K), r = Math.min(n, j+K+1), l = Math.max(0, j-K); p < Math.min(m, i+K+1); p++){
                    sum += acc[p+1][r] - acc[p+1][l];
                }
                rst[i][j] = sum;
            }
        }
        
        return rst;
    }
    
    
    //<����Ǯ��2 by hiepit>
    
    //https://leetcode.com/problems/matrix-block-sum/discuss/477041/Java-Prefix-sum-with-Picture-explain-Clean-code-O(m*n)
    
    //int[][] sum�� �������� (i,j) ���� �簢�� ���� ���ڵ��� ������ ����� ��, ���� ��ũ�� �׸�ó�� Ư�� ��ġ�� �簢�� �� ���� ���
    
    //��ǻ�� �������� ���� �˰����̶�� ��
    
    //https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-integral-image/
    
    //O(M*N)
    
    //Runtime: 3 ms, faster than 95.11% of Java online submissions for Matrix Block Sum.
    //Memory Usage: 40.4 MB, less than 42.80% of Java online submissions for Matrix Block Sum.
    
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }
        
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
                int r2 = Math.min(m - 1, r + K), c2 = Math.min(n - 1, c + K);
                r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                ans[r][c] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }
        return ans;
    }
}
