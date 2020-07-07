package julyChallenge;

public class IslandPerimeter {
	
	
	//<Trial01.
	
	//Input:
//	[[0,1,0,0],
//	 [1,1,1,0],
//	 [0,1,0,0],
//	 [1,1,0,0]]

//	Output: 16
	
	//�̷��� ���� ��ĭ�� �پ��ִ°� �� �������µ�,
	
	//[1,1]
	//[1,1]
	
	//���� ��ĭ�̻� ���ڵ��� �پ��ִ°� �ȵǳ�

    private int helper(int[][] grid, int i, int j, boolean flag){
        grid[i][j] = 2;
        
        int four = flag ? 3 : 4;
        int adder = 0;
        
        if(i < grid.length-1 && grid[i+1][j] == 1){
            four--;
            adder += helper(grid, i+1, j, true);
        }
        if(j < grid[0].length-1 && grid[i][j+1] == 1){
            four--;
            adder += helper(grid, i, j+1, true);
        }
        if(i > 0 && grid[i-1][j] == 1){
            four--;
            adder += helper(grid, i-1, j, true);
        }
        if(j > 0 && grid[i][j-1] == 1){
            four--;
            adder += helper(grid, i, j-1, true);
        }
        System.out.println("i: "+i+" j: "+j+" four: "+four+" adder: "+adder);
        return four + adder;
    }
    
    public int islandPerimeter(int[][] grid) {
        int rst = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    rst = Math.max(rst, helper(grid, i, j, false)); 
                }
            }
        }
        return rst;
    }
    
    
    
    
    //<����Ǯ��1>
    
    //dfs
    
    //four+adder��ȯ�ϱ� ����, 4�������� ĭ�� üũ�Ǿ������� four�� �ϳ��� ��� ������� �ٲ㼭
    
    //���ư��Դ� ������µ�, �� ������� ����� �ƴϳ�
    
    //time: O(mn) �ƴѰ�? 
    //space: O(mn) 
    
    //Runtime: 11 ms
    //Memory Usage: 58.3 MB
    
    
    private int helper(int[][] grid, int i, int j){
        grid[i][j] = 2;
        
        int four = 4;
        int adder = 0;
        
        if(i < grid.length-1 && grid[i+1][j] == 1){
            adder += helper(grid, i+1, j);
        }
        if(j < grid[0].length-1 && grid[i][j+1] == 1){
            adder += helper(grid, i, j+1);
        }
        if(i > 0 && grid[i-1][j] == 1){
            adder += helper(grid, i-1, j);
        }
        if(j > 0 && grid[i][j-1] == 1){
            adder += helper(grid, i, j-1);
        }
        
        if(i < grid.length-1 && grid[i+1][j] > 0){
            four--;
        }
        if(j < grid[0].length-1 && grid[i][j+1] > 0){
            four--;
        }
        if(i > 0 && grid[i-1][j] > 0){
            four--;
        }
        if(j > 0 && grid[i][j-1] > 0){
            four--;
        }
        
        return four + adder;
    }
    
    public int islandPerimeter(int[][] grid) {
        int rst = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    rst = Math.max(rst, helper(grid, i, j)); 
                }
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by diaa>
    
    //�� �Ⱥپ��������� +1��
    
    //�������� ���
    
    //Runtime: 8 ms
    //Memory Usage: 58.4 MB
    
    public int islandPerimeter(int[][] grid) {
    	if(grid == null || grid.length == 0|| grid[0].length == 0)
    		return 0;
    	int perimeter = 0;
    	int n = grid.length;
    	int m = grid[0].length;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(grid[i][j] == 1) {
        			if(i == 0 || grid[i - 1][j] == 0)
        				perimeter++;
        			if(i == n -1 || grid[i + 1][j] == 0)
        				perimeter++;
        			if(j == 0 || grid[i][j - 1] == 0)
        				perimeter++;
        			if(j == m - 1|| grid[i][j + 1] == 0)
        				perimeter ++;
        		}
        	}
        }
        return perimeter;
    }
    
    
    //<����Ǯ��3 by LHearen>
    
    //���� �̻����� ���
    
    //�� 4������ ������ �³����� ��� �پ��ִ����� �˸� ���ݾ�?
    
    //��� �پ��ִ����� 2��for�� ���鼭 �ٷ� �����ʾֶ� �ٷ� �ؾ־ָ� �پ��ִ��� ��
    
    //��¥�� 2�� for���� ���� ������ ������ �Ʒ��������� ���ϱ�.
    
    //Runtime: 7 ms
    //Memory Usage: 58 MB
    
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int R = grid.length, C = grid[0].length;
        int cellCount = 0, neighborCount = 0;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 1) {
                    cellCount++;
                    // right, down
                    if (c < C-1 && grid[r][c+1] == 1) neighborCount++;
                    if (r < R-1 && grid[r+1][c] == 1) neighborCount++;
                }
            }
        }
        return cellCount * 4 - neighborCount * 2;
    }
}
