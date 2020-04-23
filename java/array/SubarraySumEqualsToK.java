package thirtyDayChallenge;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsToK {
	
	//<����Ǯ��1 by shawngao>
	
    //80 / 80 test cases passed.
	//Status: Accepted
	//Runtime: 12 ms
	//Memory Usage: 40.3 MB
    public int subarraySum(int[] nums, int k) { //
    	int sum = 0;
    	int rst = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); //k�� 7�ε� nums[i]�� 7�ϼ��� ���ݾ�!
        
        for(int n : nums){
        	sum += n;
            if(map.containsKey(sum-k)){ 
            	//�� k-n�� �ƴ϶� sum-k�ϱ�? 
            	//sum[i,j] = k���, sum[0,i-1]�̶� sum[0,j]������ �˸� �ǰڳ�?
            	//sum[0,j] - sum[0,i-1] = sum[i,j] = k�̴ϱ�.
            	
            	//������� 1,2,3,4,3,2,1, k = 10, index�� 5��°�� ��(4 ������ 3�� ����ų ��),
            	//sum = 13, sum(13)-k(10) = 3�� map�� �����Ƿ� rst+1�ϴµ�,
            	//���⼭ k�� subarray�ȿ� ���������(3,4,3) �� ���� ���ϰ�, 
            	//sum-k�� subarray�� ���Ե��� �ʴ� ���� ���ڵ��� �� ��(1,2)�� ����.
            	
            	rst += map.get(sum-k);
            	//�� rst++; ���ϰ� ,rst+= map.get(sum-k)��?
            	//Input: [0,0,0,0,0,0,0,0,0,0], k = 0
            	//�� ���, 1+2+3+...+8+9+10 ���ؼ� 55�� �Ǿ� ���ڳ�
            	//�������� �����ִ°�
            	//0,0,0,1,4,2...
            	//�϶�, 3��° 0�� ī��Ʈ �ؾ��Ѵٸ�, ������ 0�鵵 ī��Ʈ ����� ���ڳ�
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
            //�� �׳� map.put(sum-k, 1) ���ϰ� �������� +1����?
            //���� ���̳ʽ� ���� �ִٰ� ġ��.
            //int[] sum = {1,3,....7,3,4}
            //�ε�, 3�� ī��Ʈ ����� �ϸ�, ���ʿ� �ִ°� �ϳ��� ������ 3, �����ʿ� �ִ� 3�� ������ 3�̴ϱ�, �����ɷ� ġ�ݾ�
            //�׷��ϱ� ������ ���� �� �������� +1�������
        }
        return rst; 
        
    }
}
