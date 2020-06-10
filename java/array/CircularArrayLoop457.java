package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CircularArrayLoop457 {
	
	/*
	//<Trial01>
	
	//[2,-1,1,-2,-2]
	
	//���⿡�� ����.
	
	//0->2->3->1->0 �ݺ��ε�,
	
	//�������� �ǵ��ϴ°�, ���������θ� ���� ������ ����� ���;� �ǰ�, �������� ���� ������ ������ ���;� �ȴٴ� �ǰ�? �׷���
	
	//boolean pos = nums[0] > 0 ? true : false; �̰Ŷ�
	//if(pos != nums[i] > 0) return false; �̰�
	
	//�߰��ߴµ�, 
	
	//[3,1,2] ���⼭ ����.
	
	//true�� ���;� �ȴٳ�? �ٵ� 0->0->0->0���ݾ�
	
	//Input: [-1,2]
	//Output: false
	//Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
	
	//�������� ����Ŭ ����� �ϳ��� return false�϶��?
	
	//1���� �����ص� 1->2->1->2 ...���ݾ�
	
	//Input: [-2,1,-1,-2,-2]
	//Output: false
	//Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
	
	//�̰͵� 1->2->1->2->... �ȵȵ���
	
	//��
	
	//[3,1,2] ���� 1->2�� loop����Ŭ�� �����  2�ϱ� okay��
	
	//[-2,1,-1,-2,-2]���� 1->2�� loop����Ŭ�� ����� 2�ϱ� �Ǳ� �ϴµ�, �߰��� �ڷΰ��°� �־ �ȵȴٴ¸�����?
	
	public boolean circularArrayLoop(int[] nums) {
        if(nums.length == 0) return false;
        Set<Integer> s = new HashSet<>();
        boolean pos = nums[0] > 0 ? true : false;

        for(int i = 0, j = 0; ; ){
            if(!s.add(i)){
                if(i == j || i+nums[i] == j) return false; //�Ѱ����� �ݺ��ǰų�(ex. [-1,2]), �ΰ����� �ݺ��Ǵ� ���(ex. [-2,1,-1,-2,-2] 1->2->1->2->...) ����ó��
                if(s.size() > 1){
                    return true;
                } else {
                    return false;
                }
            }
            
            j = i;
            
            //i�� �������� �Ѿ ��, nums�� �������� ��� ��쿡 ���� ����ó��
            if(i+nums[i] >= nums.length){
                i = (i+nums[i])-(nums.length);
            } else if(i+nums[i] < 0){
                i = nums.length + (i+nums[i]);
            } else {
                i += nums[i];
            }
            if(pos != (nums[i] > 0)) return false;
        }
    }
	*/
	
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 80 ms, faster than 7.96% of Java online submissions for Circular Array Loop.
	//Memory Usage: 39.5 MB, less than 10.77% of Java online submissions for Circular Array Loop.
	
    public boolean circularArrayLoop(int[] nums) {
        int idx = 0;
        while(idx < nums.length){
            Set<Integer> s = new HashSet<>();
            boolean pos = nums[idx] > 0 ? true : false;
            
            for(int i = idx, j = 0, n = nums.length; ; ){
                if(!s.add(i)){
                    if(i == j) break; //x->x->x-> ...����
                    return true;
                }
                j = i;
                
                i = (n+ (i+nums[i]) % n) % n; //i+nums[i]�� nums�� ����� �ʰ��ϵ� ���̳ʽ� ���̴�, nums.length���� ���� ������ ������� ����. 
                
                if(pos != (nums[i] > 0)) break; //��ȣ�� �ٸ��� Ȯ��. ���̳ʽ��� ��� ���̳ʽ����� �ϰ�, �÷����� ��� �÷������� Ȯ��
            }
            idx++;
        }
        return false;
    }
}
