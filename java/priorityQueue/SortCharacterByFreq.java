package mayChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFreq {
	
	//<����Ǯ��1 by tankztc>
	
	//����Ʈ1) <Map<Character, Intger>>�� �ƴ�, <Map.Entry<Character, Integer>>�̴�.
	
	//����Ʈ2) lambda ((a, b) -> (b.getValue() - a.getValue())
	
	//����Ʈ3) pq.addAll(map); �� �ƴ�, pq.addAll(entrySet());
	
	//����Ʈ4) �׳� for(Map.Entry<Character, Integer> ele : pq)�� ����, �������� ������. �ݵ�� poll()�� ���ָ鼭 ���ƾ� ������ ������� ����
	
	//Runtime: 34 ms
	//Memory Usage: 52.9 MB
	
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();  //���⼭�� Map.Entry<> ����
            for (int i = 0; i < entry.getValue(); ++i) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
    
}
