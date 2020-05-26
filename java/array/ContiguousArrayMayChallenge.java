package mayChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousArrayMayChallenge {
	
	//<����Ǯ��1>
	
	//Runtime: 42 ms
	//Memory Usage: 49.4 MB
	
	public static int findMaxLength(int[] nums) {
		int rst = 0;
		int[] sum = new int[nums.length];
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		List<Integer> temp = new ArrayList<>(); //0,-1�� �̸� �������, [0,1,0,1,0,1]���� ���̽� pass����. [0,0,0,0,0,0,0,1,1,1]���� �����ִ°��� �ʿ����.
        temp.add(-1);
        map.put(0, temp);
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0) nums[i] = -1;
        	sum[i] = (i > 0 ? sum[i-1] : 0) + nums[i];
        	if(map.containsKey(sum[i])) {
        		List<Integer> tmp = map.get(sum[i]);
        		tmp.add(i);
        		map.put(sum[i], tmp);
        	} else {
        		List<Integer> tmp = new ArrayList<>();
        		tmp.add(i);
        		map.put(sum[i], tmp);
        	}
        }
        
        for(Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
        	rst = Math.max(rst, Math.abs(m.getValue().get(m.getValue().size()-1) - m.getValue().get(0))); //�� �������� �����ߴ� �ε����� �� ÷ �����ߴ� �ε����� ����
        }
		
		return rst;
    }

	
	
	//<����Ǯ��2 by shawngao>
	
	//����Ǯ�� 1������ ���� sum�� ������ �ε����� ��� arraylist�� ��Ƴ��ٰ�, �� ���������� �� ó������ ���� ������ �ߴµ�
	
	//������� ���ϴ°Ŵϱ� ��¥�� �߰��͵��� �ʿ���ݾ�?
	
	//�׷��� Math.max()�� �ִ�ġ �� loop���� ������Ʈ ��Ű�� list�� �ȴ�� ���
	
	//22ms�� ����
	
	//Runtime: 20 ms
	//Memory Usage: 49.2 MB
	
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
            
        }
        
        return max;
    }
}
