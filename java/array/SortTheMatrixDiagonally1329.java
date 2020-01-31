package array;

public class SortTheMatrixDiagonally1329 {
	
	//<����Ǯ��1>
	
	//Runtime: 2 ms, faster than 98.22% of Java online submissions for Sort the Matrix Diagonally.
	//Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Sort the Matrix Diagonally.
	private static void diagnal(int[][] mat, int i, int j){
        int[] container = new int[101]; //mat�� �����ϴ� ���ڰ� 0���� 100�����ϱ� 101�� �������� ����Ʈ ����
        int i_ = i;
        int j_ = j;
        while(i_ < mat.length && j_ < mat[0].length){ //����Ʈ�� ������ ������ ����
            container[mat[i_++][j_++]]++;
        }
        while(i < mat.length && j < mat[0].length){ //mat�� ���鼭 ����Ʈ�� ������ִ� ���� ���ʴ�� ����
            for(int k = 0; k < 101; k++){
                if(container[k] > 0){
                    mat[i++][j++] = k;
                    container[k]--;
                    break;
                }
            }
        }
    }
    
    public static int[][] diagonalSort(int[][] mat) {
    	//for���� if-else���� ������ �밢�� ���� ��, ó�� �����ϴ� ���� ����Ŵ.
        for(int i = mat.length-1; i >= 0; i--){
            if(i == 0){
            	//�� ���� ������ �� �������� ���� ���� ����
                for(int j = 0; j < mat[0].length; j++){
                    diagnal(mat, i, j);  //������ �밢���� ���������� ����Ͽ� �������� ���Ľ�Ű�� diagnal()�Լ� ���
                }
            } else {
            	//ó���� �� ���� �����ٸ�
                diagnal(mat, i, 0);
            }
        }
        return mat;
    }
    
    public static void main(String[] args) {
		int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		diagonalSort(mat);
		for(int[] row : mat) {
			for(int ele : row) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}
}
