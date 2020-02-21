package array;

public class SpiralMatrixII59 {
	
	/*
	//<Trial01>
	
	//dfs
	
	//�߰��ٰ� 11���� ��ȸ���ؼ� ����
	
	//1 2 3 4 
	//0 0 0 5 
	//11 12 0 6 
	//10 9 8 7 
	
	public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int[] coord = new int[2];
        
        for(int i = 1; i < n*n+1; i++){
            
            rst[coord[0]][coord[1]] = i;
            if(coord[1] < n-1 && rst[coord[0]][coord[1]+1] == 0){
                coord[1]++;
            }
            else if(coord[0] < n-1 && rst[coord[0]+1][coord[1]] == 0){
                coord[0]++;
            }
            else if(coord[1] > 0 && rst[coord[0]][coord[1]-1] == 0){
                coord[1]--;
            }
            else if(coord[0] > 0 && rst[coord[0]-1][coord[1]] == 0){
                coord[0]--;
            }
        }
        return rst;
    }
    */
	
	
	//<����Ǯ��1>
	
	//dfs
	
	//Ư������ ���������� ���� �κ��� ������ (i < n || (coord[0] > 0 && rst[coord[0]-1][coord[1]] != 0))
	
	//�ڲ� 11���� 12�Ѿ�� �����淡
	
	//1 2 3 4 
	//0 0 0 5 
	//11 12 0 6 
	//10 9 8 7
	
	//�ش� ��ǥ�� �ٷ� ���� ���� 0�� �ƴ� ���� ä������ �ʾҴٸ�, ���������� ������ �ٲ��� ����°� �̺κ� (coord[0] > 0 && rst[coord[0]-1][coord[1]] != 0)
	
	//i < n �̺κ��� �� ù�ٺ��� (coord[0] > 0 && rst[coord[0]-1][coord[1]] != 0)
	
	//�̰� ������ ������ �ȵǼ� �� ù�ٸ� ���������� �� ������ ������ ��
	
	//�̰���
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
	//Memory Usage: 37.3 MB, less than 8.33% of Java online submissions for Spiral Matrix II.
	
	public int[][] generateMatrix(int n) {
		int[][] rst = new int[n][n];
        int[] coord = new int[2];

        for(int i = 1; i < n*n+1; i++){
            rst[coord[0]][coord[1]] = i; 
            
            if((i < n || (coord[0] > 0 && rst[coord[0]-1][coord[1]] != 0)) && coord[1] < n-1 && rst[coord[0]][coord[1]+1] == 0){
                coord[1]++;
            }
            else if(coord[0] < n-1 && rst[coord[0]+1][coord[1]] == 0){
                coord[0]++;
            }
            else if(coord[1] > 0 && rst[coord[0]][coord[1]-1] == 0){
                coord[1]--;
            }
            else if(coord[0] > 0 && rst[coord[0]-1][coord[1]] == 0){
                coord[0]--;
            }
        }
        return rst;
    }
}
