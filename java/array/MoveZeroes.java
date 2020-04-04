package thirtyDayChallenge;

public class MoveZeroes {
	
	
	/*
	//<����Ǯ��1>
	
    //[0,1,0,0,2,3,4,5] �̰�
    
    //[1,2,3,4,5,0,0,0] �̷��� ������ ���ݾ�?
	
	//���� if(i < nums.length-totalZeros) �� �� ������, �ε��� 0���� ��ü arr����-�� 0�� �������� ���ڰ� �޷�� ������(�� ��쿣 8 - 3 = 5����) 
	
	//�� �ڿ� 0�� �����ϱ�, else�� 0�� ������
	
	//0�� �������ݾ�? �� �Ŀ� �پ��ִ� 0���� �ɷη� ������ �µ� �׷����� ���� ������, 0�����Ŀ� �����ϴ� ���������̶� �ڸ��� �ٲ�ġ�� ��
	
	//�׷� [0,1,0,0,2,3,4,5] �̰� �ѹ� �ٲ�ġ�� �ϸ� 0�̶� 1�̶� �ٲ�ġ�� �ϴϱ�
	
	//[1,0,0,0,2,3,4,5] �� �ǰڳ�? �׷� 0�� 3���� �ɷη� �����ֳ�? �׷� 0 ���Ŀ� �����ϴ� 2,3,4 ���Ե� �̶� �ٲ�ġ�� ��
	
	//[1,2,3,4,0,0,0,5]�� �ǰڳ�? 3,4�� �ǳʶٰ� ���� 0���� 5�� �ٲٸ� ��
	
	//���Ŀ� nums.length-totalZeros(3)���ǿ� �ȸ����ϱ� ��¥�� �� 0���� ä���
	
	//�Ƶ� ������ ���� �̰�
	
	//21 / 21 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 39.9 MB
	public void moveZeroes(int[] nums) {
        for(int i = 0, zero = 0, totalZeros = 0; i < nums.length; i++){
            if(i < nums.length-totalZeros){
                if(nums[i] == 0){
                    int j = i;
                    while(j < nums.length && nums[j] == 0){
                        zero++;
                        j++;
                    }
                    if(zero > totalZeros){
                        totalZeros = zero;
                    }
                    int i_ = i;
                    while(j < nums.length && zero > 0){
                        nums[i_] = nums[j];
                        nums[j] = 0;
                        i_++;
                        j++;
                        zero--;
                    }
                }
            } else {
                nums[i] = 0;
            }
        }
    }
    */
	
	
	//<����Ǯ�� 2 by caikeke>
	
	//�Ƶ� �Ƹ���� ¥�ó�
	
	//0�� �ƴ� ���ڸ� zero == l�̴ϱ� nums[zero] = nums[l]�� �� �� ������ ��ٻ��°�
	
	//�ٵ� 0�� �þ�� ���� l�� +1�ǰ� 0�� ���ڸ��ϱ�, ������ l�� 0�̶� �ٲ�ġ�� �� ��, ������ �ڸ��� �ٲ�°�
	
	public void moveZeroes(int[] nums) {
	    int zero = 0, l = 0, r = nums.length;
	    while (l < r) {
	        if (nums[l] != 0) {
	            int tmp = nums[zero];
	            nums[zero++] = nums[l];
	            nums[l] = tmp;
	        }
	        l++;
	    }
	}
}
