package array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK560 {
	/*
	//<Trial01 - time limit exceeded>
	
	//brute-force
	
	public int subarraySum(int[] nums, int k) {
        int rst = 0;
        for(int i = 0; i < nums.length; i++){ //i < nums.length-1���ϰ� i < nums.length�� ������, ������ element�ϳ��� ī��Ʈ �ؾ��ϱ� ����
            for(int j = i+1; j < nums.length+1; j++){ //j < nums.length+1�� ������ ������ element�ϳ� ī��Ʈ �ϱ� ����. �� j < nums.length�ϸ� j-for�� �ؿ� �ֵ��� ��ŵ��.
                int sum = 0;
                for(int p = i; p < j; p++){
                    sum += nums[p];
                }
                if(sum == k){
                    rst++;
                }
            }
        }
        return rst;
    }
	*/
	/*
	//<����Ǯ��1 by Leetcode Solution>
	
	//���� ���� �����ְ�, 2��for������ ���²� �������߿� ���� k�� ���ڰ� ������ +1���ִ� ���
	
	//[-1,1,-2,2,3] �ε�, k = 3�̶�� �ϸ�,
	
	//�������� [0,-1,0,-2,0,3]�� �ǰ�,
	
	//0��°, 2��°, 4��° �� 3���� ���� k�� �Ǵ� ��.
	
	//���⼭ 0��°�� nums[i]������ ����. ���ʿ� container[0]�� 0�̶� nums[i]+0=nums[i]�̱� ����
	
	//Runtime: 205 ms, faster than 25.24% of Java online submissions for Subarray Sum Equals K.
	//Memory Usage: 41.3 MB, less than 5.43% of Java online submissions for Subarray Sum Equals K.
	public int subarraySum(int[] nums, int k) {
        int rst = 0;
        
        int[] container = new int[nums.length+1];
        for(int i = 1; i < container.length; i++){
            container[i] = container[i-1] + nums[i-1];
        }
        
        for(int i = 1; i < container.length; i++){
            for(int j = 0; j < i; j++){
                if(container[i]-container[j] == k){
                    rst++;
                }
            }
        }
        return rst;
    }
	*/
	
	//<����Ǯ��2 by shawngao>
	
	//�������� map.key�� ��� �����ָ鼭(������ ���� �������� �־��ٸ�, �ش� �������� ����+1�� ����),
	
	//������-k�� map�� �ִ��� Ȯ��.
	
	//������ � �׿��ִ��� ����, �� ������ŭ rst�� +����
	
	//Runtime: 11 ms, faster than 95.95% of Java online submissions for Subarray Sum Equals K.
	//Memory Usage: 40.4 MB, less than 33.69% of Java online submissions for Subarray Sum Equals K.
    public int subarraySum(int[] nums, int k) {
        int rst = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                rst += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return rst;
    }
}
