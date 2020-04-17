package thirtyDayChallenge;

public class NumberOfIsland {
	
	//<����Ǯ��1>
	
	//backtracking
	
	//���� �ɸ������� backtracking���� 1�� 2�� �ٲٰ� rst+1���ִ� ���.
	
	//�����»����� ��ĭ�� 1�� �ִ��� ���鼭, ������ �� ĭ���� �̵��ϰ� 1�� 2�� �ٲ� ��, �ٽ� �� ĭ �������� �����»� 1�� �ִ��� Ȯ���� �ݺ�.
	
	//loop���� ��¥�� ���� ������ ������� ������ �Ʒ��� ���µ�, �� ���� 3��° if�� 4��° if�� j>0�� i>0����?
	
	//�װ� ���࿡ ����
	
	//0010
	//0010
	//0110 
	
	//��������� ������, ������ ���ٰ� �������� ����� ���ݾ�. �׷��� �׷�
	
	//47 / 47 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 42.3 MB
    private void move(char[][] grid, int i, int j){
        grid[i][j] = '2';
        if(j < grid[0].length-1 && grid[i][j+1]=='1'){
            move(grid, i, j+1);
        }
        if(i < grid.length-1 && grid[i+1][j]=='1'){
            move(grid, i+1, j);
        }
        if(j > 0 && grid[i][j-1]=='1'){
            move(grid, i, j-1);
        }
        if(i > 0 && grid[i-1][j]=='1'){
            move(grid, i-1, j);
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int rst = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]=='1'){
                    move(grid, i, j);
                    rst++;
                }
            }
        }
        return rst;
    }
}
