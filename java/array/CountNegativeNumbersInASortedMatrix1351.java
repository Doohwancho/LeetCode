package array;

import java.util.Arrays;

public class CountNegativeNumbersInASortedMatrix1351 {
	
	/*
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 1 ms, faster than 62.06% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	//Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	public int countNegatives(int[][] grid) {
        int rst = 0;
        
        for(int[] row : grid){
            for(int element : row){
                if(element < 0){
                    rst++;
                }
            }
        }
        
        return rst;
    }
	*/
	
	/*
	//<����Ǯ��2>
	
	//�� �ȼ��� ��
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	//Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	
    public int countNegatives(int[][] grid) {
        int rst = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    rst += (grid[i].length - j);
                    break;
                }
            }    
        }
        
        return rst;
    }
    */
    
	/*
    //<����Ǯ��3 by ManualP>
    
    //�����͸� ���� Ǯ��
    
    //Arrays.deepToString(grid);�� �ϸ� �̷��� ����.
	//String������ "[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]"
    
    //�װ� .split("-")�ϸ� �Ʒ����� 9���� �ɰ���
    
	//[[4, 3, 2, 
	//1], [3, 2, 1, 
	//1], [1, 1, 
	//1, 
	//2], [
	//1, 
	//1, 
	//2, 
	//3]]
	
	//���� ���ɵ� ������
	
	//Runtime: 9 ms, faster than 5.53% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	//Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    
    public int countNegatives(int[][] grid) {
        return Arrays.deepToString(grid).split("-").length - 1;
    }
    */
	
	//<����Ǯ��4 by myCafeBabe>
	
	//binary search
	
	//increasing order �ݴ� ������ ��·�� ���ĵ������ϱ� ������ �̿��� Ǯ��.
	
	//sample size�� �����ȵǰ� ũ�ٰ� �� ��, ���� ������ ���� Ǯ��.
	
	//���� Ǯ�� ���̳ʽ��� ���� �̸� ans += (rows - i) * cols; �� ���س���,
	
	//�� ���ٵ� �������� for������ �������� ���鼭 binary search �̿��Ͽ� mid(���̳ʽ�)�� �κ��� ã�� ��
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
	//Memory Usage: 41.2 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int bound = rows;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] < 0) {
                ans += (rows - i) * cols;
                bound = i;
                break;
            }
        }
        for (int i = 0; i < bound; i++) {
            ans += cols - binarySearch(grid[i]);
        }
        return ans;
    }
    
    public int binarySearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2; //(high+low)/2�� ����. high+low�� Integer.MAX_VALUE�Ѿ��� �̷��� �ٲ㼭 �� ��.
            if (arr[mid] >= 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (arr[low] < 0) {
            return low;
        }
        if (arr[high] < 0) {
            return high;
        }
        return arr.length;
    }
    
	
}
