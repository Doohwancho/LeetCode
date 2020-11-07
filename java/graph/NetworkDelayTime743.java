package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime743 {
	
	//<����Ǯ��1 by alizhiyu46> 
	
	//�ణ bfs������ ���� Dijkstra's algo
	
	//� �Ƹ���ϳ�
	
	//�� pq(a-b)�־���?
	
	//�׽�Ʈ ���̽�
	
	//[[1,2,1],[2,3,2],[1,3,4]]
	//3
	//1
	
	//����, pq�Ⱦ��� linkedlist����,
	
	//3�� �ƴ϶� 4�� ����. �ٵ� ������ How long will it take for all nodes to receive the signal? �ݾ�
	
	//1->3 ���µ� 4�ʰɸ���
	
	//1->2->3���µ� 1+2���ؼ� 3�ʰɸ���, 4�ʵ� ���� �ʳ�?
	
	//pq�� ���� ���� ���� �� ���ַ� ���� ���� �ϴµ�,
	
	//���� �ʰ� �ɸ��ٰ� �ؼ� node������ ���ٴ� ���嵵 ���� �� �Ƹ���ϳ�

	
	//Runtime: 31 ms, faster than 23.93% of Java online submissions for Network Delay Time.
	//Memory Usage: 43.9 MB, less than 5.98% of Java online submissions for Network Delay Time.
	
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] t : times){
            if(map.get(t[0]) == null){
                map.put(t[0], new HashMap<>());
            }
            map.get(t[0]).put(t[1], t[2]); 
        }
        
        boolean[] visited = new boolean[N+1];
        int rst = 0;
        
        Queue<int[]> q = new PriorityQueue<>((a,b) -> (a[0] - b[0])); //��������
        q.add(new int[]{0, K});    
    
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int curr = pos[1];
            int accCost = pos[0];
            
            if(visited[curr] == true) continue;
            visited[curr] = true;
            
            rst = accCost;
            N--;
            if(N == 0) return rst;
            else if(N < 0) return -1;
            
            if(map.containsKey(curr)){
                for(int next : map.get(curr).keySet()){
                    int nextCost = map.get(curr).get(next);
                    q.offer(new int[] { accCost + nextCost, next });
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
    	Queue<int[]> q = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
    	
    	q.add(new int[] {100, 2});
    	q.add(new int[] {0, 1});
    	
    	
    	while(!q.isEmpty()) {
    		int[] tmp = q.poll();
    		System.out.println(tmp[0]+" "+tmp[1]);
    	}
	}
}
