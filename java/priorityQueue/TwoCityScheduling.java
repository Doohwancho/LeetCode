package juneChallenge;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TwoCityScheduling {
	
	/*
	//<Trial01>
	
	//a�� b�� �Ÿ����� ������ ������ ������ ���, treemap�� �ߺ����� �ȵ��� ������ �Ǽ� ����.

	//���
	
    public static int twoCitySchedCost(int[][] costs) {
    	
        TreeMap<Integer, int[]> tm = new TreeMap<>();
        
        for(int[] cost : costs){
            tm.put(cost[1] - cost[0], cost);
        }
        
        int rst = 0;
        
        while(!tm.isEmpty()) {
        	rst +=  tm.pollFirstEntry().getValue()[1];
        	rst +=  tm.pollLastEntry().getValue()[0];
        }
        
        return rst;
    }
    */
	
	/*
	//<Trial02>
	
	//� priority queue���� �� ������ ������ ������ �߲ٳ��� ����
	
	//[[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
	
	//631 42    -589
	//457 60    -397
	//650 359    -291
	//515 563    48
	//451 713    262
	//537 709    172
	//855 779    -76
	//343 819    476
	
	//855,799 �� �ű� ���ִ°ų�?
	
	public int twoCitySchedCost(int[][] costs) {
    	int rst = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0] - b[1]) - (a[0] - a[1]));
            
        for(int[] cost : costs){
        	pq.add(cost);
        }
        
        //Iterator iter = pq.iterator();
        int i = 0;
        
        for(int[] p : pq) { //while(iter.hasNext()){}�� ���� ���.
        	if(i < costs.length/2) {
        		rst += p[1];
        	} else {
        		rst += p[0];
        	}
        	i++;
        }
        
        return rst;
    }
	
	*/
	
	
	//<����Ǯ��1 by user2857r>
	
	//���� �����̾���.
	
	//Iterator.hasNext()�� ���� �� �����ϰ� ����
	
	//.poll()�� �� �����ź��� �ϳ��� �̾ƾ� ������� ����.
	
	//�̰͵� ������ trial02�� �Ȱ��� ����
	
	//631 42    -589
	//457 60    -397
	//650 359    -291
	//515 563    48
	//451 713    262
	//537 709    172
	//855 779    -76
	//343 819    476
	
	//Runtime: 1 ms
	//Memory Usage: 37.5 MB
	
    public static int twoCitySchedCost(int[][] costs) {
    	PriorityQueue<int[]> q = new PriorityQueue<>((int[] a,int[] b)->{ 
            return (a[1] - a[0]) - (b[1] - b[0]);
        });
    	
        int count = 0;
        int total = 0;
        for(int[] pair:costs){
            q.offer(pair);
        }
        
        while(q.size()>0){
            int[] pair = q.poll();
            if(count<costs.length/2){
                total+=pair[1];
            }else{
                total+=pair[0];
            }
            count++;
        }
        return total;
    }
    
    
	public static void main(String[] args) {
		int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
		System.out.println(twoCitySchedCost(costs));
	}
}
