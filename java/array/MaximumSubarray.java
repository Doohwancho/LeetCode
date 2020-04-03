package thirtyDayChallenge;

public class MaximumSubarray {
	
	/*
	//<����Ǯ��1>
	
	//202 / 202 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 39.8 MB
	
	public int maxSubArray(int[] nums) {
        int rst = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                if(max < 0){
                    max = Math.max(max, nums[i]); //��� -�� ������ ���߿� �׳��� �� ū�Ÿ� ����.
                }
                else if(max + nums[i] >= 0){ //nums[i]�� �ƹ��� ���̳ʽ�����, ���²� �׾ƿø� �͵�� �������� +��, ��������.
                    max += nums[i];
                }
                else{ //���²� �׾ƿø� max���� nums[i]�� -���� �� ũ��, �������� -�ϱ� 0���� ���½����ش�.
                    max = 0;  
                }
                
            } else {
                if(max > 0){ 
                    max += nums[i];
                } else {
                    max = nums[i]; //max�� ���̳ʽ� ���� ���, nums[i]�� ���Ӱ� ���½����ش�
                }
            }
            rst = Math.max(rst, max);
        }
        return rst;
    }
    */
	
	
	//<����Ǯ��2 by shabeeb>
	
	//����Ǯ��1�� �� ���� �����ϰ� ������ ��

	//202 / 202 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 39.8 MB
	
    public int maxSubArray(int[] nums) {
        int currentWindowSum = nums[0];
        int largestSum = nums[0];
        for(int i=1; i<nums.length ; i++){
            currentWindowSum = Math.max(currentWindowSum+nums[i],nums[i]);
            largestSum = Math.max(largestSum,currentWindowSum);
        }
        return largestSum;
    }
}
