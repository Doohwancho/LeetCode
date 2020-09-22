package september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
	
	//<����Ǯ��1>
	
	//map
	
	//O(n)�ε� �ణ �ƽ�����
	
	//Runtime: 11 ms
	//Memory Usage: 48.4 MB

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        int limit = nums.length/3;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            int cnt = map.getOrDefault(n, 0);
            
            if(cnt == limit){
                rst.add(n);
                map.put(n, -1000);
            } else {
                map.put(n, cnt+1);    
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2>
    
    //two-pointers
    
    //������ �ξ� ����������, �̰͵� O(n)�̱� �ѵ�
    
    //Runtime: 3 ms
    //Memory Usage: 43.2 MB
    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = len/3, j = 0; i < len; ){
            if(nums[i] != nums[j]){
                j++;
                while(j < len && nums[j] == nums[j-1]){
                    j++;
                }
                i = j+len/3;
            } else {
                rst.add(nums[i]);
                i++;
                while(i < len && nums[i] == nums[i-1]){
                    i++;
                }
                j = i;
                i = i+len/3;
            }
        }
        return rst;
    }
    
}
