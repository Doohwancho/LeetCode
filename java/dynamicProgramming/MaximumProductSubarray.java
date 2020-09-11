package september;

public class MaximumProductSubarray {
	
	//<Trial01 - Memory Limit Exceeded>
	
	//2���� �迭�� 1�������� ���̸� �ǰڳ�?
	
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] matrix = new int[n][n];
        int rst = Integer.MIN_VALUE;
        
        for(int p = 0; p < n; p++){
            matrix[p][p] = nums[p];
            rst = Math.max(rst, nums[p]);
        }
        
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                matrix[i][j] = matrix[i][j-1] * nums[j];
                rst = Math.max(rst, matrix[i][j]);
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��1>
    
    //brute-force
    
    //O((N^2)/2)
    
    //Runtime: 230 ms
    //Memory Usage: 39.2 MB
    
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] matrix = new int[n];
        int rst = matrix[0] = nums[0];
        
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                matrix[j] = matrix[j-1] * nums[j];
                rst = Math.max(rst, matrix[j]);
            }
            if(i+1 < n){
                matrix[i+1] = nums[i+1];
                rst = Math.max(rst, matrix[i+1]);
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by lee215>
    
    //�е����� �������̳� ������
    
    //�ϴ� A�� ���ڰ� ��� �����, �� ���Ѱ��� ��ȯ�ϸ� ��.
    
    //���� iterate�ϴٰ� 0�� ������, 0�̳����� �����ϰ� �����ź��� �ٽ� �������� ������
    
    //Q. ���� [-1,2,2,2, ...]��, l�� ���̳ʽ����� ���ϴϱ� �ȵǴ°� �Ƴ�?
    
    //�׷��� r�� �����ʿ������� �� ���ϸ鼭 ���ͼ� ������.
    
    //Q. �׷� [-1,2,2,2,-1]�� ��¿����? l�� ���̳ʽ����� ���ϰ� r�� ���̳ʽ����� �����ݾ�?
    
    //���̳ʽ��� �ΰ��� �÷��� �Ǵϱ� ������
    
    //Q. �׷� [-1,2,2,2,-1,2,2,-1]��?
    
    //�糡�ܿ� ���̳ʽ��� ����, �߰��� ���̳ʽ��� Ȧ���� ���´ٸ�,  Ȧ���� �������� ���ʿ� �� ū �������� l�̰�, ������ �� ū �������� r�̴ϱ�,
    
    //Math.max(l,r)�ϸ� ��.
    
    //�糡�ȿ� ���̳ʽ��� ����, �߰��� ���̳ʽ��� ¦���� ���´ٸ�, ���̳ʽ��� ¦���� ���ϸ� ��¥�� �÷����ϱ� �� �����ָ� ��.
    
    //�Ӹ� ������ �� �� ��������
    
    //Runtime: 1 ms
    //Memory Usage: 39.3 MB
    
    public int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
