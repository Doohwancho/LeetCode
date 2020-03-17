package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1380 {
	
	/*
	//<Trial01>
	  
	//hashtable
	
	//random���� ����
	
	//.iterator()������ 
	
	//Returns an iterator over the elements in this set. The elements are returned in no particular order (unless this set is an instance of someclass that provides a guarantee).
	
	//�̶� random�ϰ� ��ȯ�ϴ��� �˾Ҵµ� �ƴϳ�? �����Ÿ� �ֱ���â ��ȯ�ϳ�?
	
	//(unless this set is an instance of someclass that provides a guarantee) �̰� �����ε�
	
	class RandomizedSet {

	    Set<Integer> container;
	    
	    public RandomizedSet() {
	        container = new HashSet<>();
	        
	    }
	    
	    public boolean insert(int val) {
	        return container.add(val);
	    }
	    
	    public boolean remove(int val) {
	        return container.remove(val);
	    }
	    
	    public int getRandom() {
	        return container.iterator().next();
	    }
	}
	*/
	//<����Ǯ��1 by balint>
	
	//hashtable+arraylist
	
	//Runtime: 8 ms, faster than 80.49% of Java online submissions for Insert Delete GetRandom O(1).
	//Memory Usage: 45.2 MB, less than 84.00% of Java online submissions for Insert Delete GetRandom O(1).
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rnd = new Random();
    
    InsertDeleteGetRandomO1380(){
    	System.out.println(123);
    }

    public boolean insert(int val) { //self-explanatory
        if(map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        //�ٷ� �Ʒ��ڵ带 ���� Ǯ� ��
        
		//int indexToRemove = map.get(val);
		//int valueLast = list.get(list.size() - 1);
		
		//// update list -> shuffle
		//list.set(indexToRemove, valueLast);
		//list.remove(list.size() - 1);
		
		//// update map
		//map.put(valueLast, indexToRemove);
		//map.remove(val);
        
        
        int idx = map.remove(val);//.remove() returns either 1. the previous value associated with key, 2. or null if there was no mapping for key.
        int last = list.remove(list.size() - 1); //.remove(index) .remove returns the element previously at the specified position(last prev_element)
        if(val != last) { 
            list.set(idx, last); 
            map.put(last, idx); 
        }
        return true;
    }
    
    public int getRandom() {
        return list.get(rnd.nextInt(list.size())); //random.nextInt(10) �ϸ� 0���� 9(10-1)������ ���ڸ� �����ϰ� ��ȯ
    }
    
    public static void main(String[] args) {
		
	}
}

