package october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	
	//<����Ǯ��1>
	
	//backtracking
	
	//Runtime: 5 ms
	//Memory Usage: 41.1 MB
    private void dfs(List<List<Integer>> rst, List<Integer> tmp, int[] candidates, int rest, int idx){
        if(rest < 0){ //��� ��� iterate��, list�� �� ���� target�� �Ѿ������, �����ϰ� dfs(i+1)
            return;
        }
        if(rest == 0){
            rst.add(new ArrayList<>(tmp)); //rid rst.add(tmp);�ϸ� �ּڰ��� �Ѱ��ֱ� ������, ���� iterate�� tmp.add()�� ���� �� �߰��ǰų�, tmp.remove()�� ���� ����.
            return;
        }
        for(int i = idx; i < candidates.length; i++){ //��� ��� �� iterate
            tmp.add(candidates[i]);
            dfs(rst, tmp, candidates, rest-candidates[i], i);
            tmp.remove(tmp.size()-1);    
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst, new ArrayList<>(), candidates, target, 0);
        return rst;
    }
    
    
    //<����Ǯ��2 by shpolsky>
    
    //dp
	
	//int[] cand= {2,3,5};
	//int t = 8;

	//[[]]
	//[[], [[2]]]
	//[[], [[2]], [[3]]]
	//[[], [[2]], [[3]], [[2, 2]]]
	//[[], [[2]], [[3]], [[2, 2]], [[2, 3], [5]]]
	//[[], [[2]], [[3]], [[2, 2]], [[2, 3], [5]], [[2, 2, 2], [3, 3]]]
	//[[], [[2]], [[3]], [[2, 2]], [[2, 3], [5]], [[2, 2, 2], [3, 3]], [[2, 2, 3], [2, 5]]]
	//[[], [[2]], [[3]], [[2, 2]], [[2, 3], [5]], [[2, 2, 2], [3, 3]], [[2, 2, 3], [2, 5]], [[2, 2, 2, 2], [2, 3, 3], [3, 5]]]
	//[[2, 2, 2, 2], [2, 3, 3], [3, 5]]
	
	//������� 1,2,3,4,5,6,7,8
	
	//������� ���̴ϱ� dp.get(i-cands[j]-1)�� ������ ��
	
	//2,3,5���� if (i == cands[j]) �� �ɸ�
	
	//4�����ְ� �ɷ�����, 4-i(2) �ؼ� 2 ä������. if (cands[j] <= l.get(0))�� �ɸ��ڳ�
	
	//if (cands[j] <= l.get(0)) �̰� ������, target�� 5�϶�, 2->3�ѹ�, 3->2�ѹ��ؼ� [2,3],[3,2] �ߺ����� �ö�.
	
	//�׷��� Arrays.sort()�ϰ� ���� ��.
    
    //Runtime: 13 ms
    //Memory Usage: 45.9 MB
    
    public static List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); 
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { 
            List<List<Integer>> newList = new ArrayList(); 
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                if (i == cands[j]) {
                	newList.add(Arrays.asList(cands[j]));
                }
                else {
                	for (List<Integer> l : dp.get(i-cands[j]-1)) {
                		if (cands[j] <= l.get(0)) { 
                            List cl = new ArrayList<>();
                            cl.add(cands[j]); 
                            cl.addAll(l);
                            newList.add(cl);
                        }
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}
