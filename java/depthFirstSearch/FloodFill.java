package mayChallenge;

public class FloodFill {
	
	//<����Ǯ��1>
	
	//dfs
	
	//�� ó�� ������ �� newColor�� ��ũ ���ְ�,
	
	//������������ ��ĭ�� ���鼭 newColor�� ��ũ����
	
	//org������ ���� �;��µ� ��ũ�Ȱ�(1�̵� �ٸ� � �����)�̶� 0�̶� �������� �ʿ䰡 �ְڴ� �; ����.
	
	//Runtime: 2 ms
	//Memory Usage: 45.3 MB
	
    private int[][] dfs(int[][] image, int sr, int sc, int newColor, int org){
        image[sr][sc] = newColor;
        if(sr > 0 && image[sr-1][sc] == org) dfs(image, sr-1, sc, newColor, org);
        if(sr < image.length-1 && image[sr+1][sc] == org) dfs(image, sr+1, sc, newColor, org);
        if(sc > 0 && image[sr][sc-1] == org) dfs(image, sr, sc-1, newColor, org);
        if(sc < image[0].length-1 && image[sr][sc+1] == org) dfs(image, sr, sc+1, newColor, org);
        return image;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         if(image[sr][sc] == newColor) return image;
         return dfs(image, sr, sc, newColor, image[sr][sc]);
    }
    
    //<����Ǯ��2 by shawngao>
    
    //����Ǯ��1�� ��������ε�, �̰� ���⿡ �� �����. �Ǿ� if������ �� ������.
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
    
    
    //<����Ǯ��3 by fishercoder>
    
    //bfs
    
    //�̰͵� ��ĭ�� �̵��ؼ� newColor�� ��ŷ�Ѵٴ� ������ ������
    
    //int[] directions = new int[]{0, 1, 0, -1, 0};
    
    //���� �س���
    
	//for (int i = 0; i < directions.length - 1; i++) {
	//    int nextR = curr[0] + directions[i];
	//    int nextC = curr[1] + directions[i + 1];
    //}
    
    //�̷��� (0,1),(1,0),(0,-1),(-1,0) �̷��� ���°� �� �����ϳ�

	//Runtime: 2 ms
	//Memory Usage: 40.2 MB
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] directions = new int[]{0, 1, 0, -1, 0};
        int m = image.length;
        int n = image[0].length;
        int originalValue = image[sr][sc];
        image[sr][sc] = newColor;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            for (int i = 0; i < directions.length - 1; i++) {
                int nextR = curr[0] + directions[i];
                int nextC = curr[1] + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || image[nextR][nextC] != originalValue || visited[nextR][nextC]) {
                    continue;
                }
                image[nextR][nextC] = newColor;
                queue.offer(new int[]{nextR, nextC});
            }
        }
        return image;
    }
}
