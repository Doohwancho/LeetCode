package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeStates802 {

	
	//<Trial01 - Time Limit Exceeded>
	
	//[[1,2],[2,3],[5],[0],[5],[],[]] �̰� �Ǵµ�
	
	//[[],[0,2,3,4],[3],[4],[]]  
	
	//[[0],[2,3,4],[3,4],[0,4],[]] ���� ����
	
    private boolean dfs(List<List<Integer>> bundle, boolean[] visited, boolean[] isCycle, int idx, int p){
        
        if(visited[idx]){
            isCycle[idx] = true;
            return true;
        }
        
        for(int i = idx; i < bundle.size(); i++){
            visited[i] = true;
            for(int ele : bundle.get(i)){
                if(dfs(bundle, visited, isCycle, ele, i)){
                    isCycle[i] = true;
                }; 
            }  
            visited[i] = false;
            if(idx < p) return false;
        }
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> bundle = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            List<Integer> tmp = new LinkedList<>();
            for(int ele : graph[i]){
                tmp.add(ele);
            }
            bundle.add(tmp);
        }
        
        boolean[] visited = new boolean[graph.length];
        boolean[] isCycle = new boolean[graph.length];
        
        dfs(bundle, visited, isCycle, 0, 0);
        
        List<Integer> rst = new ArrayList<>();
        for(int i = 0; i < isCycle.length; i++){
            if(!isCycle[i]){
                rst.add(i);
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��1 by kevincongcc>
    
    //0 = ���� �ȵ鸥 ������ ���
    //1 = �̹� �ѹ� �鸥��. 
    //2 = ���� �鸣�� �ִ� ���� ��
    
    //color[start]�� 2�� ��ٴ°�, isCycle�̶�� ���̹Ƿ�, return false�ؼ� res.add(i)���� ����.
    
    //���ٰ� color[start]�� 1�� ���ٴ°�, ������ i�� �鸥���� ������ isCycle�� �ƴϾ��ٴ� ��. �׷��Ƿ� �н��ϰ� ������ iterate��. 
    
    //Runtime: 4 ms, faster than 99.23% of Java online submissions for Find Eventual Safe States.
    //Memory Usage: 49.1 MB, less than 11.56% of Java online submissions for Find Eventual Safe States.
    
    public boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0) return color[start] == 1;
        color[start] = 2;
        for(int i = 0; i < graph[start].length; i++){
            if(!dfs(graph, graph[start][i], color)){
                return false;
            };
        }
        color[start] = 1;
        
        return true;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)  return res;
        
        int nodeCount = graph.length;
        int[] color = new int[nodeCount];
        
        for(int i = 0;i < nodeCount;i++){
            if(dfs(graph, i, color))    res.add(i);
        }
        
        return res;
    }
}
