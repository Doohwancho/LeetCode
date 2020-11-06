package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII210 {
	
	//<����Ǯ��1 by tankztc>
	
	//��
	
	//������ �����, a�� �������� b,c,d�� ���� �Ѵ�. �̷������� ���� �ƴ϶� �Ųٷ�
	
	//b�� ���� a�� ���� �� ����. c�� ���� a�� ���� �� ����. d�� ���� a�� ���� �� ����. �̷������� �ٲ� ��, map�� ������,
	
	//int[] p ���� 0�� �ֵ�, map�� key�� �������� �ʴ� �ֵ�, �ƹ��͵� �ȵ� �ٷ� ���� �� �ִ� �ֵ��� ���, �ű⼭����
	
	//��ĭ�� bfs�� �������鼭, üũ�ϸ� ��.
	
	//numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
	
	//�̰��� ���, �� ��� �����߳ĸ�
	
	//0 -> 
	//1 -> 0
	//2 -> 0
	//3 -> 1, 2
	
	//�׷��� 0���� �����ϸ�, 1�̶� 2�� ���ؾ� �ϴµ�, ���� 2�� 1�� prerequisite�Ѵٰ� ���� ��, 2�� 1���� ��� ���� ���� �� ���� ����߾���.
	
	//�ٵ� ���Ĺ���� tankztcó�� �Ųٷ� ������,
	
	//0 -> 1,2
	//1 -> 3
	//2 -> 3
	//3
	
	//�̸��ǰ�, �ƹ� ��������� ���� 0���� �����ϸ�, ������ 1�̶� 2�� ���µ�, �Ѿ�� 1�̶� 2�� p[1], p[2]�� ���� �ϳ��� ����.
	
	//�����ؾ��ϴ� 0�� �̹� ���������ϱ�. �� ��, p[1]�̳� p[2]�߿� 0�ξְ� ������, ���̻� �����Ҿְ� ���ٴ� ���̴ϱ�,
	
	//q�� �����ְ� �ᱹ rst[i] = p[n]�� �ǰ� ��.
	
	//���� iscycle�̸�, return new int[0]
	
	//Runtime: 5 ms, faster than 70.73% of Java online submissions for Course Schedule II.
	//Memory Usage: 39.7 MB, less than 5.12% of Java online submissions for Course Schedule II.
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] p = new int[numCourses];
        
        for(int[] pr : prerequisites){
            if(!map.containsKey(pr[1])){
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
            p[pr[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] rst = new int[numCourses];
        int idx = 0;
        int cnt = 0;
        
        for(int i = 0; i < numCourses; i++){
            if(p[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int key = q.poll();
            
            if(map.containsKey(key)){
                for(int child : map.get(key)){
                    if(--p[child] == 0){
                        q.offer(child);
                    }
                }
            }
            rst[idx++] = key;
            cnt++;
        }
        
        return cnt == numCourses ? rst : new int[0];
    }
}
