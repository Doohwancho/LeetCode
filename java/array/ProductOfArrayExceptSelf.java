package thirtyDayChallenge;

public class ProductOfArrayExceptSelf {
	
	/*
	//<Trial01>
	
	//Note: Please solve it without division and in O(n).
	
	//�����?

	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 47 MB
	public int[] productExceptSelf(int[] nums) {
        int zeroes = 0;
        int total = 1;
        for(int n : nums){
            if(n==0){
                zeroes++; //0���� ����� ��. 0������ ���� �� array�� ���簡 �����ϱ�.
            }else{
                total *= n; //0�� �ƴϸ� �� ����
            }
        }
        if(zeroes > 1){  //0�� 2����� ġ��? [0,2,0,4,5] �׷� �ᱹ 0 �ڽ��� ������ �ٸ����� 0�� �����ϱ� ������ ����� ���ص� 0�̰���? �׷� �� 0�� ������ ��.
            for(int i = 0; i < nums.length; i++){
                nums[i] = 0;
            }
        } else if(zeroes == 1){ //0�� �Ѱ��ۿ� ���ٰ� ġ��? [1,2,0,4,5] �̰� 0�� �ڸ��� ������ �� ���� total�� ����, ������ �ڸ��� �� 0�̰���? 
            for(int i = 0; i < nums.length; i++){
                if(nums[i]==0){
                    nums[i] = total;
                } else {
                    nums[i] = 0;
                }
            }
        } else{ //0�� �ƿ� ���ٰ� ġ��? �׷� [1,2,3]���� total�� 6�̰���? �׸��� 6�� 1x2x3�̶�, ������ �� 2��� ġ��, 6/2�ϸ�, 1x3�� ���ݾ�. ������ ������ ��. �׷� �װſ�
            for(int i = 0; i < nums.length; i++){
                nums[i] = total / nums[i];
            }
        }
        return nums;
    }
    */
	
	//<����Ǯ��1 by xcv58>
	
	//{2,3,4,5}�־��ٰ� ġ��
	
	//ù for���� ����� �̷��� ����.
	
	//{1 2 6 24}
	
	//�� ó���� 1�̰�, �������� i-1��°���� ���� ��.
	
	//�׷��ϱ� {1, index0, index0 * index1, index0 * index1 * index2}
	
	//�ٵ� �ι�° for��, �������� ����, �� ���������� ���ڸ� �ϳ��� tmp�� �������� �����鼭 ���ذ�.
	
	//1 2 6 24 
	//1 2 30 24 
	//1 40 30 24 
	//60 40 30 24 
	
	// {1, index0, index0 * index1, index0 * index1 * index2} �̰ſ��ݾ�?
	
	//index0 * index1 * index2 ��κ�. ù��°. i�� nums.length-1�϶� 1�� ����. tmp�� 1���ݾ�.
	
	//�ٵ� tmp�� nums�� �� ������ ���ں��� �������� ���δٱ׷���?
	
	//tmp�� 1*index3��. �׸��� ������  index0 * index1���� �Ѿ��, 
	
	// index0 * index1 * index3�� ��. 2��°�� ���� �� ���Ѱ���.
	
	//�׷��� tmp�� index2 * index3�� ��. �������� ���δٱ׷��ݾ�?
	
	//�׷� �������� index0�� ����, index0 * index2 * index3 �� ��. 1��°�� ���� �ٰ��Ѱ���. 
	
	//�̷����̾�.

	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 47.9 MB
	public static int[] productExceptSelf(int[] nums) {
	    int[] result = new int[nums.length];
	    
	    for (int i = 0, tmp = 1; i < nums.length; i++) {
	        result[i] = tmp;
	        tmp *= nums[i];
	    }
	    
	    for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
	        result[i] *= tmp;
	        tmp *= nums[i];
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int[] test = {2,3,4,5};
		System.out.println(productExceptSelf(test));
	}
}
