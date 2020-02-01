package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
	
	/*
	//<Trial01>
	
	//combination���ϴ°�, k�� 3�̸� 3�� for��, k�� 4�� 4�� for��,
	
	//�̷������� �����ϱ� ��ͷ� k�� �ϳ��� ��鼭 for���� ���� k�������� ������?
	 
	//k�� 3�̸�, ù��° �ι�° loop�� ���� container�� ���ųְ� ��Ÿĥ�� n - total of container�� ���� ���� ������?
	  
	//��Ÿ�� �ȸ������� �ٽ� ���� stack���� ���ƿͼ� loop���� ����������? 
	
	//��� �����ߴµ� ������ ���� �����
	
	//combination���� n�ε�, ��·�� ������ ������ k�̹Ƿ�, k�������� ����Ʈ�� ����� �����Դ°� ������ �����̾��� �� ����
	
	//�ٸ� ���� ��Ϳ���� ���°� stack overflow���� �ٺ����� ���ΰͰ�����. ����
	
	private void recursive(List<List<Integer>> rst, int[] container, int n, int idx, int k, int prev){
        if(k > 0){
            if(k == 1){
                int total = 0;
                for(int element : container){
                    total += element;
                }
                if(n-total < 10 && n-total > prev-1){
                    container[idx] = n-total;
                    List<Integer> list = new ArrayList<>();
                    for(int element : container){
                        list.add(element);
                    }
                    rst.add(list);
                }
            } else {
                container[idx] = prev;
                recursive(rst, container, n, idx++, k-1, prev+1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<>();
        int[] container = new int[k];
        recursive(rst, container, n, 0, k, 1);
        return rst;
    }
    */
	
	//<����Ǯ�� by caikehe>
	
	//�� �ȶ��̵� ���� �뷫 ���� �������� ������ �� ������ ������Ŵ. �� �λ�
	
	//int[k]�Ⱦ��� ArrayList�� k�ϳ��� ��鼭 stack��ĭ�� ������������ �� �����ְ�, ���ϰ� �����ؼ� List<Integer> p = new ArrayList<>(path); ����� ��
	
	//nums�� ���� �� ���� �𸣰���. �� p.add(i+1)�ϸ� �Ǵ� �� ������.
	
	//�Ķ���Ϳ� n-(i+1)�̶�.
			
	//Runtime: 1 ms, faster than 55.66% of Java online submissions for Combination Sum III.
	//Memory Usage: 37.7 MB, less than 6.00% of Java online submissions for Combination Sum III.
	
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<Integer> nums = new ArrayList<>();
	    for (int i = 1; i <= 9; i++) {
	        nums.add(i);
	    }
	    List<List<Integer>> ret = new ArrayList<>();
	    dfs(nums, k, n, 0, new ArrayList<>(), ret);
	    return ret;
	}

	private void dfs(List<Integer> nums, int k, int n, int idx, List<Integer> path, List<List<Integer>> ret) {
	    if (k <= 0 && n <= 0) {
	        if (k == 0 && n == 0) {
	            ret.add(path);
	        }
	        return; // backtracking
	    }
	    for (int i = idx; i < nums.size(); i++) {
	        List<Integer> p = new ArrayList<>(path); //��Ͷ� path�Ѱ�ٰ� �ٽ� ���� stack���� �����ϴ� �������� path�� ���ϰ��� ������ ���ο� arraylist���� �Ű��ִ� ����
	        p.add(nums.get(i));
	        dfs(nums, k-1, n-nums.get(i), i+1, p, ret);
	    }
	}

}
