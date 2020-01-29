/*
	We are given a list nums of integers representing a list compressed with run-length encoding.
	
	Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.
	
	Return the decompressed list.
	
	
	
	Example 1:
	
	Input: nums = [1,2,3,4]
	Output: [2,4,4,4]
	Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
	The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
	At the end the concatenation [2] + [4,4,4,4] is [2,4,4,4].
	 
	
	Constraints:
	
	2 <= nums.length <= 100
	nums.length % 2 == 0
	1 <= nums[i] <= 100
	
	
	
	<����>
	
	 nums = [1,2,3,4]
	 
	 nums���� ������ ���ڵ��� ���� ��� ���� [1,2]�� [3,4]�̴�.
	 
	 ���� �ڿ� ���ڸ� �տ����ڸ�ŭ ������� �־ ��ȯ�϶�.
	 
	ex). ���Ǽ��� 2�� �ѹ��ְ�, ���Ǽ��� 4�� �տ����� 3��ŭ ���� ������, [2,4,4,4]
 */

package array;

import java.util.ArrayList;
import java.util.List;

public class DecompressedRunLengthEncodedList1313 {
	
	/*
	//<����Ǯ��1>
	
	//����
	
	//Runtime: 3 ms, faster than 67.42% of Java online submissions for Decompress Run-Length Encoded List.
	//Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
	
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i+=2){
            for(int j = 0; j < nums[i]; j++){
                list.add(nums[i+1]);
            }    
        }
        
        int[] rst = new int[list.size()];
        int idx = 0;
        
        for(int k : list){
            rst[idx++] = k;
        }
        return rst;
    }
    */
    
    //<����Ǯ�� by manrajsingh007>
    
    //����� ������ �̰� ����Ǯ��1���� 2ms �� ���� ������ arraylist�� �Ⱦ��� �ٷ� ����Ʈ�� �Ѿ�� ����.
	
	//���� ���ʿ��ϳ� ���ִ°� ����
    
    //Runtime: 1 ms, faster than 99.43% of Java online submissions for Decompress Run-Length Encoded List.
    //Memory Usage: 41.2 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
    
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i += 2) count += nums[i];
        int[] ans = new int[count];
        int k = 0;
        for(int i = 0; i < n; i += 2) {
            for(int j = 0; j < nums[i]; j++) ans[k++] = nums[i + 1];
        }
        return ans;
    }
}
