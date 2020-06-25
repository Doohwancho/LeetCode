package juneChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

	//<Trial01>
	
	//duplicate number�� �̻ڰ� �� 2���� ������ �� �˾��ڳ�~
	
	//There is only one duplicate number in the array, but it could be repeated more than once.
	
	//������ ����� ���о���~
	
    //1,2,3,4,5
    
    //5/2 * (1+5) + 5/2+1
    
    //1,2,3,4
    
    //4/2 * (1+4)
    
    public int findDuplicate(int[] nums) {
        int total = 0;
        int len = nums.length;
        int sum = len % 2 == 1 ? len/2 * (1+len) + len/2 +1 : len/2 * (1+len);
            
        for(int n : nums){
            total += n;
        }
        return len - (sum - total);
    }
    
    //<Trial02>
    
    //set�� �ߺ����ڰ� �ȵ��ٴ� ���� �̿��� ����ε� 
    
    //You must use only constant, O(1) extra space.
    
    //���ǿ� �ȸ���
    
    //Runtime: 2 ms
    //Memory Usage: 40.5 MB
    public int findDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            if(!s.add(n)){
                return n;
            }
        }
        return -1;
    }
    
    //<Trial03>
    
    //binary search
    
    //�� �� �غ� ����
    
    //Runtime: 4 ms
    //Memory Usage: 42.2 MB
    
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length;
        while(l < r){
            int m = (l+r)/2;
            if(nums[m] < m+1){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    
    //<����Ǯ��1 by HelloWorld123456>
    
    //�̰� binary search �� ������� ���� ���Ű����� ���ɵ� ������
    
    //�������� ���ĵ� �ȵ��ִ°ſ��� ������ �������;; ��;;
    
    //Runtime: 4 ms
    //Memory Usage: 42.4 MB
    
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    
    //<����Ǯ��2 by LHearen>
    
    //�䳢�� �ź��� �ַ���ε�
    
    //�̰� ���²� �ַ���߿� �׳��� �� ����
    
    //�ٵ� singly linked list�� �ƴѵ� �̰� ���ٴ°� �� �׷��⵵ �ϰ�
    
    //������ �׳� two pointer�� �ص� �Ȱ��ݾ�?
    
    //�� �ٽû����غ��ϱ� �׳� two pointer�ʹ� �ٸ���
    
    //�䳢�� nums.length�� ��������� �ٽ� �������شٴ� ������ 
    
    //�̰� �� ���� ��
    
    //Runtime: 0 ms
    //Memory Usage: 39.2 MB
    
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = nums[0], fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = nums[0];
                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;
            }
        }
    }
    
    //<����Ǯ��3 by qgambit2> 
    
    //���� ��������� �������� �ַ��
    
    //nums�� iterate�Ҷ� ������ n���� 2�� n������ ����� ������,
    
    //bit�� �ϳ��� �����ϱ�, xor�ؼ� bit�� ������ 
    
    //Runtime: 194 ms
    //Memory Usage: 115.3 MB
    
    public int findDuplicate(int[] nums) {
        java.math.BigInteger test = new java.math.BigInteger("0");
        for (int n:nums){
            java.math.BigInteger twoPowN = new java.math.BigInteger("2").pow(n);
            java.math.BigInteger test1 = test.xor(twoPowN);
            if (test1.compareTo(test) < 0){
                return n;
            }
            test = test1;
        }
        return 0;
    }

}
