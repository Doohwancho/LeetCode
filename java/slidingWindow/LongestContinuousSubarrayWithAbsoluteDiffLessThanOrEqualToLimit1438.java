package array;

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit1438 {

	//<Trial01>
	
	//sliding window
	
	//���� ���� �ε� �ִ� �ּڰ� ���丸 �̽��ϸ� �ɰŰ�����
	
    public int longestSubarray(int[] nums, int limit) {
        int rst = 0;
        
        for(int i = 0, j = 0, diff = 0; j < nums.length; j++){
            if(Math.abs(nums[j]-nums[i]) > limit){
                while(Math.abs(nums[j]-nums[i]) > limit){
                    i++;
                }
            } else {
                rst = Math.max(rst, j-i+1);
            }
        }
        
        return rst;
    }
    
    
    //<����Ǯ��1>
    
    //��, õ��, ���� 
    
    //time: O(n)
    //space: O(n)
    
    //Runtime: 36 ms, faster than 59.64% of Java online submissions for Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit.
    //Memory Usage: 65.1 MB, less than 12.82% of Java online submissions for Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit.
    
    public int longestSubarray(int[] nums, int limit) {
        int rst = 0;
        
        for(int i = 0, j = 0, maxi = nums[0], mini = nums[0]; j < nums.length; j++){ //j�� �� �����ʾ�, i�� �� ���ʾ�
            maxi = Math.max(maxi, nums[j]); //j�� ������ ���İ� �߿��Ѱ� �ƴ϶�, i~j�߿� �� ū�ֶ� �� �����ְ� �����İ� �߿�. �װ� maxi,mini�� ��� ������Ʈ
            mini = Math.min(mini, nums[j]);
            
            if(maxi-mini > limit){ //���� limit�� �������
                maxi = Integer.MIN_VALUE; //maxi,mini�� �ʱ�ȭ ���ְ�
                mini = Integer.MAX_VALUE;
                
                while(++i < j && Math.abs(nums[j]-nums[i]) > limit){} //i�� ������ �������� �������� ���������� ����
                
                int i_ = i;
                while(i_ <= j){ //���ο� i�� ����������, i~j������ �ִ��, �ּҼ��� �ٽ� ������Ʈ ������.
                    maxi = Math.max(maxi, nums[i_]);
                    mini = Math.min(mini, nums[i_]);
                    i_++;
                }
            } else { //i~j������ �ִ밪-�ּڰ����� limit���� �ȿ������� rst�� ������Ʈ
                rst = Math.max(rst, j-i+1);
            }
        }
        
        return rst; 
    }
    
    
    
    //<����Ǯ��2 by prdp89>
    
    //treemap�� �̿��ؼ� �ִ�,�ּڰ� ���ϴ¹�
    
    //time: O(NlogN)
    //space: O(N)
    
    //Runtime: 190 ms, faster than 7.77% of Java online submissions for Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit.
    //Memory Usage: 108.5 MB, less than 5.02% of Java online submissions for Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit.
    
    public int longestSubarray(int[] A, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < A.length; j++) {
            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
        }
        return j - i;
    }
}
