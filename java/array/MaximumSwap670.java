package array;

public class MaximumSwap670 {
	
	
	
	//<����Ǯ��1>
	
	//�̸�����
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Swap.
	//Memory Usage: 36.1 MB, less than 25.00% of Java online submissions for Maximum Swap.
	public static int maximumSwap(int num) {
    	int[] n = new int[8];
        int originalNum = num;
    	int idx = 7;
    	boolean flag = false;
    	
        while(num!=0) {
        	int num_ = num%10;
        	num /= 10;
        	n[idx--] = num_;
        }
        int originalIdx = idx+1;
        int idx_ = 6-idx;

        
        for(int i = idx+1; i < 7; i++) {
            int maxVal = 0;
            int j_ = i+1;
            boolean flag2 = false;
            
        	for(int j = i+1; j < 8; j++) {
        		if(n[j] >= maxVal && n[j] > n[i]) { //135���� ��쿡, 3�� ���������� 1���� ũ�ٰ� �ٷ� �ٲ������ 315�� ��ȯ���ݴ�. �ٵ� swap�� ���� ū���� 531���ܴ�. ������ ���� ���ܴ�. �׷��� maxVal�� �ڿ����߿� �� ū�� �̴°��ܴ�.
                    maxVal = n[j];
                    j_ = j;
                    flag2 = true;
        		}
        	}
            if(flag2){
                swap(n, i, j_);
                int rst = 0;
                while(idx_ >= 0) {
                    rst += n[originalIdx++] * (int)Math.pow(10, idx_--);
                }
                return rst;
            }
        }
        return originalNum;
    }
    
    private static void swap(int[] n, int i, int j) {
    	int tmp1 = n[i];
    	int tmp2 = n[j];
    	n[i] = tmp2;
    	n[j] = tmp1;
    }

}
