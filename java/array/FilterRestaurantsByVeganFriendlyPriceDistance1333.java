package array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FilterRestaurantsByVeganFriendlyPriceDistance1333 {
	
	/*
	//<Trial01>
	
	//Return the array of restaurant IDs after filtering, ordered by rating from highest to lowest. For restaurants with the same rating, order them by id from highest to lowest.
	
	//���⼭ ����. container[rating] = id �Ҷ�, rating�� ������ id�� ��������� ���� ����.
	
	//�� ������ �ھ�� �����̳�
	
	//Input
	//[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], 0, 50, 10
	//Output : [4,3,1,5]
	//Expected : [4,3,2,1,5]
	
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> rst = new ArrayList<>();
        int[] container = new int[100000];
        
        if(veganFriendly == 1){
            for(int[] restaurant : restaurants){
                if(restaurant[2] == veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    container[restaurant[1]] = restaurant[0];
                }
            }
        } else {
            for(int[] restaurant : restaurants){
                if(restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    container[restaurant[1]] = restaurant[0];
                }
            }
        }
        
        for(int i = container.length-1; i >= 0; i--){
            if(container[i] > 0){
                rst.add(container[i]);
            }
        }

        return rst;
    }
    */
	
	/*
	//<Trial02>
	
	//�̰͵� ���� input���� ����
	
	//[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]
	
	//���⼭ [2,8,0,50,5] �̰� �ְ� [3,8,1,30,4] �̰� ������, 8�� ���ļ� ����Ǳ� ������ �տ��� ����Ἥ �׷���.
	
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> rst = new LinkedList<>();
        Map<Integer, Integer> treeMap = new TreeMap<>(); //���������� �ڵ����� key�� �����������ĵǼ� ��
        
        if(veganFriendly == 1){
            for(int[] restaurant : restaurants){
                if(restaurant[2] == veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    treeMap.put(restaurant[1], restaurant[0]);
                }
            }
        } else {
            for(int[] restaurant : restaurants){
                if(restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    treeMap.put(restaurant[1], restaurant[0]);
                }
            }
        }
        
        Iterator<Integer> iteratorKey = treeMap.keySet( ).iterator( );

        while(iteratorKey.hasNext()) {
        Integer key = iteratorKey.next();
            rst.add(0, treeMap.get(key));
        }
    
        return rst;
    }
    */
	
	/*
	//<����Ǯ��1>
	
	//if-else������ ���ǻ���(vegan,price,distance)�� �ش��ϴ� �͸� treeMap�� �����Ѵ�.
	
	//hashMap�Ⱦ��� treeMap�� ������, treeMap�� ������ key���� �ڵ����� �������� ���ĵǼ� ���� ������,
	
	//�߿䵵(restaurant[1])�� key������ �ְ�, id�� value������ ������,
	
	//�߿䵵 ������ treeMap�� �̻ڰ� �������� ���ĵǼ� ���� ����.
	
	//�������� �ѹ� �� ������, �߿䵵�� ���� n���� ��������� ������,
	
	//������� ���̵� ū�ͺ��� ��ȯ�϶�� ��.
	
	//trial01�̳� trial02�� ������ �ΰ�, �߿䵵�� ���� ��������� �ߺ��ؼ� ������ ���, ���� ��������� ����°� �������µ�,
	
	//�̰� value���� new ArrayList<>();�� �س��� �ߺ��� ������� ���������� list.add(duplicated new restaurant)���༭ �ذ�.
	
	//Runtime: 6 ms, faster than 73.76% of Java online submissions for Filter Restaurants by Vegan-Friendly, Price and Distance.
	//Memory Usage: 50 MB, less than 100.00% of Java online submissions for Filter Restaurants by Vegan-Friendly, Price and Distance.
	
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> rst = new LinkedList<>();
        Map<Integer, List<Integer>> treeMap = new TreeMap<>(); //���������� �ڵ����� key�� �����������ĵǼ� ��
        
        if(veganFriendly == 1){
            for(int[] restaurant : restaurants){
                if(restaurant[2] == veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    if(treeMap.get(restaurant[1]) != null){
                        treeMap.get(restaurant[1]).add(restaurant[0]);
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(restaurant[0]);
                        treeMap.put(restaurant[1], tmp);
                    }
                }
            }
        } else {
            for(int[] restaurant : restaurants){
                if(restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    if(treeMap.get(restaurant[1]) != null){
                        treeMap.get(restaurant[1]).add(restaurant[0]);
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(restaurant[0]);
                        treeMap.put(restaurant[1], tmp);
                    }
                }
            }
        }
        
        Iterator<Integer> iteratorKey = treeMap.keySet( ).iterator( );

        while(iteratorKey.hasNext()) {
            Integer key = iteratorKey.next();
            List<Integer> tmp = treeMap.get(key);

            if(tmp.size() > 1){
                Collections.sort(tmp);
                
                for(int i = 0; i < tmp.size(); i++){
                    rst.add(0, tmp.get(i));
                }
                
            } else if(tmp.size() == 1) {
                rst.add(0, tmp.get(0));
            }
            
        }
    
        return rst;
    }
    */
	
	//<����Ǯ�� by xiaoxiang615>
	
	//if input : [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], 1, 50, 10
	
	//for�� �� ����, maxHeap�� �ִ� �͵���
	
	//[3 8 1 30 4] 
	//[1 4 1 40 10]
	//[5 1 1 15 1]
	
	
	//Queue�� ���� ������ ���� ���ʴ�� ������ ����.
	
	//priorityQueue��, ���� ������ ��� ���� �켱������ ���� �����Ͱ� ���� ����.
	
	//Queue<int[]> maxHeap = new PriorityQueue<>((a, b)->a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);
	
	//���⼭, (a, b)->a[1] != b[1] ? b[1] - a[1] : b[0] - a[0] �̰� ���ٽ��ε�
	
	//������(a)���� ���߿� ���� ��(b)�� rating(index[1])�� �ٸ� ���,
	
	//b[1]-a[1]�ϰ� ���� +��, �߿䵵�� ���ٴ� ���̴�, �߿䵵�� �������� ���� �����ϴ� PriorityQueue�� �꿡 ���� a���� b�� ������ ���� �����.
	
	//���� b[1]-a[1]�ϰ� ���� -��(���� �� ����. a[1] != b[1] ���ǿ� �¾ƾ� �̰� ����Ǳ� ����), �߿䵵�� ���ٴ� ���̴�, b�� a���� ������ �ڿ� �����.
	
	//���� a�� �߿䵵(a[1])�� b�� �߿䵵(b[1])�� ���ٸ�, b[0] - a[0]�� �Ͽ�, id�� ������ �켱������ �����.
	
	//Runtime: 4 ms, faster than 99.48% of Java online submissions for Filter Restaurants by Vegan-Friendly, Price and Distance.
	//Memory Usage: 50.8 MB, less than 100.00% of Java online submissions for Filter Restaurants by Vegan-Friendly, Price and Distance.
	
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
	    Queue<int[]> maxHeap = new PriorityQueue<>((a, b)->a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]); 
	    for(int[] r : restaurants){
	        if(r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance){ //if-else �Ⱦ��� >=�ϳ��� vegan���� �ذ�. 
	            maxHeap.offer(r);
	        }
	    }
	    List<Integer> res = new ArrayList<>();
	    while(!maxHeap.isEmpty()){
	        res.add(maxHeap.poll()[0]);
	    }
	    return res;
	}
	

}		
