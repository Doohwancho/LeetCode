package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

	//<����Ǯ��1 by motorix>
	
	//1) ���� �丶���� ��ǥ�� ����
	
	//2) ���� �丶�� ��ǥ �����¿� ��������, 1(�ż��� �丶��)�̸� 2(���� �丶��)�� �ٲ�. ������ ��� ������ rst+1;
	
	//3) �� ���� ��, �ż��� �丶�䰡 �ϳ��� ���������� return -1;
	
	//Runtime: 3 ms, faster than 68.54% of Java online submissions for Rotting Oranges.
	//Memory Usage: 38.2 MB, less than 5.42% of Java online submissions for Rotting Oranges.
	
    public static int orangesRotting(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        int rst = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0){
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] == 0 || matrix[r][c] == 2) { 
                        continue;
                    }
                    queue.add(new int[] {r, c});
                    matrix[r][c] = 2;
                }
            }
            if(queue.size() > 0) rst++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    return -1;
                }
            }
        }
        return rst;
    }
    
    public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		
		int[] r1 = new int[3];
		int[] r2 = new int[3];
		int[] r3 = new int[3];

		r1[0] = 2;
		r1[1] = 1;
		r1[2] = 2;

		r2[0] = 0;
		r2[1] = 0;
		r2[2] = 0;

		r3[0] = 0;
		r3[1] = 0;
		r3[2] = 0;

		matrix[0] = r1;
		matrix[1] = r2;
		matrix[2] = r3;
		
		System.out.println(orangesRotting(matrix));
	}
}
