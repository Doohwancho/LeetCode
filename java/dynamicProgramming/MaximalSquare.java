package thirtyDayChallenge;

public class MaximalSquare {
	

	/*
	
	//<����Ǯ�� 1>

	
//	[["0","0","0","1"],
//	 ["1","1","0","1"],
//	 ["1","1","1","1"],
//	 ["0","1","1","1"],
//	 ["0","1","1","1"]]
			 
	// 0 0 0 1 
	// 1 1 0 1 
	// 1 2 1 1 
	// 0 1 1 2 
	// 0 1 2 2 
	
	//���簢���� �� ���� ���̰� 1->2->3 ���������� �þ�ϱ�, �Ѻ��� �ִ���̸� ���ϰ�, �� �������� �� �����Ҷ� ���Ǳ��� * ���Ǳ��̸� ���ָ� �ȴ�.
	
	//�� ���� ���̸� Ȯ���Ϸ���, [i-1][j-1]�� 0���� ū�� Ȯ���� ����, 0���� ũ�ٸ�, ���簢���� �Ǵ� �����߿� �ϳ��� �ϴ� ���� �� �������� ������ �Ʒ� �������� �ִٴ� ���ϱ�, 
	
	//���μ��ΰ� ����ִ��� Ȯ�����ش�.
	
	//���� �غ��� ������ ���κ��� �� ä���� �ִٸ�, matrix[i][j] = matrix[i-1][j-1]�� ���ش�.
	
	//�̷��� ���ָ�, ���� �Ʒ�ó�� ���� matrix��
	
	//111
	//111
	//111
	
	//�Ʒ�ó�� ���Ѵ�.
	
	//111
	//122
	//123
	
	//�׷� ���� ū ���� ������ 3*3�� ������ �ָ� �ȴ�.
	
	//�׷��� ������, 
	 
	// 1 1 0 0 
	// 1 1 1 1 
	// 0 1 1 1 
	// 0 1 1 1
	
	//�̰Ŵ�.
	
	// 1 1 0 0 
	// 1 2 1 1 
	// 0 1 1 1 
	// 0 1 1 1
	
	//�������� �׷����� �ϴµ�, 
	
	// 1 1 0 0 
	// 1 2 1 1 
	// 0 1 ? 1 
	// 0 1 1 1
	
	//?ǥ �κп��� �غ��� ���κ��� ��� 1�� ä������ �ʾұ� ������ ������ ����µ�, �̷��� ��츦 �����
	
	//�غ��� t1, ���κ��� t2�� ó���� �غ��� ���κ��� [i-1][j-1]�� ��ŭ �� ä������ �ʾҴ���, �ִ��� ä���� ��ŭ�� [i][j]�� ������Ʈ �����ش�.
	
	//69 / 69 test cases passed.
	//Status: Accepted
	//Runtime: 3 ms
	//Memory Usage: 43 MB
	
	
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int rst = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]-48 == 1){
                    rst = Math.max(rst, 1);
                    if(i>0 && j > 0 && matrix[i-1][j-1]-48 > 0){
                        int limit = matrix[i-1][j-1]-48;
                        int t1 = 0;
                        int t2 = 0;
                        boolean flag = false;
                        for(int p = i-1; p >= i-limit; p--){
                            if(matrix[p][j]-48==0){
                                flag = true;
                                break;
                            }else {
                            	t1++;
                            }
                        }
                        for(int q = j-1; q >= j-limit; q--){
                            if(matrix[i][q]-48==0){
                                flag = true;
                                break;
                            } else {
                            	t2++;
                            }
                        }
                        if(flag) {
                        	if(Math.min(t1, t2) > 0) {
                        		matrix[i][j] = Character.forDigit(Math.min(t1, t2)+1,10);
                        	}
                        } else {
                        	matrix[i][j] = (char)(matrix[i-1][j-1]+1);
                        }
                        
                        rst = Math.max(rst, matrix[i][j]-48);
                    }
                }
            }
        }
        
        return rst * rst;
    }
    */
	
	//<����Ǯ��2 by earlme>
	
	//�� ������ſ���
	
	//[i][j]�� ���簢���� �Ǵ� 1�̸�, ��, ��,�밢���� [i-1][j-1],[i-1][j],[i][j-1] �µ��߿� �� ������+1�� �����ָ� ���ݾ�.
	
	//111
	//111
	//111
	
	//��, 
	
	//0000
	//0111
	//0111
	//0111
	
	//�� ������ �� ������ �� ������ ������
	
	//0000
	//0111
	//0122
	//0123 
	
	//�� ���ݾ�. ����Ǯ��1���� �����ߴ� �� testcase��, �� ������� �ϸ�,
	
	// 1 1 0 0 
	// 1 1 1 1 
	// 0 1 1 1 
	// 0 1 1 1
	
	//��� �̷��� ����
	
	// 1 1 0 0 
	// 1 2 1 1 
	// 0 1 '2' 2 
	// 0 1 2 3
	
	//'2'�� �κ��� �ٽ��ε�, �غ��� ���κ��� �� �����ִٴ°� �̹� [i-1][j]�� [i][j-1]���� �ľ��س��ڳ�~
	
	public static int maximalSquare(char[][] a) {
	    if(a.length == 0) return 0;
	    int m = a.length, n = a[0].length, result = 0;
	    int[][] b = new int[m+1][n+1];
	    for (int i = 1 ; i <= m; i++) {
	        for (int j = 1; j <= n; j++) {
	            if(a[i-1][j-1] == '1') {
	                b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
	                result = Math.max(b[i][j], result); // update result
	            }
	        }
	    }
	    return result*result;
	}
    
    
	public static void main(String[] args) {
//		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//		char[][] matrix = {{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};	
		char[][] matrix = {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
				
		System.out.println(maximalSquare(matrix));
	}
}