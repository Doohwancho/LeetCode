package dynamicProgramming;

import java.util.Arrays;

public class Triangle {
	
	//Q. �Ʒ��� �����ʸ� �� �� ����. (0,0)���� (4,4)���� ���� ��, ������ ��� ��, �ִ����� ��ȯ�϶�.
	
	static int[][] triangle = {
		{6,0,0,0,0},
		{1,2,0,0,0},
		{3,7,4,0,0},
		{9,4,1,7,0},
		{2,7,5,9,4}
	};
	static int cnt = 0;
	
	
	//1. Backtracking
	
	//ans:48
	//loops:363
	
//	private static int search(int i, int j) {
//		if(i == triangle.length || j == triangle[0].length) return 0;
//		if(i == triangle.length-1 && j == triangle[0].length-1) return triangle[i][j];
//		return triangle[i][j] + Math.max(search(i+1,j), search(i, j+1));
//	}
	
	
	//2. Backtracking + Memoization
	
	//ans:48
	//loops:49
	
//	static int[][] visited = new int[5][5];
//	
//	private static int search(int i, int j) {
//		if(i == triangle.length || j == triangle[0].length) return 0;
//		if(visited[i][j] != 0) return visited[i][j];
//		if(i == triangle.length-1 && j == triangle[0].length-1) return triangle[i][j];
//		visited[i][j] = triangle[i][j] + Math.max(search(i+1,j), search(i, j+1));
//		return visited[i][j];
//	}
	
	
	
	//3. Backtracking + Memoization + Optimization
	
	//ans:48
	//loops:29
	
//	static int[][] visited = new int[5][5];
//	
//	private static int search(int i, int j) {
//		if(i == triangle.length || j > i) return 0;
//		if(visited[i][j] != 0) return visited[i][j];
//		if(i == triangle.length-1 && j == triangle[0].length-1) return triangle[i][j];
//		visited[i][j] = triangle[i][j] + Math.max(search(i+1,j), search(i, j+1));
//		return visited[i][j];
//	}
	
	
	
	
	
	//Q. �Ʒ��� �����ʾƷ��� �� �� ������?
	
	//1. ������ �������� �������ٰ�, ������ ������ �ٽ� ��ͷ� ó������ ���ƿ� ��ȯ�ϴ� ���
	
	//��������: mem[0][0] = triangle[0][0];
	
	//ans:28
	//loop:31
	
	
//	static int[][] mem = new int[5][5];
//	
//	private static int search(int y, int x) {
//		if(y == triangle.length-1) return mem[y][x];
//		mem[y+1][x] = Math.max(mem[y+1][x], mem[y][x] + triangle[y+1][x]);
//		mem[y+1][x+1] = Math.max(mem[y+1][x+1], mem[y][x] + triangle[y+1][x+1]);
//		return Math.max(search(y+1, x), search(y+1, x+1));
//	}
	
	
	//2. Memoization + Optimization
	
	//ans:28
	//loop:21
	
	//���� �Ʒ����� �ﰢ������ ������ ���������� ��
	
	//28 0 0 0 0 
	//20 22 0 0 0 
	//19 18 20 0 0 
	//16 11 10 16 0 
	//0 0 0 0 0
	
	//���⼭ ����, ��ġ�� ������, �Ʒ����� 16,11,10,19,18,20 �� 6����.
	
	//�׷��� �ּҷ� ���ƾ� �ϴ� �� 15(1+2+3+4+5)�� ��ġ�� �κ� 6���� �ؼ� �� 21����.
	
	//1������ �ٸ���, Math.max()�� �Ź� ��ġ�� �κ� ���ؾ� �ϴ°� ����.
	
	static int[][] mem = new int[5][5];
	
	private static int search(int y, int x) {
		if(y == triangle.length-1) return triangle[y][x];
		if(mem[y][x] != 0) return mem[y][x];
		return mem[y][x] = Math.max(search(y+1, x), search(y+1,x+1)) + triangle[y][x];
	}
	
	
	public static void main(String[] args) {
		//�޸������̼��� ���� -1�� �ʱ�ȭ ����� �Ѵ�.
//		for(int[] row : visited) {
//			Arrays.fill(row, -1);
//		}
//		
		System.out.println(search(0, 0)); 
		System.out.println(cnt);
	}
}
