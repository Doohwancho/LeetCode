package array;

public class UniquePath62 {
	
	//<����Ǯ��1>
	
	//�� �����غ��� ���������� ����.
	
	//m x n (where m = 3, n = 7)
    
    //xxxxxxx
    //xxxxxxx
    //xxxxxxx
    
    //1 1 1  1  1  1  1
    //1 2 3  4  5  6  7
    //1 3 6 10 15 21 28
	
	//ã�� �� ��� : �������� ������.
	
	//m x n (where m = 2, n = 2)
	
	//xx
	//xx
	
	//??
	//?2
	
	//���� �ܼ��� ���� �����ϸ� ������� 2��.
	
	//2 x 3���� ����
	
	//???
	//?23
	
	//������� 3��. �̰� 3x2�� ���� ���� 2x3�̶� ��ġ��
	
	//???
	//?23
	//?3
	
	//�̷��� ����. ������ 3x3�� ����
	
	//???
	//?23
	//?36
	
	//���� ������ �̷� ����� ����. ������ ?�� ��� 1�̶��� �˼�����. �������� �װ����� ���¹���� ���� �� �ϳ����̱� ����.
	
	//�׷���
	
	//111
	//123
	//136
	
	//�̷������� �Ǵµ�, ���⼭ ������ �߰��� �� ����. 
	
	//1)row index 0�� column index0�� ��� 1�� ä��������. 
	
	//2)(1,1)���� ������ ���ʰ� ���Ѱ� �ش� ���� ���� �Ǵ±���... ���. 
	
	//ũ.. �̰���
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
	//Memory Usage: 36.3 MB, less than 5.10% of Java online submissions for Unique Paths.
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        
        for(int i = 0; i < m; i++){
            grid[i][0] = 1;
        }
        
        for(int j = 0; j < n; j++){
            grid[0][j] = 1;
        }
        
        for(int p = 1; p < m; p++){
            for(int q = 1; q < n; q++){
                grid[p][q] = grid[p-1][q]+grid[p][q-1];
            }
        }
        
        return grid[m-1][n-1];
    }

}
