package julyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
	
	
	//<����Ǯ��1>
	
	//��. õ��. ����.
	
	
	//�ִ¼���
	
	//1. �ߺ����� �ʴ� ���� ���Ҹ� �־���. if(i > 0 && nums[i] == nums[i-1]) continue; �̰ɷ� �ߺ�����
	
	//�׷� [[1],[2],[3],[4]] �̷��� ��
	
	//2. ���� 2���� (1st : ������ �ְ� 2���� �����鼭) (2nd: 2�� �ȵ� �ֵ�)�� ������ ��, 2�� �ְ� rst�� �־���
	
	//[1][2][3][4]
	//[1,2]
	//[1,3][2,3][1,2,3]
	//[1,4][2,4][3,4][1,2,4][1,3,4][2,3,4][1,2,3,4]
	//[]
	
	//��������� ����
	
	//�������� �� array[]�� �־���. ��!
	
	//Runtime: 2 ms
	//Memory Usage: 39.8 MB
	
    public List<List<Integer>> subsets(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> rst = new ArrayList<>();
        int len = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            rst.add(tmp);
            len++;
        }
        
        for(int j = 1; j < len; j++){
            if(rst.get(j) == rst.get(j-1)) continue;
            int t = rst.get(j).get(0);
            int idx = 0;
            while(idx < rst.size()){
                List<Integer> prev = rst.get(idx);
                
                if(prev.get(prev.size()-1) < t & !prev.contains(t)){
                    List<Integer> tmp = new ArrayList<>(rst.get(idx));
                    tmp.add(t);
                    rst.add(tmp);
                }
                idx++;
            }
        }
        
        rst.add(new ArrayList<>());
        
        return rst;
    }
    
    
    //<����Ǯ��1 by caikehe?
    
    //dfs
    
    //÷ ���������� ������ ���� ��
    
    //�ε� �� �������
    
	//[[], [1], [1, 2], [1, 2, 3]]
	//[[], [1], [1, 2], [1, 2, 3]]
	//[[], [1], [1, 2], [1, 2, 3], [1, 3]]
	//[[], [1], [1, 2], [1, 2, 3], [1, 3]]
	//[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]
	//[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]
	//[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
	//[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    
    //Runtime: 2 ms
    //Memory Usage: 40.2 MB
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
        ret.add(path);
        for (int i = idx; i < nums.length; i++) {
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            dfs(nums, i+1, p, ret);
        }
    }
}
