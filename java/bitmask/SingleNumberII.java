package juneChallenge;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberII {

	//<����Ǯ��1>
	
	//2��Ÿ �ϵ峪���ٰ� ���ò� �׷��� �Ҹ��Ѱ� ���Գ� ���� �����ȴ�
	
	//[2,2,3,2] �̰� ����,
	
	//�� ���ϸ� 9��?(== total:9)
	
	//�ϳ����� �����°͸� �� ���ϸ� 5��?(== uniqTotal : 5)
	
	//total(9) - uniqTotal(5) �ϸ� 4��? �׸��� �̰� 3���� ������ ���ڵ��� 2���� ���� ���̳�?
	
	//3���� ������ ���ڵ��� 2���� ���� ���� ������ ������, ��� 3���� ������ ���ڵ��� ���� �ǰڳ�?
	
	//�װ� �ϳ����� �����°��� �� ��(==uniqTotal)���� ���� �츮�� ã�� �ѹ��� ������ ���ڸ� ã�� �� �ְڳ�?
	
	//Runtime: 2 ms
	//Memory Usage: 39.1 MB
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int total = 0;
        int uniqTotal = 0;
        
        for(int n : nums){
            if(s.add(n)){
                uniqTotal += n;
            };
            total += n;
        }
        return uniqTotal - (total-uniqTotal)/2;
    }
    
    //<����Ǯ��2 by HelloWorld123456>
    
    //�� bit�ڸ��� ���鼭 sum�� ����. �װ� ��ü ���� �� total += n�ѰͰ� �ٸ��� ����
    
    //�ٸ�, bit���ڸ��� ���Ҷ����� %3�� �ؼ�, �� �ڸ��� unique number�� �����ִ��� Ȯ���ϴ� ��.
    
    //���� 7��°�ڸ� bit�� 3�� �Ȱ��� ���ڰ� ���Դٸ�, sum�� �� ���� ��, 3�� �������ϱ� %3�ϸ� 0�Ǽ� result�� ��ȭ�� ����
    
    //�ٵ� ���� 8��° �ڸ� bit�� 3�� �Ȱ��� ���ڰ� ������ �Ѱ� unique number�� bit�� ������, %3�� ���� ��, 1���� ���Ƽ� result�� ���� ����.
    
    //���������� 9��° �ڸ��� 3�� �Ȱ��� ���ڰ� �Ѱ��� �ȳ��Դµ� unique number�� bit�� �ִٰ� ġ��, 1%3�� 1�̱� ������, result�� �ݿ���.
    
    //sum%3�� �ٽ�. 
    
    //Runtime: 1 ms
    //Memory Usage: 39.3 MB
    
	public static int singleNumber(int[] nums) {
		int len = nums.length, result = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) {
				sum += (nums[j] >> i) & 1;
			}
			result |= (sum % 3) << i;
		}
		return result;
	}
}
