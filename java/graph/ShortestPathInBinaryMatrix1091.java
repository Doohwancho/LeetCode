package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix1091 {
	
	//<����Ǯ��1>
	
	//bfs

	//�߷��߷�... 
	
	//��.��.��.��.��
	
	//������ �� �������� ���ƿ���
	
	//BOY~
	
	
	
	//�� bfs�� ��ĭ ���� �̹� �� ���� ��ũ�������. �ȱ׷��� [a,b]���� a->b���� b->a���� a->b���� ���� �ݺ��ϰŵ�.
	
	//�̹� ������ ��ũ�ϴ� ����� �ΰ����� �־�.
	
	//�ϳ��� boolean[m][n]�� �Ἥ ��ĭ �̵��Ҷ����� boolean[i][j] = true�� �ϴ� ����̰�,
	
	//�ٸ� �ϳ��� ������ ����(0)���� Integer.MAX_VALUE�� �ھƳ��� ����,
	
	//if(matrix[next] <= matrix[prev]+1) continue�� �ؼ� �̹� ������ ���� �ǳʶٴ� ����� �־�.
	
	//2��° ����� ������ ������, boolean[m][n]�� �޸� �Ҹ� ũ�⵵ �ϰ�,  
	
	//visited[m][n]����� �ᵵ grid�� ����� step�� ���� ������ ǥ������� �Ǽ�, �� �ΰ��� ��ģ ù��° ����� ���.
	
	//ù��° ������� �̹� ������ �ǳ� �ٴ� �κ���
	
	//if(matrix[next] <= matrix[prev]+1) continue; ��
	
	//�ѹ��� �Ȱ��� 0�� Integer.MAX_VALUE�̱� ������, matrix[next]�� matrix[prev]+1 ���� ������ Ŭ �� �ۿ� ����,
	
	//matrix[next]�� ���� ���� ��, Math.min(matrix[next], matrix[prev]+1); �� �ؾ� ���ݾ�?
	
	//�ֳĸ� A,B�� �Ѵ� ��ǥ������ �����ϴµ�, A�� �ִܰŸ��� ��ǥ������ ���� �����ص�,
	
	//B�� �� ���Ƽ� ���߿� ��ǥ������ �����ؼ� A�� ����� ������ �ȵǴϱ�, Math.min()�� ����� �Ѵ� ������.
	
	//Math.min()�̶� ������ �� �´� Integer.MAX_VALUE�� ���ž� �׷���.
	
	//Runtime: 12 ms, faster than 77.71% of Java online submissions for Shortest Path in Binary Matrix.
	//Memory Usage: 40.7 MB, less than 6.18% of Java online submissions for Shortest Path in Binary Matrix.
    
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        
        int[][] dir = new int[][]{{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        grid[0][0] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int[] coord = q.poll();
                int x = coord[0];
                int y = coord[1];
                
                for(int[] d : dir){
                    int dx = x+d[0];
                    int dy = y+d[1];
                    if(dx < 0 || dy < 0 || dx == grid.length || dy == grid[0].length || grid[dx][dy] <= grid[x][y]+1){
                        continue;
                    }
                    grid[dx][dy] = Math.min(grid[dx][dy], grid[x][y]+1);
                    q.add(new int[] {dx, dy});
                }
                
            }
        }
        
        return grid[m-1][n-1] == Integer.MAX_VALUE ? -1 : grid[m-1][n-1];
    }
	
	public static void main(String[] args) {
//		int[][] grid = new int[][] {{0, 0, 1},
//								    {1, 1, 0},
//								    {1, 1, 0}};
		int[][] grid = new int[][] {{0, 0, 0, 0, 1},
								    {1, 0, 0, 0, 0},
								    {0, 1, 0, 1, 0},
								    {0, 0, 0, 1, 1},
								    {0, 0, 0, 1, 0}};
		
		System.out.println(shortestPathBinaryMatrix(grid));
	}
}
