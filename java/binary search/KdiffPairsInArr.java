package october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KdiffPairsInArr {

	//<����Ǯ��1>
	
	//�� ������� Ǯ���� �̰� �� �ھ���
	
	//Runtime: 204 ms
	//Memory Usage: 38.8 MB
    public int findPairs(int[] nums, int k) {
        if(k == 0){
            Map<Integer, Integer> map = new HashMap<>();
            for(int n : nums){
                map.put(n, map.getOrDefault(n, 0)+1);
            }
            int rst = 0;
            for( Map.Entry<Integer, Integer> elem : map.entrySet() ){
                if(elem.getValue() > 1){
                    rst++;
                }
            }
            return rst;
        } else {
            Arrays.sort(nums);
            int rst = 0;
            for(int i = 0; i < nums.length; i++){
                if(i > 0 && nums[i] == nums[i-1]) continue;
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] != nums[j-1] && nums[j] >= nums[i] && nums[j]-nums[i] == k){
                        rst++;
                    }
                }
            }
            return rst;
        }
    }
    
    
    //<����Ǯ��2>
    
    //binary search
    
    //�׷� �̰���
    
    //Runtime: 11 ms
    //Memory Usage: 42 MB
    
    private void binarySearch(int[] nums, int idx, int[] rst, int target){
        int l = 0, r = idx;
        while(l < r){
            int m = (l+r)/2;
            int tmp = nums[idx] - nums[m];
            if(tmp == target){
                rst[0]++;
                break;
            }
            else if(tmp < target){
                r = m;
            } else {
                l = m+1;
            }
        }
        
        int left = idx+1, right = nums.length;
        while(left < right){
            int middle = (left+right)/2;
            int temp = nums[idx] - nums[middle];
            if(temp == target){
                rst[0]++;
                break;
            }
            else if(temp < target){
                right = middle;
            } else {
                left = middle+1;
            }
        }
    }
    
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int[] rst = new int[1];
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            binarySearch(nums, i, rst, k);
        }
        
        return rst[0];
    }
    

    
    
    
    //<����Ǯ��3 by shawngao>
    
    //string �� Hashset�� .contains()�� �� �ֱ���. �ּڰ����� ���� ���ϳ���?
    
    //Runtime: 37 ms
    //Memory Usage: 40.1 MB
    
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> seenNum = new HashSet<>();
        Set<String> seenPair = new HashSet<>();
        int rst = 0;
        
        for(int i = 0; i < nums.length; i++){
            int prev = nums[i] - k; //sort()������, k = (-prev) + nums[i] �̿��� �ؼ� �׷�
            if(seenNum.contains(prev) && !seenPair.contains(prev+","+nums[i])){ //nums[i]+","+prev�� �ƴ� ������ nums[i]�� ���� ó�� ���¾ֶ�
                rst++;
                seenPair.add(prev+","+nums[i]);
            }
            
            seenNum.add(nums[i]);
        }
        return rst;
    }
    
    //<����Ǯ��4 by lee215>
    
    //Runtime: 10 ms
    //Memory Usage: 45.4 MB
    
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        for (int x : cnt.keySet()) {
            if ((k > 0 && cnt.containsKey(x + k)) || (k == 0 && cnt.get(x) > 1)) { //�ΰ� ���̽� �ѹ��� ó���ϳ�. ����Ǯ��1�� �ȶ��� ����.
                res++;
            }
        }
        return res;
    }
}
