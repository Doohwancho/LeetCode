package julyChallenge;

public class PlusOne {

	//<����Ǯ��1>
	
	//�� �ǵڿ������� 1�� ������
	
	//�ٵ� 1���ߴµ� 10�Ǹ� �� ���� ���ڷ� �Ѿ
	
	//�׷��� ������ ��.
	
	//[9,9,9]
	
	//�ٵ� �̰� 1000�ǾߵǴµ� ������ ���� [0,0,0]���ݾ�
	
	//�׷��� int[4]����� �տ� 1�ٿ���.
	
	//time: O(n)
	//space: O(n)
	
	//Runtime: 1 ms
	//Memory Usage: 39.3 MB
	
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i]+1 > 9){
                digits[i] = 0;
                if(i == 0){
                    int[] rst = new int[digits.length+1];
                    rst[0] = 1;
                    for(int p = 1; p < rst.length; p++){
                        rst[p] = digits[p-1];
                    }
                    return rst;
                }
            } else {
                digits[i]++;
                return digits;
            }
        }
        return digits;
    }
    
    
    //<����Ǯ��2 by caikehe>
    
    //�����غ��ϱ�
    
    //[1,0,0,0]�� 
    
    //int[] rst = new int[4]
    //rst[0] = 1 
    //�̶� ���ݾ�?
    
    //���� �����ϳ�
    
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return 
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }
}
