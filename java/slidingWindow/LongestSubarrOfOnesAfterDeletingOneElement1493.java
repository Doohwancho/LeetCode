package array;

public class LongestSubarrOfOnesAfterDeletingOneElement1493 {

	
	//<����Ǯ��1>
	
	//sliding-window
	
	//O(n)
	
	//Runtime: 6 ms, faster than 21.37% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
	//Memory Usage: 55.2 MB, less than 50.00% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
    public int longestSubarray(int[] nums) {
        int max = 0;
        int zero = 0;
        for(int i = 1, last = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = nums[i-1] - last;
                last = nums[i];
                zero++;
            } else {
                nums[i] += nums[i-1];    
            }
            max = Math.max(max, nums[i]);
        }
        return zero > 0 ? max : max-1;
    }
    
    
    //<����Ǯ�� 2 by lee215>
    
    //sliding window
    
    //��� ����Ǯ��1���� �ٸ���, zero > 0 ? max : max-1ó���� ���ص� �Ǵ°�
    
    //���ʿ� max�� ���Ҷ� j-i�� �ϱ� ����. j�� ���ʿ� nums.length-1�����ۿ� �Ȱ��°͵� �ְ�.
    
    //j�� �� ����, i�� Ư�� ����(0�� 2���̻� ����)�� �Ǹ�, ���������� ���� 0���� ����.
    
    //Runtime: 4 ms, faster than 40.62% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
    //Memory Usage: 55.5 MB, less than 50.00% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
    
    public int longestSubarray(int[] nums) {
        int i = 0, k = 1, max = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 0) k--;
            while(k < 0){
                if(nums[i]==0){
                    k++;
                }
                i++;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}
