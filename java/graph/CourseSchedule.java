package mayChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	
	//<Trial01>
	
	//queue�κп��� ��� ó������ �𸣰ڳ�
	
	//�ٳణ���� set�� �ְ� set.contains()�� �ٳణ���� �� ������ return false �ߴµ�
	
	//���࿡, (1,2),(1,3),(3,4),(4,2),(2,5)
	
	//����, 1->3->4->2->5 ó�� �ƹ� ���� ���µ�, 2�� �ٽ��ѹ� �鸮�� ��쿡�� ����
	
	//�̰� int[]�� ���� ���İ� ���� 1�� ��ũ�ص� ������ ���� �߻�. 
	
	//�Ƥ�������������
	
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> p = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
        	p.add(new ArrayList<>());
        }
    	for(int[] pr : prerequisites) {
    		p.get(pr[0]).add(pr[1]);
    	}
    	int[] c = new int[numCourses];
        for(int i = 1; i < numCourses+1; i++){
        	c[i-1] = i;

            Queue<Integer> q = new LinkedList<>();
            q.add(i-1);
            
            while(!q.isEmpty()) {
            	int cur = q.poll();
            	for(int pr : p.get(cur)) {
            		if(c[pr] != i) {
            			c[pr] = i;
            		}
//            		if(c[pr] == c[cur]) //??
//            		if(c[pr] == 0) {
//            			c[pr] = c[cur] == i ? 2 : 1;
//            		} else {
//            			if(c[pr] == c[cur]) return false;
//            		}
            	}
            }
        }
        return true;
    }
    
    //<����Ǯ��1 by jeantimex>
    
    //trial01�� ����� ������, ��������
    
    //trial01���� ��쿣, (1,2),(1,3)���� ���������� ������� ��쿡 �Ѵ� ����ó����. 
    
    //�ٵ� ����Ǯ��1�� (1,2)����, (1,3) ���� ó����.
    
    ////(1,2),(1,3),(3,4),(4,2),(2,5)����, trial01�� ��쿣,
    
    //�簥��(1,2),(1,3)�� �Ѵ� ���ÿ� üũ�ϱ� ������, 3���� �� �ְ� (3->4),(4->2)ó�� 2�� �����ϸ�, 2�� �ѹ� �����߱� ������(1->2) return false�ϴµ�,
    
    //����Ǯ��1���� ���, (1,2)����, (1,3)���� ó����.
    
    //(1->2) �ϰ� �̻����? �ϸ�, stack[]�� �ٽ� �ʱ�ȭ ��Ű��
    
    //(1->3)�� ���� stack[]�� (1->2)�� ������ ���Ƽ�, (3->4),(4->2)�ص� ��������.
    
    //Runtime: 3 ms
    //Memory Usage: 40.5 MB
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(numCourses);
        
        for (int i = 0; i < numCourses; i++) 
            adjList.add(i, new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; i++)
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        boolean[] visited = new boolean[numCourses];
        
        for (int u = 0; u < numCourses; u++)
            if (hasCycle(adjList, u, visited, new boolean[numCourses]))
                return false;
        
        return true;
    }
    
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, boolean[] stack) {
        if (visited[u]) //stack������ ���� visited�� ���� ������, ������� (1,2),(2,3),(3,4), ... ����, 1->2->3->4�� �����߰� �̻���ٸ�, visited[u] = true�� �ٲ��ݾ�? �ٵ� ���߿� (8->9),(9->1)�� �Ծ�. �ٵ� 1 ���Ŀ� �̹� �����ϴٴ°� ���������ϱ� �� �� �ʿ䰡 ���ݾ�. �׷��� ���°ž�.
            return false;
            
        if (stack[u])  //recursive�� �ѹ� ������� return false�Ѵ�.
            return true;
            
        stack[u] = true;
            
        for (Integer v : adjList.get(u))
            if (hasCycle(adjList, v, visited, stack))
                return true;
        
        visited[u] = true;
        
        return false;
    }
	
	public static void main(String[] args) {
//		int a = 4;
//		int[][] p = {{0,1},{3,1},{1,3},{3,2}};
//		int a = 3;
//		int[][] p = {{1,0},{2,1}};
		int a = 8;
		int[][] p = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
		System.out.println(canFinish(a,p));
	}
}
