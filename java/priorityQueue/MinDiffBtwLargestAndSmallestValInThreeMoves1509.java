package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinDiffBtwLargestAndSmallestValInThreeMoves1509 {

	
	//<Trial01>
	
	//input : [6,6,0,1,1,4,6]
	
	//Output : 5
	//Expected : 2
	
	//�� ���ڴ� �󵵼��� �̰�
	
	//�󵵼��� �� ������ ������ 3�� ������ ��
	
	//���� �ֵ��� �ִ�-�ּڰ� �ϸ� �� �� �˾Ҵµ�,
	
	//input�� [6,6,0,1,1,4,6] �϶� �� ����� ����
	
	//0,4,1�� ���ŵǼ� [6,6,1,6]�� ����
	
	//4�� �ѹ��ۿ� �ȳ��Ծ �츮�� 0,1,1�� ���־� �ϴµ�..
	
	class Freq{
        int num, freq;
        Freq(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    
    public int minDifference(int[] nums) {
        PriorityQueue<Freq> pq = new PriorityQueue<>((a,b)->a.freq-b.freq);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        for(int key : map.keySet()){
            pq.offer(new Freq(key, map.get(key)));
        }
        
        int cnt = 3;
        while(cnt > 0 && !pq.isEmpty()){    
            Freq tmp = pq.poll();
            if(tmp.freq > cnt){
                cnt = 0;
                tmp.freq -= cnt;
                pq.offer(tmp);
            } else {
                cnt -= tmp.freq;
            }
        }
        
        
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            int val = pq.poll().num;
            largest = Math.max(largest, val);
            smallest = Math.min(smallest, val);
        }
        
        return largest-smallest;
    }
    
    
    //<����Ǯ��1 by lee215>
    
    //���������� Ǭ ���
    
    //O(quick sort)
    
    //Explanation
	//We have 4 plans:
	
	//kill 3 biggest elements
	//kill 2 biggest elements + 1 smallest elements
	//kill 1 biggest elements + 2 smallest elements
	//kill 3 smallest elements
	
	//Example from @himanshusingh11:
	
	//A = [1,5,6,13,14,15,16,17]
	//n = 8
	
	//Case 1: kill 3 biggest elements
	
	//All three biggest elements can be replaced with 14
	//[1,5,6,13,14,15,16,17] -> [1,5,6,13,14,14,14,14] == can be written as A[n-4] - A[0] == (14-1 = 13)
	
	//Case 2: kill 2 biggest elements + 1 smallest elements
	
	//[1,5,6,13,14,15,16,17] -> [5,5,6,13,14,15,15,15] == can be written as A[n-3] - A[1] == (15-5 = 10)
	
	//Case 3: kill 1 biggest elements + 2 smallest elements
	
	//[1,5,6,13,14,15,16,17] -> [6,6,6,13,14,15,16,16] == can be written as A[n-2] - A[2] == (16-6 = 10)
	
	//Case 4: kill 3 smallest elements
	
	//[1,5,6,13,14,15,16,17] -> [13,13,13,13,14,15,16,17] == can be written as A[n-1] - A[3] == (17-13 = 4)
	
	//Answer is minimum of all these cases!
    
    //Runtime: 19 ms, faster than 75.56% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    //Memory Usage: 59.1 MB, less than 100.00% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    
    public int minDifference(int[] A) {
        int n = A.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }
    
    
    //<����Ǯ��2 by logan138>
    
    //dfs�� Ǭ ���
    
    //������ �� ����...���� �ʱ���? pq���� �κ�����?
    
    //Runtime: 20 ms, faster than 60.25% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    //Memory Usage: 55 MB, less than 100.00% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    private int dfs(int[] nums, int left, int right, int bound){
        if(bound == 0) return nums[right]-nums[left];
        bound--;
        return Math.min(dfs(nums, left+1,right,bound),dfs(nums,left,right-1,bound));
    }
    
    public int minDifference(int[] nums) {
        int left = 0, right = nums.length-1;
        if(right <= 3) return 0;
        Arrays.sort(nums);
        return dfs(nums, left, right, 3);
    }
    
    //<����Ǯ��3 by mayank12559>
    
    //priority queue�� Ǭ ���
    
    //O(n + 4log4)
    
    //Runtime: 48 ms, faster than 5.65% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    //Memory Usage: 68.9 MB, less than 100.00% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    
    public int minDifference(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue();
        PriorityQueue<Integer> min = new PriorityQueue(Collections.reverseOrder());
        for(int i: nums){
            if(max.size() < 4){
                max.add(i);
                min.add(i);
            }else{
                max.add(Math.max(max.poll(), i)); //���� ū ���� 4�� 
                min.add(Math.min(min.poll(), i)); //���� ���� ���� 4�� �������� ����
                //max : [4,6,6,6]
                //min : [4,1,1,0]
            }
        }
        List<Integer> al = new ArrayList();
        while(!min.isEmpty()){ //���� ���� ���� 4�� ����Ʈ�� ����(����)
            al.add(min.poll()); //al : [4,1,1,0]
        }
        int ans = Integer.MAX_VALUE;
        for(int i=al.size()-1;i>=0;i--){
            ans = Math.min(ans, max.poll() - al.get(i)); //���� ū �����߿� �� �����ֶ�, ���� �������߿��� �� ū�ֶ� ���� �߿� �� �����ְ� ��.
            //input : [6,6,0,1,1,4,6]
            //max : [4,6,6,6]
            //min : [0,1,1,4]
            //(4-0),(6-1),(6-1),(6-4) -> 2 is smallest
            
            //�� (��ū���� 3��°, ���� ������), (��ū���� 2��°, 2��°�� ������ )... ��� 4�� �� �ϳĸ�
            //����Ǯ�� 1�� ������ ����.
        }
        return ans;
    }
    
    
    
    //<����Ǯ��3.5 by mayank12559>
    
    //���� min pq������ ��ٷ� �ְ� �װ� �� arraylist�� �ְ� �ڿ��� ���� �ʿ䰡 ��� ���� ����ȭ��.
    
    public int minDifference(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue();
        PriorityQueue<Integer> min = new PriorityQueue();
        for(int i: nums){
            min.add(i);
            if(max.size() < 4){
                max.add(i);
            }else{
                max.add(Math.max(max.poll(), i));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0, cnt = 0; i < min.size() && cnt < 4;i++, cnt++){
            ans = Math.min(ans, max.poll() - min.poll());
        }
        return ans;
    }
}
