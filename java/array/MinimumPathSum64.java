package array;

public class MinimumPathSum64 {
	
	//<����Ǯ��1>
	
	//https://doohwancho.tistory.com/792?category=1055107
	
	//�� ������ ������ ����. ����Ǯ�̴� �� ��ũ ����.
	
	//���⼭ ���� ���� ���ϴ°� �ƴ϶�, ���� ���� �� �� �������� ���ϴ°���.
	
	//��¥�� �ش� ��ǥ(x,y)�� ���µ� ����� �ƹ��� ���Ƶ�, �� �߿� ���� ª�� ��Ʈ�� �� ���̱� ����.
	
	//ũ...�̰���
	
	//Runtime: 1 ms, faster than 99.20% of Java online submissions for Minimum Path Sum.
	//Memory Usage: 41.9 MB, less than 87.84% of Java online submissions for Minimum Path Sum.
	
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 1; i < m; i++){
            grid[i][0] += grid[i-1][0];
        }
        
        for(int j = 1; j < n; j++){
            grid[0][j] += grid[0][j-1];
        }
        
        for(int p = 1; p < m; p++){
            for(int q = 1; q < n; q++){
                grid[p][q] += Math.min(grid[p-1][q], grid[p][q-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
