package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MaximumLengthOfPairChain {

	/*
	//<Trial01>
	
	//dp
	
	//{1=[4], 2=[3, 6], 3=[4], 4=[5], 6=[7], 8=[9]}
	//begin: 6 key: 6 nextVal: 7 nextKey: 8
	//0 0 0 0 0 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0  
	//begin: 1 key: 1 nextVal: 4 nextKey: 6
	//0 3 0 0 0 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 4 key: 4 nextVal: 5 nextKey: 6
	//0 3 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 4 key: 6 nextVal: 7 nextKey: 8
	//0 3 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 1 key: 2 nextVal: 3 nextKey: 4
	//0 4 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 1 key: 2 nextVal: 6 nextKey: 8
	//0 4 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 1 key: 3 nextVal: 4 nextKey: 6
	//0 4 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 1 key: 4 nextVal: 5 nextKey: 6
	//0 4 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//begin: 1 key: 6 nextVal: 7 nextKey: 8
	//0 4 0 0 3 0 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
	//4
	
	//testcase�� �������ͼ� mem[����]�ϸ� ������
	
	//�������ī�ΰ�?
	
	//���������� memoization ��°�ϳ�? 
	
	//�� ���� ���� �����༭ �ּڰ��� 0�� ����ٰ� �ص�, Integer.MIN_VALUE�� Integer.MAX_VALUE���ÿ� ������ ���ϴ°žƳ�?
	
    static int[] mem = new int[10000001];
    static TreeMap<Integer,List<Integer>> tm = new TreeMap<>();
    
    public static int dp(int begin) {
    	if(mem[begin] != 0) return mem[begin];
    	
        for (Entry<Integer, List<Integer>> entry : tm.entrySet()) {
        	if(entry.getKey() >= begin) {
        		for(Integer nextVal : entry.getValue()) {
	        		Integer nextKey = tm.higherKey(nextVal);
		        	if(nextKey == null) {
		        		return mem[begin] = Math.max(mem[begin], 1);
		        	}
		        	mem[begin] = Math.max(mem[begin], dp(nextKey)+1);
	        	}	
        	}
        }
        return mem[begin];
    }
    
    public static int findLongestChain(int[][] pairs) {
        for(int[] p : pairs){
        	if(!tm.containsKey(p[0])){
                tm.put(p[0], new ArrayList<>());        		
        	}
        	tm.get(p[0]).add(p[1]);
        }
        
        dp(tm.firstKey());

        return mem[tm.firstKey()];
    }
    */
	
	/*
	//<Trial02>
	
	//123 / 202 test cases passed.
	
	//int[] -> map�غôµ� 
	
	//[[-1,1],[-2,7],[-5,8],[-3,8],[1,3],[-2,9],[-5,2]] ���� ����
	
	//key: -9 value: [8]
	//key: -6 value: [9, -2]
	//key: -5 value: [3]
	//key: -1 value: [4]
	//key: 0 value: [3]
	//key: 1 value: [6]
	//key: 8 value: [10]
	
	//���⿡�� -9 -> 8 ���� ��, 8���� �� ū Ű�� ���� ������, �ٷ� 1�� ��ȯ�ؼ� �׷�.
	
	//ù loop�� ������ �� ���ƾ� �Ѵٴ°� �־���� �ϴµ� ��....
	
	static void drawMap(){
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
		}
		System.out.println("========================");
	}
	
	static void drawTreeMap(){
		for (Entry<Integer, List<Integer>> entry : tm.entrySet()) {
			System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
		}
		System.out.println("========================");
	}
	
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeMap<Integer,List<Integer>> tm = new TreeMap<>();
    
    public static int dp(int begin) {
    	if(map.get(begin) != -1) return map.get(begin);
    	
        for (Entry<Integer, List<Integer>> entry : tm.entrySet()) {
        	if(entry.getKey() >= begin) {
        		for(Integer nextVal : entry.getValue()) {
	        		Integer nextKey = tm.higherKey(nextVal);
	        		if(nextKey == null) {
	        			if(begin == tm.firstKey()) continue;
	        			map.put(begin, Math.max(map.get(begin), 1)); 
		        		return map.get(begin);
	        		}
		        	map.put(begin, Math.max(map.get(begin), dp(nextKey)+1));
		        	drawMap();
	        	}	
        	}
        }
        return map.get(begin);
    }
    
    public static int findLongestChain(int[][] pairs) {
        for(int[] p : pairs){
        	if(p.length == 0) continue;
        	if(!tm.containsKey(p[0])){
                tm.put(p[0], new ArrayList<>());        		
        	}
        	tm.get(p[0]).add(p[1]);
        	map.put(p[0], -1);
        	map.put(p[1], -1);
        }
        drawTreeMap();
        
        dp(tm.firstKey());

        int rst = map.get(tm.firstKey());
        
        return rst <= 0 ? 1 : rst;
    }
    */
	
	
	//<����Ǯ��1>
	
	//dp
	
	//Runtime: 692 ms, faster than 5.06% of Java online submissions for Maximum Length of Pair Chain.
	//Memory Usage: 39.3 MB, less than 64.08% of Java online submissions for Maximum Length of Pair Chain.

	
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeMap<Integer,List<Integer>> tm = new TreeMap<>();
    
    public static int dp(Integer begin) {
    	if(begin == null) return 0;
    	if(map.get(begin) != -1) return map.get(begin);
    	
        for (Entry<Integer, List<Integer>> entry : tm.entrySet()) {
        	if(entry.getKey() >= begin) {
        		for(Integer nextVal : entry.getValue()) {
		        	map.put(begin, Math.max(map.get(begin), dp(tm.higherKey(nextVal))+1));
	        	}	
        	}
        }
        return map.get(begin);
    }
    
    public static int findLongestChain(int[][] pairs) {
        for(int[] p : pairs){
        	if(p.length == 0) continue;
        	if(!tm.containsKey(p[0])){
                tm.put(p[0], new ArrayList<>());        		
        	}
        	tm.get(p[0]).add(p[1]);
        	map.put(p[0], -1);
        	map.put(p[1], -1);
        }
        dp(tm.firstKey());
        
        return map.get(tm.firstKey());
    }
    
    
    
    //<����Ǯ��2 by buptqiu>
    
    //���� dp�� ��Ǯ��� �������� �־���
    
    //Runtime: 12 ms, faster than 56.89% of Java online submissions for Maximum Length of Pair Chain.
    //Memory Usage: 39.1 MB, less than 77.50% of Java online submissions for Maximum Length of Pair Chain.
    
    public int findLongestChain(int[][] pairs) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i =0;i<pairs.length;i++){
            int end = map.getOrDefault(pairs[i][0], Integer.MAX_VALUE);
            if(pairs[i][1]<end){
                map.put(pairs[i][0], pairs[i][1]);
            }
        }
        int preEnd = Integer.MIN_VALUE;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int start = entry.getKey();
            int end = entry.getValue();
            if(start>preEnd){
                count++;
                preEnd = end;
            }else if(end<preEnd){
                preEnd = end;
            }
        }
        return count;
    }
    
    
    //<����Ǯ��3 by shawngao>
    
    //����Ǯ��2�� �ణ ���� ����
    
    //Runtime: 37 ms, faster than 41.58% of Java online submissions for Maximum Length of Pair Chain.
    //Memory Usage: 39.3 MB, less than 64.08% of Java online submissions for Maximum Length of Pair Chain.
    
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        
        int i, j, max = 0, n = pairs.length;
        int dp[] = new int[n];
      
        for (i = 0; i < n; i++) dp[i] = 1;
        
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        for (i = 0; i < n; i++) if (max < dp[i]) max = dp[i];
        
        return max;
    }
    
    
    
    //<����Ǯ��4 by Galileo_Galilei>
    
    //�̹���� ���� ������� ���� �������Ⱑ ���� ����ϳ�
    
    //Runtime: 9 ms, faster than 83.75% of Java online submissions for Maximum Length of Pair Chain.
    //Memory Usage: 39.1 MB, less than 87.99% of Java online submissions for Maximum Length of Pair Chain.
    
    public int findLongestChain(int[][] pairs) {
        if(pairs==null||pairs.length==0) return 0;
        int n = pairs.length;
        Arrays.sort(pairs,new Comparator<int[]>(){
            public int compare(int [] o1,int [] o2){
                return o1[1] - o2[1];
            }
        });
        int num = 1;
        int i = 1;
        int index = 0;
        while(i<n){
            if(pairs[i][0]>pairs[index][1]){
                index = i;
                num++;
            }
            i++;
        }
        return num;
    }
    
    
    
    
    public static void main(String[] args) {
//    	int[][] pairs = {{1,2},{2,3},{3,4}};
//    	int[][] pairs = {{-10,-8},{8,9},{-5,0},{6,10},{1,7},{9,10},{-4,7},{}};
//    	int[][] pairs = {{8,9},{2,3},{2,6},{3,4},{4,5},{6,7},{1,4}};
//    	int[][] pairs = {{9,10},{-4,9},{-5,6},{-5,9},{8,9}}; 
//    	int[][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};  //-6,-2   0,3   8, 10
    	//[[-1,1],[-2,7],[-5,8],[-3,8],[1,3],[-2,9],[-5,2]]
//    	int[][] pairs = {{-1,1},{-2,7},{-5,8},{-3,8},{1,3},{-2,9},{-5,2}};
//    	int[][] pairs = {{},};
    	int[][] pairs = {{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
    	
    	System.out.println(findLongestChain(pairs));
	}
}
