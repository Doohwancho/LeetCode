package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class RankTransformOfAnArray1331 {
	/*
	//<Trial01 - Time limit exceeded>
	
	public int[] arrayRankTransform(int[] arr) {
		//step1 - �־��� arr�� Arrays.sort()�� �������� ���ĵ� originalArr ����
        int[] originalArr = new int[arr.length];
        for(int k = 0; k < arr.length; k++){
            originalArr[k] = arr[k];
        }
        Arrays.sort(arr);
        
        //step02 - arr�� for������ �������� ������ ���鼭 ������� originalArr�� rank�� �־���. �̶�, rank�� ���� arr�� ���ҿ� ���� �� �����Ƿ�, ��ġ�� �ʰ� +10000�� ������ 
        for(int i = 0, rank = 1; i < arr.length; i++){
            if(i > 0 && arr[i] != arr[i-1]){
                rank++;
            }
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == originalArr[j]){
                    originalArr[j] = rank+10000;
                    break;
                }
            }
        }
        
        //step03 - ��ġ�� �ʰ� ������� 10000�� ����
        for(int q = 0; q < arr.length; q++){
            originalArr[q] -= 10000;
        }
        
        return originalArr;
    }
    */
	
	/*
	//<����Ǯ��1>
	
	//Runtime: 25 ms, faster than 86.98% of Java online submissions for Rank Transform of an Array.
	//Memory Usage: 55.3 MB, less than 100.00% of Java online submissions for Rank Transform of an Array.
    public int[] arrayRankTransform(int[] arr) {
    	//������������ rank�� �Ű��� ��ųʸ�(��)����
        Map<Integer, Integer> map = new HashMap<>();
        int[] originalArr = new int[arr.length];
        int rank = 1;
        
        //�������� ���ĵ� arr�� ���� ����Ʈ originalArr����
        for(int k = 0; k < arr.length; k++){
            originalArr[k] = arr[k];
        }
        Arrays.sort(arr); //�����غ��� ���� ������ �ٲٴ°� �� �׷��ϱ� ���Ӱ� ���� ����Ʈ�� �����Ҳ�.
        
        //������������ rank�� �ű�
        for(int element : arr){
            if(map.getOrDefault(element, 0) == 0){
                map.put(element, rank++);
            }
        }
        
        //���� ����Ʈ�� ���鼭 ��ųʸ�(��)�� ����� rank�� �Ű���
        for(int i = 0; i < arr.length; i++){
            originalArr[i] = map.get(originalArr[i]);
        }
        
        return originalArr;
    }
    */
	
	
	//<����Ǯ��2 by xiaoxiang615>
	
	//���� ���µ� hashset���� treeset�̶��� �̿��߳�?
	
	//treeset, hashset, linkedhashset ������ �ִٴµ�,
	
	//treeset�� Ư¡�� �����Ҷ� ���� �ٷ� ������. �׷��� ������ �ߴ� Arrays.sort()�� �ʿ䰡 ������.
	
	//Runtime: 44 ms, faster than 65.10% of Java online submissions for Rank Transform of an Array.
	//Memory Usage: 56.7 MB, less than 100.00% of Java online submissions for Rank Transform of an Array.
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> posMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int cnt = 0;
        for(int n : set){
            posMap.put(n, ++cnt);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = posMap.get(arr[i]);
        }
        return arr;
    }
    
    
    /*
    //<Trial02 - time limit exceeded>
    
    //����Ǯ��2�� map�� ���� �ʿ� ������ ���Ƽ� ����׷��µ� �ʿ��ϵ�.
      
    //+- 10000���ص� rank�� arr[i]�� �������� �κ� ó���� ���� 
    
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        int rank = 0;
        
        for(int element : arr){
            set.add(element);
        }
        
        for(int n : set){
            rank++;
            for(int i = 0; i < arr.length; i++){
                if(n == arr[i]){
                    arr[i] = rank+10000;
                }
            }
        }
        
        for(int j = 0; j < arr.length; j++){
            arr[j]-=10000;
        }
        
        return arr;
    }
    */
}
