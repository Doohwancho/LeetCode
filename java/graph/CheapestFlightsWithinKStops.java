package juneChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	
	
	//<Trial01 - time limit exceeded>
	
	//graph
	
	//�Ʊ�����~~~~~~~~~~~~~~~~
	
	//�� �ߴµ�.
	
	//graph�� �Ẹ�� ��վ���
	
	class Graph{
        List<Map<Integer,Integer>> g;
        
        public Graph(int n){
            g = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                g.add(new HashMap<>());
            }
        }
        
        public void put(int x, int y, int cost){
            Map<Integer, Integer> m = g.get(x);
            m.put(y, cost);
        }
        
        public int search(int src, int dst, int k, int cost){
            if(k < 0) return Integer.MAX_VALUE;
            else if(src == dst) return cost;
            
            int rst = Integer.MAX_VALUE;
            
            for(Map.Entry<Integer, Integer> m : g.get(src).entrySet()) {
                rst = Math.min(rst, search(m.getKey(), dst, k-1, cost + m.getValue())); 
            }
            return rst;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Graph gr = new Graph(n);
        
        for(int[] flight : flights){
            gr.put(flight[0],flight[1],flight[2]);
        }
        int rst = gr.search(src, dst, K+1, 0); 
        
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }
    
    
    //<����Ǯ��1 by lee215>
    
    //Dijkstra's algorithm
    
    //�׷������� �ּҰŸ� �Ÿ� ���ϴ� �˰����̶��.
    
    //https://en.wikipedia.org/wiki/Dijkstra's_algorithm
    
    //Runtime: 14 ms
    //Memory Usage: 41.2 MB
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, src, k + 1});
        while (!pq.isEmpty()) { 
            int[] top = pq.remove(); //trial01�� time limit�� �߰� �̰� �ȶߴ� ���� : priority queue�� cost�� �ּڰ��ΰ��� �켱������ ���� ����ϰ�, ������ ������ �ٷ� return price���ֱ� ����. �ݸ� ����§�� ��� ��带 k�� -1�� �ɶ����� �ٵ���. �����?
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}
