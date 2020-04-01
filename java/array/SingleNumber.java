/*
	Given a non-empty array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
	Example 1:
	
	Input: [2,2,1]
	Output: 1
	Example 2:
	
	Input: [4,1,2,1,2]
	Output: 4
	
	
	
	<����>
	
	����Ʈ �ȿ��� ���ڵ��� �ִµ�, ���� �� ���ڸ� �� �ѹ� �����ϰ�, ������ ���ڵ��� �ι��� �����Ѵٰ� �� ��,
	
	�ѹ��� �����ϴ� �ָ� �̾ƶ�.
 */

package thirtyDayChallenge;

import java.util.Arrays;

public class SingleNumber {
	
	/*
	//<����Ǯ��1>
	
	//���� ������ �ָ� 
	
	//[3,1,2,3,2] �̰� [1,2,2,3,3] ���� �ȴ�.
	
	//�ε��� 0���� �����ؼ� 2�� ������ ���鼭, if(nums[i]!=nums[i+1]) return nums[i]�� unique�� ���ڸ� ���� �� �ִ�.
	
	//�ٵ� ���࿡ [1,1,2,2,5]ó�� �� �ڿ� �ִ� ��쿣, if(i == nums.length-1)�� ����ó�� ���ش�.
	
	//return nums[0]�� list size�� 1�϶��� ��� ó��.
	
	//Runtime: 3 ms
	//Memory Usage: 40.7 MB
    public int singleNumber(int[] nums) {
    	Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2){
            if(i == nums.length-1) return nums[nums.length-1];
            if(nums[i]!=nums[i+1]) return nums[i];
        }
        return nums[0];
    }
    */
	
    //<����Ǯ��2>
    
    //�������ȵ�
	
	//xor������ bitmask���� �� �ϳ���, ���� ������ ������ false, �ٸ��� ������ true��.
	
	//�������, 
	
	//true ^ true = false
	
	//true ^ false = true
	
	//1010 ^ 1010 = 0000
	
	//1010 ^ 1010 ^ 1010 = 1010
	
	//��� ���� xor�����ϸ�, duplicate���� �� �ٽ� 0�� �ǹǷ�, unique�� ���� ���� �� ����
    
    //Runtime: 0 ms
    //Memory Usage: 41 MB
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums) xor ^= n;
        return xor;
    }
}
