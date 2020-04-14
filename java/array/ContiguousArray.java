package thirtyDayChallenge;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	/*
	//<Trial01>
	
	// find the maximum length of a contiguous subarray with equal number of 0 and 1.
	
	//�̶�淡, 000111�̳� 00001111, 111000 ���� �ɷη� �پ��ִ°͸� �Ǵ��� �˾Ҵµ�
	
	//010101�� �ǰ� 100011�� �Ǵ°ſ���. �� 1�̶� 0���ڸ� ������ �嶯�̳�
	
    public int findMaxLength(int[] nums) {
        Stack st = new Stack();
        int rst = 0;
        
        for(int i = 0, j = 0;i < nums.length; i++){
            if(st.isEmpty()){
                st.push(nums[i]);
            } else{
                if((int)st.peek()!=nums[i]){
                    j+=2;
                    st.pop();
                } else {
                    st.push(nums[i]);
                    j = 0;
                }
            }
            rst = Math.max(rst, j);
        }
        return rst;
    }
    */
	
	//<����Ǯ�� by shawngao>
	
	//0�� -1�� �ٲ�. �׷� -1������ 1������ +-���δϱ� ����ϱ� �� ����
	
	//{0,0,1,0,0,1,1}; �̰� testcase�� ������
	
	//sumToIndex: {0=-1, -1=0} sum:  -1   max: 0 
	//sumToIndex: {0=-1, -1=0, -2=1} sum:  -2   max: 0 
	//sumToIndex: {0=-1, -1=0, -2=1} sum:  -1   max: 2 
	//sumToIndex: {0=-1, -1=0, -2=1} sum:  -2   max: 2 
	//sumToIndex: {0=-1, -1=0, -2=1, -3=4} sum:  -3   max: 2 
	//sumToIndex: {0=-1, -1=0, -2=1, -3=4} sum:  -2   max: 4 
	//sumToIndex: {0=-1, -1=0, -2=1, -3=4} sum:  -1   max: 6 
	
	//�� iterate���� map�� max�� �̷������� ����.
	
	//0�� ������ sum�� �ϳ��� ���̰� 1�̳����� �ٽ� +1��. 
	
	//sum�� ������ ������ �� ��, ������ �ѹ� ���Դٸ�, 0�� 1�� �� ��ٴ� ���̹Ƿ�, max�� ������Ʈ ������ 
	
	//���� for loop�� ����Ű�� �ε��� i�� �� ó�� �Ȱ��� sum�� ���Դ� ���� ����.
	
	//�� ó���̾�� �ϴ� ������ 'maximum' contiguous subarray���� �ϴϱ�.
	

	//555 / 555 test cases passed.
	//Status: Accepted
	//Runtime: 19 ms
	//Memory Usage: 49.4 MB
	
    public static int findMaxLength(int[] nums) {
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
    
    public static void main(String[] args) {
		int[] test = {0,0,1,0,0,1,1};
		System.out.println(findMaxLength(test));
	}
	
	
}
