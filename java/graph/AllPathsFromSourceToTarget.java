package julyChallenge;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	
	
	//<����Ǯ��1 by stevenlli>
	
	//dfs
	
	//Runtime: 2 ms
	//Memory Usage: 40.9 MB
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();

		path.add(0);
		dfsSearch(graph, 0, res, path);

		return res;
	}

	private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
		if (node == graph.length - 1) { //������ ������ ������ path�� rst�� ������
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int nextNode : graph[node]) {
			path.add(nextNode); //���±濡 �ϳ� ����
			dfsSearch(graph, nextNode, res, path); //�ش���� �̾ ��. ������ �� ���� path�� rst�� �ְ���
			path.remove(path.size() - 1); //�ٽ� ���ƿͼ� ���� ��� �߰��Ѱ� ����. [[1,2], [3], [3], []] ���� 1Ÿ�� ������ ���� rst�� �־�����, 1 ����� [0,2]���� �ٽ� �����ؾ���.
		}
	}

}
