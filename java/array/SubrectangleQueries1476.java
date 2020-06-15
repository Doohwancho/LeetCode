package array;

public class SubrectangleQueries1476 {

	//<����Ǯ��1>
	
	//��-��
	
	//Runtime: 46 ms, faster than 55.32% of Java online submissions for Subrectangle Queries.
	//Memory Usage: 52.1 MB, less than 50.00% of Java online submissions for Subrectangle Queries.
	class SubrectangleQueries {
	    int[][] r;
	    
	    public SubrectangleQueries(int[][] rectangle) {
	        r = rectangle;    
	    }
	    
	    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
	        for(int i = row1; i <= row2; i++){
	            for(int j = col1; j <= col2; j++){
	                r[i][j] = newValue;
	            }
	        }
	    }
	    
	    public int getValue(int row, int col) {
	        return r[row][col];
	    }
	}
	
	//<����Ǯ��2 by rock>
	
	//�� �Ź��� ���
	
	//update�� r�� �ڴ°� �ƴ϶� linkedlist�� �ھƳ���
	
	//get�� linkedlist���� ������Ʈ �Ѿֵ��߿� �ֳ� ���� ����, ���ٸ� �ѹ��� �Ȱǵ� �� �������� �ֶ�� ���̴ϱ�, r[row][col]��ȯ��
	
	//update�� ��� �Ͼ�Ŀ� ���� �ٸ�������, update����� Ŭ���� �� ����� �� ������
	
	//Runtime: 35 ms, faster than 75.88% of Java online submissions for Subrectangle Queries.
	//Memory Usage: 52.9 MB, less than 50.00% of Java online submissions for Subrectangle Queries.
	
	class SubrectangleQueries {
	    private final int[][] r;
	    private final LinkedList<int[]> histories = new LinkedList<>();
	    
	    public SubrectangleQueries(int[][] rectangle) {
	        r = rectangle;
	    }
	    
	    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
	        histories.push(new int[]{row1, col1, row2, col2, newValue});
	    }
	    
	    public int getValue(int row, int col) {
	        for (int[] his: histories) {
	            if (his[0] <= row && row <= his[2] && his[1] <= col && col <= his[3]) {
	                return his[4];
	            }
	        }
	        return r[row][col];
	    }
	}
}
