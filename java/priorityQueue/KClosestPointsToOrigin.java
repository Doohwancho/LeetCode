package mayChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KClosestPointsToOrigin {
	
	
	//<����Ǯ��1>
	
	//treemap�� ������ key�� �ڵ����� �������� �������شٴ°� �̿��� ���
	
	//Runtime: 43 ms
	//Memory Usage: 49 MB
	
    public static int[][] kClosest(int[][] points, int K) {
        int[][] rst = new int[K][2];
		TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
		
        for(int[] p : points){
        	int key = p[0]*p[0] + p[1]*p[1];
        	if(tm.containsKey(key)) {
        		List<int[]> tmp = tm.get(key);
        		tmp.add(p);
        		tm.put(key, tmp);
        	} else {
        		List<int[]> tmp = new ArrayList<>();
        		tmp.add(p);
        		tm.put(p[0]*p[0] + p[1]*p[1], tmp);
        	}
        }
        
        int i = 0;
        while(i < K) {
        	List<int[]> tmp = tm.pollFirstEntry().getValue();
        	int j = 0;
        	while(i < K && j < tmp.size()) {
        		rst[i] = tmp.get(j);
        		i++;
        		j++;
        	}
        }
        
        return rst;
        
    }
    
    
	
    //<����Ǯ��2 by lee215>
    
    //Arrays, Comparator�� ���� �޼���� ���ٸ� �� Ȱ���� �� �˸�, �����͵� �̷��� ª�� ������ �����ϳ�.
    
    //Runtime: 39 ms
    //Memory Usage: 47.8 MB
    
    public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
    
	
	//<����Ǯ��3 by asurana28>
	
	//priority queue���. 
	
	//������ ������������ �ְ�, ����� K�̻��� �ʿ�� ������, ����� K�� �ʰ��Ҷ����� ���� ū�� �ϳ��� ���� ���.
	
	//����Ǯ��2ó�� �������� ���ο� array�ȸ��� �Ǽ� ������
	
	//�� �ű������� .toArray()��, ���� �ΰ��� �̻��ϴ�. new int[0][0]�� �ֳ�? ��?
	
	//1. List�� toArray �޼��忡 �Ķ���ͷ� �Ѿ�� �迭 ��ü�� size��ŭ�� �迭�� ��ȯ�Ѵ�.
	//2. ��, �ش� List size�� ���ڷ� �Ѿ�� �迭 ��ü�� size���� Ŭ��, �ش� List�� size�� �迭�� ���������.
	//3. �ݴ�� �ش� List size�� ���ڷ� �Ѿ�� �迭��ü�� size���� ��������, ���ڷ� �Ѿ�� �迭��ü�� size�� �迭�� ���������.
	
	//int[][] points = {{3,3},{5,-1},{-2,4}}; �̰� �ְ� K�� 2��, pq�� ����� 2����?
	
	//�׷� ���ڷ� ���� int[0][0]�� ������� �� ũ�ϱ�, �� ���� ���� pq�� ����� ��.
	
	//�ٵ� ���࿡ ��ǲ�� [[1,3],[-2,2]], 1�ε�, return pq.toArray(new int[2][]); �� �ߴ�?
	
	//�׷� ������ [[-2,2]] �� ���;� �Ǵµ�, int[2][]�� ���� 2�� [[-2,2]]�� ������ int[1][]�� 1���� �� ũ�ϱ�
	
	//[[-2,2],null]�� ��ȯ�� ����. �׷��� ������.
	
	//.toArray()�� ���� new int[n][]��, priority queue -> list��ȯ�� ����� �������ִ� ��Ҵ�.
	
	//Runtime: 18 ms
	//Memory Usage: 47.9 MB
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));

        for(int[] po : points) {
        	pq.add(po);
        	if(pq.size()>K) pq.poll();
        }
        return pq.toArray(new int[0][0]);
    }
	
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int K = 2;
		
//		int[][] points = {{0,1},{1,0}};
//		int K = 2;
		
		System.out.println(kClosest(points, K));
	}
}
