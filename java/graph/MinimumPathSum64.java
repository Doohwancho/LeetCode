package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumPathSum64 {

	//<Time Limit Exceeded>
	
	//Dijkstra

	//27 / 61 test cases passed.
	
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1,0},{0, 1}};
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[] {grid[0][0], 0, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int acc = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            if(x == m-1 && y == n-1) return acc;
            
            for(int[] dir : dirs){
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX >= m || newY >= n) continue;
                pq.offer(new int[] {acc+grid[newX][newY], newX, newY});
            }
        }
        
        return 0;
    }
    
    //<����Ǯ��1>
    
    //Dijkstra
    
    //Runtime: 439 ms, faster than 5.26% of Java online submissions for Minimum Path Sum.
    //Memory Usage: 52.3 MB, less than 5.03% of Java online submissions for Minimum Path Sum.
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        for(int[] mat : matrix){
            Arrays.fill(mat, Integer.MAX_VALUE);
        }
        matrix[0][0] = grid[0][0];
        int[][] dirs = new int[][]{{1,0},{0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {grid[0][0], 0, 0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int acc = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            for(int[] dir : dirs){
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX >= m || newY >= n) continue;
                if(acc+grid[newX][newY] < matrix[newX][newY]){
                    q.offer(new int[] {acc+grid[newX][newY], newX, newY});
                    matrix[newX][newY] = acc+grid[newX][newY];
                }
            }
        }
        
        return matrix[m-1][n-1] == Integer.MAX_VALUE ? 0 : matrix[m-1][n-1];
    }
    
    
    
    //<Trial02>
    
    //recursive - dfs
    
    //25 / 61 test cases passed.
    //Status: Time Limit Exceeded
    
    //����ȭ �Ϸ��� minimum cost�� �� ���ַ� ���ƾ� �ϴµ�, ���� �׷��� ¥��,
    
    //A ���� ó���� minimum cost�ٰ� �Ĺݰ��� cost�� ��û �������µ�,
    
    //B ���� ó���� cost�� ���ٰ� �Ĺݰ��� cost�� �������� B���� ���ؾ� �ϴ� ��� �����ٵ�..
    
    public int recursive(int[][] grid, int[][] matrix, int m, int n, int prev){
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        matrix[m][n] = Math.min(matrix[m][n], grid[m][n] + prev); 
        if(m == 0 && n == 0) return matrix[m][n];
        return Math.min(recursive(grid, matrix, m-1, n, matrix[m][n]), recursive(grid, matrix, m, n-1, matrix[m][n]));
    }
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        for(int[] row : matrix){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return recursive(grid, matrix, m-1, n-1, 0);
    }
    
    
    //<����Ǯ��2 by JayOMG>
    
    //dp
    
    //�ϴ� coord(0,0)���� �� ����, m,n�� 0�϶� ���� ���� 1�ڷ� �y�y�y ���� �Ѱ��ְ�
    
    //m,n�� 0�� �ƴ� ��, �ش� ��ǥ���� ���� ��ĭ�� ���� ��ĭ�� �� �� �� ���� �ֵ��� ��� �y�y�y �Ѱ���
    
    //�ڼ��� ����, Math.min(gridSum(grids, m-1, n), gridSum(grids, m, n-1)); ����
    
    //gridSum(grids, m-1, n)���� recursive�� ��~�� ��.
    
    //���� ���� �ö�.
    
    //�׷��ٰ� m==0�� �Ǹ�, if(m==0)�� �ɷ�, ���� �������� ��.
    
    //coord(0,0)���� ���������� ������� ä���,
    
    //��ĭ �����ͼ� �� ������ ���� ��ܺ��� ���������� ������� ä���, �̷��� ��.
    
	//0 0 0 
	//0 0 0 
	//0 0 0 
	
	//0 0 0 
	//0 0 0 
	//0 0 0 
	
	//0 4 0 
	//0 0 0 
	//0 0 0 
	
	//0 4 5 
	//0 0 0 
	//0 0 0 
	
	//0 4 5 
	//0 0 0 
	//0 0 0 
	
	//0 4 5 
	//2 0 0 
	//0 0 0 
	
	//0 4 5 
	//2 7 6 
	//0 0 0 
	
	//0 4 5 
	//2 7 6 
	//6 0 0 
    
    //�� iterate���� Trial02ó�� if(m < 0 || n < 0) �� if(m == 0 && n == 0)���� �ʿ� ���� ������, �ӵ��� ����.
    
    //trial02��, coord(x,y)�� matrix�� �߾Ӻο� �־ �����̶� �� �Ѵ� ���ߵǴ���, �ƴϸ� ���� ���� �پ��־ ������ �����ϴ���, �ƴϸ� ���� ���� �پ��־ ���ʿ��� �����ϴ���, �ƴϸ�
    
    //x,y�� �ϳ��� ���� -1�̶� ���� �ȵǴ���, �ƴϸ� x,y�� 0,0�̶� ���� ��ȯ�ؾ��ϴ��� ��� ����Ǽ��� �� iterate���� �Ǵ��ؾ� �߱� ������ ������ ���ȴµ�,
    
    //�� ���� ��쿣, �ϴ� ���� ���, ��ĭ Ȯ���� �ֵ� ������� ä�� ����, �� �����ٿ� �ֵ� ä�� �� grids[m][n] + gridSum(grids, m, n-1); ���� 
    
    //gridSum(grids, m, n-1); ��, trial02ó�� ����� ���� ���� �ʰ�, �� �ϳ��� ������
    
    //if (mem[m][n] != 0) return mem[m][n]; �̰ɷ� ������.
    
    //�׷��� ������ ����.
    
    //Runtime: 1 ms, faster than 98.72% of Java online submissions for Minimum Path Sum.
    //Memory Usage: 41.7 MB, less than 49.50% of Java online submissions for Minimum Path Sum.
    
    private int[][] mem;
    public int minPathSum(int[][] grids) {
        int m = grids.length, n = grids[0].length;
        mem = new int[m][n];
        return gridSum(grids, m-1, n-1);
    }
    
    private int gridSum(int[][] grids, int m, int n) {
        if (m == 0 && n == 0) return grids[m][n];
        if (mem[m][n] != 0) return mem[m][n];
        if (m == 0) {
            mem[m][n] = grids[m][n] + gridSum(grids, m, n-1);
            return mem[m][n];
        }
        if (n == 0){
            mem[m][n] = grids[m][n] + gridSum(grids, m-1, n);
            return mem[m][n];
        }
        mem[m][n] = grids[m][n] + Math.min(gridSum(grids, m-1, n), gridSum(grids, m, n-1));
        return mem[m][n];
    }
}
