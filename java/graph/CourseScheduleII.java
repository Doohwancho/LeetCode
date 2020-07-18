package julyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
	
	//<Trial01>
	
	//�� �𸣰ڴ� dfs�Ҷ�׷��µ� ��򸮳�

	private List<Integer> helper(Map<Integer, List<Integer>> map, List<Integer> list, int numCourses, int pre) {
		if (!map.containsKey(pre))
			return null;
		List<Integer> tmp = new ArrayList<>(list);

		for (int nextCourse : map.get(pre)) {
			tmp.add(nextCourse);
			if (map.containsKey(nextCourse) && map.get(nextCourse).contains(pre))
				return null;
			if (tmp.size() == numCourses)
				return tmp;
			tmp = helper(map, tmp, numCourses, nextCourse);
		}
		return null;
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>(); // prerequisite : courses

		for (int[] pr : prerequisites) {
			if (map.containsKey(pr[1])) {
				List<Integer> tmp = map.get(pr[1]);
				tmp.add(pr[0]);
				map.put(pr[1], tmp);
			} else {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(pr[0]);
				map.put(pr[1], tmp);
			}
		}
		if (prerequisites == null || prerequisites.length == 0) {
			int[] rst = new int[numCourses];

			for (int i = 0; i < numCourses; i++) {
				rst[i] = i;
			}
			return rst;

		} else {
			for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(entry.getKey());

				List<Integer> temp = helper(map, tmp, numCourses, entry.getKey());

				if (temp != null && temp.size() != 0) {
					int[] rst = new int[numCourses];
					int i = 0;
					while (i < numCourses) {
						rst[i] = temp.get(i);
						i++;
					}
					return rst;
				}
			}
		}
		return new int[0];
	}

    
    
    //<����Ǯ��1 by jianwu>
    
	//queue
	
    //Runtime: 4 ms
	//Memory Usage: 45.9 MB
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] result = new int[numCourses];
    	int[] preCnt = new int[numCourses]; //prerequisites �ʿ��� Ŭ�������� ����
    	List<Integer>[] nextSet = new List[numCourses]; //i�� prerequisites��. value�� i�� take�ϸ� ���� �� �ִ� Ŭ������.
    	for(int i=0; i<numCourses; i++)
    		nextSet[i] = new ArrayList<>();

    	for(int[] p : prerequisites) {
    		preCnt[p[0]]++;  
    		nextSet[p[1]].add(p[0]);
    	}

    	Queue<Integer> sourceNode = new LinkedList<Integer>(); 
    	for(int i=0; i<numCourses; i++)
    		if(preCnt[i] == 0)
    			sourceNode.add(i); //prerequisites�ʿ� ���� Ŭ�������� ������. �곻�� ������ ��� �곻���� �����Ұ�.
    	
    	for(int i=0; i<numCourses; i++) {
    		if(sourceNode.isEmpty()) //��� prerequisites�� �ʿ��ϸ�, �׷����� ��� ���Ƶ� ���� ��忡 ���ƿ��� ������ return null.
    			return new int[0];
    		int n = sourceNode.poll(); //prerequisites�ʿ� ���� Ŭ�������� ����
    		result[i] = n; //n���� ����
    		for(int next : nextSet[n]) { //n�� ������ ���� �� �ִ� Ŭ�������� next
    			preCnt[next]--; //n�� ������ ���� �� �ִ� ��� Ŭ������ ����� ���� �ϳ��� ��� 0�̵Ǹ� ���� node�� ������. [1,0],[2,0]�̸�, 1�̶� 2 �� ������忡 ������. ��¥�� [1,2]ó�� ���� �������� �ʾƼ� 1,2,��ġ�� �� ���� ���°�. 
    			if(preCnt[next] == 0) //���߿� �ϳ��� 0�̵Ǹ�, 
    				sourceNode.add(next); //node�� ����Ÿ�� ������.
    		}
    	}
    	return result;
    }
}
