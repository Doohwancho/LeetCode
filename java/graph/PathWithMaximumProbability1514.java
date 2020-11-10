package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class PathWithMaximumProbability1514 {
	
	
	//<Trial01>
	
//	5
//	[[2,3],[1,2],[3,4],[1,3],[1,4],[0,1],[2,4],[0,4],[0,2]]
//	[0.06,0.26,0.49,0.25,0.2,0.64,0.23,0.21,0.77]
//	0
//	3
	
	//�̰� �н� �ϴµ�..

    private void draw(double[] a){
        for(double a_ : a){
            System.out.print(a_+" ");
        }
        System.out.println();
    }
    
    private void draw(boolean[] a){
        for(boolean a_ : a){
            System.out.print(a_+" ");
        }
        System.out.println();
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double cost = succProb[i];
            
            if(map.get(from) == null){
                map.put(from, new HashMap<>());
            }
            map.get(from).put(to, cost);
        }
        
        int curr = start;
        // double next = Integer.MIN_VALUE;
        
        boolean[] visited = new boolean[n];
        
        double[] prob = new double[n];
        Arrays.fill(prob, -100);
        prob[curr] = 1;
        
        for(int i = 0; i < n; i++){
            visited[curr] = true;
            
            double nextProb = Integer.MIN_VALUE; 
            // int next = curr;
            
            if(map.containsKey(curr)){
                // System.out.println("a: "+curr);
                for(int child : map.get(curr).keySet()){
                    double cost = map.get(curr).get(child);    
                    prob[child] = Math.max(prob[child], prob[curr] * cost);
                    // System.out.println("b: "+child+" cost: "+cost+" prob[curr] * cost: "+ (prob[curr] * cost));
                    
                    // if(!visited[child] && map.get(curr).get(child) > nextProb){
                    //     nextProb = map.get(curr).get(child);
                    //     next = child;
                    // }
                }
            }
            
            // prob[next] = prob[curr] * nextProb;
            // curr = next;
            
            for(int j = 0; j < n; j++){
                if(!visited[j] && prob[j] > nextProb){
                    nextProb = prob[j];
                    curr = j;
                }
            }
            
            // System.out.println("curr: "+curr);
            // draw(visited);
            // draw(prob);
            
        }
        
        return prob[end] == -100 ? 0 : prob[end]; 
    }
    
    
    //<Trial02>
    
    //undirected graph��� �ؼ� �ܹ������� �˾Ҵµ� ��浵 ġ������
    
	//5
	//[[1,4],[2,4],[0,4],[0,3],[0,2],[2,3]]
	//[0.37,0.17,0.93,0.23,0.39,0.04]
	//3
	//4
    
    //�̰� �ȉ�µ� from-> to���� to->from�� �߰��ϴ� ���ư�.
    
    //�ٵ� 
    
	//10
	//[[0,3],[1,7],[1,2],[0,9]]
	//[0.31,0.9,0.86,0.36]
	//2
	//3
    
    //���� ������?
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double cost = succProb[i];
            
            if(map.get(from) == null){
                map.put(from, new HashMap<>());
            }
            map.get(from).put(to, cost);
            
            if(map.get(to) == null){
                map.put(to, new HashMap<>());
            }
            map.get(to).put(from, cost);    
        }
        
        int curr = start;
        
        boolean[] visited = new boolean[n];
        
        double[] prob = new double[n];
        Arrays.fill(prob, -100);
        prob[curr] = 1;
        
        for(int i = 0; i < n; i++){
            visited[curr] = true;
            double nextProb = Integer.MIN_VALUE; 
            
            if(map.containsKey(curr)){
                // System.out.println("a: "+curr);
                for(int child : map.get(curr).keySet()){
                    double cost = map.get(curr).get(child);    
                    prob[child] = Math.max(prob[child], prob[curr] * cost);
                }
            }
            for(int j = 0; j < n; j++){
                if(!visited[j] && prob[j] > nextProb){
                    nextProb = prob[j];
                    curr = j;
                }
            }
        }
        
        return prob[end] == -100 ? 0 : prob[end]; 
    }
    
    
    
    //<����Ǯ��1>
    
    //Dijkstra's Algo
    
    //brute-force
    
    //� �볻������ ��ȭ��?
    
    //Runtime: 1464 ms, faster than 5.18% of Java online submissions for Path with Maximum Probability.
    //Memory Usage: 51.5 MB, less than 5.18% of Java online submissions for Path with Maximum Probability.
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double cost = succProb[i];
            
            if(map.get(from) == null){
                map.put(from, new HashMap<>());
            }
            map.get(from).put(to, cost);
            
            if(map.get(to) == null){
                map.put(to, new HashMap<>());
            }
            map.get(to).put(from, cost);    
        }
        
        int curr = start;
        
        boolean[] visited = new boolean[n];
        
        double[] prob = new double[n];
        Arrays.fill(prob, -100);
        prob[curr] = 1;
        
        for(int i = 0; i < n; i++){
            visited[curr] = true;
            double nextProb = Integer.MIN_VALUE; 
            
            if(map.containsKey(curr)){
                for(int child : map.get(curr).keySet()){
                    double cost = map.get(curr).get(child);    
                    prob[child] = Math.max(prob[child], prob[curr] * cost);
                }
            }
            for(int j = 0; j < n; j++){
                if(!visited[j] && prob[j] > nextProb){
                    nextProb = prob[j];
                    curr = j;
                }
            }
        }
        
        return prob[end] < 0 ? 0 : prob[end]; 
    }
    
    
    
    
    
    //<Trial03>
    
    //brute force���� ����ȭ �õ���.
    
	//if(n-- == 0) return �� ��������, �̹� �������� �ߺ��ؼ� ���� ��쿡�� n-1�� �Ǽ�, ����� �׷����� �� �����ʾҴµ��� �߰��� ���ϵǾ����� 0�� ��ȯ��.
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double cost = succProb[i];

            if(map.get(from) == null){
                map.put(from, new HashMap<>());
            }
            map.get(from).put(to, cost);

            if(map.get(to) == null){
                map.put(to, new HashMap<>());
            }
            map.get(to).put(from, cost);
        }
    
        Map<Integer, Double> prob = new HashMap<>();
        prob.put(start, 1.0);
    
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b)->((int)Math.signum(b[0]-a[0]))); //.signum()�� �Է°��� ��ȣ�� 1, 0, -1�� �ٲ�
        pq.offer(new double[]{1.0, start});
    
        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            
            if(--n == 0) return prob.getOrDefault(end, 0.0);
            
            if(map.containsKey((int)curr[1])){
                for(int next : map.get((int)curr[1]).keySet()){
                    double cost = map.get((int)curr[1]).get(next);    
                    pq.offer(new double[]{prob.get((int)curr[1]) * cost, next});
                    
                    prob.put(next, Math.max(prob.getOrDefault(next, 0.0), prob.get((int)curr[1]) * cost));
                }
            }
        }
        
        return 0.0;
    }

    
    //<Dijkstra - optimized>
    
    //brute-force -> if visited, skip!
    
    //���� ���� �����̳���
    
    //Runtime: 79 ms, faster than 37.40% of Java online submissions for Path with Maximum Probability.
    //Memory Usage: 57.2 MB, less than 5.15% of Java online submissions for Path with Maximum Probability.
    
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double cost = succProb[i];

            if(map.get(from) == null){
                map.put(from, new HashMap<>());
            }
            map.get(from).put(to, cost);

            if(map.get(to) == null){
                map.put(to, new HashMap<>());
            }
            map.get(to).put(from, cost);
        }
    
        Set<Integer> visited = new HashSet<>(n);
    
        Map<Integer, Double> prob = new HashMap<>();
        prob.put(start, 1.0);
    
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b)->((int)Math.signum(b[1]-a[1]))); //.signum()�� �Է°��� ��ȣ�� 1, 0, -1�� �ٲ�
        pq.offer(new double[]{start, 1.0});
    
        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            
            if(!visited.add((int)curr[0])) continue;
                
            if((int)curr[0] == end) return curr[1]; //greedy����̱� ������, ù������ �� ū Ȯ��
            
            if(map.containsKey((int)curr[0])){
                for(int next : map.get((int)curr[0]).keySet()){
                    double cost = map.get((int)curr[0]).getOrDefault(next, 0.0); 
                    if(cost > 0 && !visited.contains(next)){
                        pq.offer(new double[]{next, prob.get((int)curr[0]) * cost});
                        prob.put(next, Math.max(prob.getOrDefault(next, 0.0), prob.get((int)curr[0]) * cost));
                    }
                }
            }
        }
        return 0.0;   
    }
    
    //<Bellman-ford>
    
    //���� ���Ƴ�
    
    //�̰� �� iterate���� ��ü ��带 ��ĭ�� ���������ִϱ� �ξ� ������ ������
    
    //���ͽ�Ʈ��� �ణ dfsó�� �����ִ� �ѳ��(probability�� ���� ���ٴ� ���� ��)�� �Ѷ��Ѷ� ���µ�
    
    //Runtime: 10 ms, faster than 99.05% of Java online submissions for Path with Maximum Probability.
    //Memory Usage: 50.4 MB, less than 5.15% of Java online submissions for Path with Maximum Probability.
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] cost = new double[n];
        cost[start] = 1;
        
        for(int i = 0; i < n-1; i++){ //you need (n-1) iteration at most(at worst-case-scenario), for bellman-ford. b/c you're updating every node on every iteration. worse-case-scenario would be singly-linked graph: a->b->c, where you have to update one by one on each iteartion. 
            boolean flag = true; //if you haven't updated anything on this iteration, you can break it out. because it will otherwise be meaningless, not updating anything afterward.
            for(int j = 0; j < edges.length; j++){
                if(cost[edges[j][0]] < cost[edges[j][1]] * succProb[j]){
                    cost[edges[j][0]] = cost[edges[j][1]] * succProb[j];
                    flag = false;
                }
                if(cost[edges[j][1]] < cost[edges[j][0]] * succProb[j]){
                    cost[edges[j][1]] = cost[edges[j][0]] * succProb[j];
                    flag = false;
                }
            }
            if(flag) break;
        }
        
        return cost[end];
    }
}
