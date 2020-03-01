package array;

import java.util.Map;
import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers1296 {
	
	/*
	//<Trial01 - Memory Limit Exceeded>
 
	//��ǲ ������ġ�ڳ�
	
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        Arrays.sort(nums);
        
        int[] container = new int[nums[nums.length-1]+1];
        
        for(int ele : nums){
            container[ele]++;
        }
        
        for(int prev = -1, len = nums.length; len > 0; len -= k, prev = -1){
            for(int idx = 0, limit = 0; idx < container.length; idx++){
                if(container[idx] > 0){
                    if(prev == -1){
                        prev = idx;
                        container[idx]--;
                        limit++;
                    } else {
                        if(idx == prev+1){
                            prev = idx;
                            container[idx]--;
                            limit++;
                        }
                        else if(prev == idx){
                            continue;
                        } else { 
                            return false;
                        }
                    }
                } 
                if(limit == k){
                    break;
                }
            }
        }
        return true;
    }
    */
	
	//<����Ǯ��1 by lee215>
	
	//Runtime: 191 ms, faster than 16.75% of Java online submissions for Divide Array in Sets of K Consecutive Numbers.
	//Memory Usage: 55.1 MB, less than 100.00% of Java online submissions for Divide Array in Sets of K Consecutive Numbers.
    public boolean isPossibleDivide(int[] A, int k) {
        Map<Integer, Integer> c = new TreeMap<>(); //Arrays.sort()�� treemap���� ��ü
        for (int i : A) c.put(i, c.getOrDefault(i, 0)+1); //�󵵼� ī��Ʈ
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = k - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false; //�󵵼��� 1,1,1,1,2������ �Ǵµ� 2,1,1,1,1�� 5�� ������ �� �տ� 1�� ���׷��� ���Ƽ� false��ȯ���ݾ�. �׷��� �� �տ����� �� �ڿ��ͺ��� ������ ���ų� �۾ƾ� ����.
                    c.put(it + i, c.get(it + i) - c.get(it)); //���࿡ 3,3,3,3,5�� ������ 3�� ���ƾ� ���ݾ�. �׷� �߿� �� ó���� ���°� 3���� ���ָ� 0,0,0,0,2���Ǽ� iteration ���̰� �ٷ� �������� �Ѿ �� ����
                }
        return true;
    }
	
	
	
}
