package mayChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	
	// <����Ǯ��1>

	// �󵵼� üũ�ϴ� ������ ���. ���ɱ���.

	// 46 / 46 test cases passed.
	// Status: Accepted
	// Runtime: 10 ms
	// Memory Usage: 45.4 MB

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int n : nums) {
			m.put(n, m.getOrDefault(n, 0) + 1);
			if (m.get(n) > nums.length / 2) {
				return n;
			}
		}
		return 0;
	}
	

	
	// <����Ǯ��2 by anpthai>

	// ���� Ǯ��. ���� ������ ������.

	// 46 / 46 test cases passed.
	// Status: Accepted
	// Runtime: 10 ms
	// Memory Usage: 44.9 MB
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	

	
	//<����Ǯ��3 by mo10>
	
	//greedy
	
	//������ �� ����. Moore voting algorithm�̶��.
	
	//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
	
	//For the Moore algorithm, there should be a second loop after finding the candidate and the count,
	//to again iterate over the array and confirm if candidate's count > n/2 :
	//this will ensure that there is no false candidate produced.
	
	//��ġ. ���� ���� ī��Ʈ �Ǵ°� ��ȯ������, nums.length/2�̻� ���������� ���ڳ�
	
	//46 / 46 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 42.3 MB
	
	public int majorityElement(int[] nums) {
		int cnt = 0, val = 0;
		for(int n : nums) {
			if(cnt == 0) {
				val = n;
			}
			if(val != n) {
				cnt--;
			} else {
				cnt++;
			}
		}
		return val;
	}
	
	
	
	//<����Ǯ��4 by kotomi_null>
	
	//�� ���ڸ� ���ݼ� ������,
	
	//bitmask�� 32��(�� �տ� �ε�ȣ ���� 31��)�� �ڸ��� ���鼭
	
	//���ݼ� �Ѵ� bit�� �����ִ� ���.
	
	//�̰͵� ���ϳ�

	//46 / 46 test cases passed.
	//Status: Accepted
	//Runtime: 4 ms
	//Memory Usage: 42.9 MB
	
	public static int majorityElement(int[] nums) {
        int half = nums.length / 2;
        int major = 0;
        for(int i = 0; i < 32; i++) {
            int ones = 0;
            for(int num : nums) {
                ones += (num >> i) & 1;
            }
            if(ones > half) {
                major += 1 << i;
            }
            System.out.println("i: "+i+" ones: "+ones+" major: "+major);
        }
        return major;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums));
	}
}
