package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals1481 {
	
	//<����Ǯ��1 by mandaliak>
	
	//map�� {����:�󵵼�}�� �ְ�, priorityqueue�� �󵵼� ��� �������� ���� ��,
	
	//k-�󵵼��� �ϴ� ���
	
	//Runtime: 99 ms, faster than 77.87% of Java online submissions for Least Number of Unique Integers after K Removals.
	//Memory Usage: 49.8 MB, less than 50.00% of Java online submissions for Least Number of Unique Integers after K Removals.
	
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int a : arr){
            m.put(a, m.getOrDefault(a, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue()); //value(��)���� �������� ����
        pq.addAll(m.entrySet()); //�׳� pq.addAll(map)�� �ƴ϶�, pq.addAll(map.entrySet())�̳�
        
        while(!pq.isEmpty() && k-- > 0){
            Map.Entry<Integer, Integer> entry = pq.remove(); //.remove()�� ���� ���Ľ�Ų��� �̻ڰ� ���´�. �׸��� Map.Entry<>Ÿ������ ����. 
            int ev = entry.getValue();
            if(ev > 1){
                entry.setValue(ev-1);
                pq.add(entry);
            }
        }
        return pq.size();
    }
}
