package juneChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1 {
	
	
	//<����Ǯ��1>
	
	//��..���� �����ɸ���?
	
	//getRandom()�Լ����� set->list�� �ٲٰ� Collection.shuffle()��� �����Լ��� ��
	
	//Runtime: 698 ms
	//Memory Usage: 46.1 MB
	class RandomizedSet {

	    Set<Integer> set;
	    
	    public RandomizedSet() {
	        set = new HashSet<>();
	    }
	    
	    public boolean insert(int val) {
	        return set.add(val);
	    }
	    
	    public boolean remove(int val) {
	        return set.remove(val);
	    }
	    
	    public int getRandom() {
	        List<Integer> asList = new ArrayList(set);
	        Collections.shuffle(asList);
	        return asList.get(0);
	    }
	}
	
	
	//<����Ǯ��2>
	
	//�� 650ms �� ������
	
	//����
	
	//�̰ͺ��� �� �� �� �� �ֳ�?
	
	//Runtime: 41 ms
	//Memory Usage: 44.6 MB
	
	class RandomizedSet {

	    Set<Integer> set;
	    List<Integer> list;
        Random rand;
    
	    public RandomizedSet() {
	        set = new HashSet<>();
	        list = new ArrayList<>();
            rand = new Random();
	    }
	    
	    public boolean insert(int val) {
	        if(set.add(val)){
	            return list.add(val);   
	        } else {
	            return false;
	        }
	    }
	    
	    public boolean remove(int val) {
	        if(set.remove(val)){
	            return list.remove((Integer)val);
	        } else {
	            return false;
	        }
	    }
	    
	    public int getRandom() {
	        return list.get(rand.nextInt(list.size()));
	    }
	}
	
	
	//<����Ǯ��3 by balint>
	
	//¥��! ���ϴ� ����� �־����ϴ�!
	
	//Runtime: 8 ms
	//Memory Usage: 44.4 MB
	
	
	public class RandomizedSet {

	    Map<Integer, Integer> map = new HashMap<>();
	    List<Integer> list = new ArrayList<>();
	    Random rnd = new Random();

	    public boolean insert(int val) {
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
	        
	        int idx = map.remove(val); //map.remove(key) returns the value previously associated with the key
	        int last = list.remove(list.size() - 1);
	        if(val != last) { //���� �������� ���°� val�̸�, if�� �ǳʶٰ� return true, �װ� �ƴϸ�, 
	            list.set(idx, last); //����Ʈ�� ���� �ٽ� �ְ�
	            map.put(last, idx); //val�� �ִ� �ڸ��� list�� �� �������� �ִ�(list.remove()�� ����) last�� �ھƳ���
	        }
	        return true;
	    }
	    
	    public int getRandom() {
	        return list.get(rnd.nextInt(list.size()));
	    }
	}
}
