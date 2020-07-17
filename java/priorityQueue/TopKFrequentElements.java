package julyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    
    
    //<����Ǯ��1 by mo10>
	
	//��-��
    
    //Runtime: 17 ms
    //Memory Usage: 48.3 MB
    
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] rst = new int[k];

        for (int pos = bucket.length - 1, j = 0; pos >= 0 && j < k; pos--) {
            if (bucket[pos] != null) {
                List<Integer> tmp = bucket[pos];
                for(int i = 0; i < tmp.size(); i++, j++){
                    rst[j] = tmp.get(i);
                }
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by logan138>
    
    //priority queue
    
    //trial�� pq��µ�(int[2]�ؼ� int[0]�� num���� int[1]�� num�� �󵵼���)
    
    //�׶� ������ �� for(int n : nums)�� �־����� ������ �������� ����.
    
    //��ģ���� map.keySet()���� �� element�� �ѹ����� �󵵼� �������� �־ �ߵ尨.
    
    //Runtime: 23 ms
    //Memory Usage: 47.9 MB
    
    class Freq{
        int num, freq;
        Freq(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> m = new HashMap<>();
        for(int n : nums){
            m.put(n, m.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(m.size(), (a,b)-> b.freq - a.freq); //�󵵼� ū�� ������(�ڿ� ���� b.freq�� �տ��ִ� a.freq���� �� ũ��, ����ϱ�, ������ ����)
        
        for(int key : m.keySet()){
            pq.offer(new Freq(key, m.get(key)));
        }
        
        int[] rst = new int[k];
        int idx = 0;
        while(k > 0){
            rst[idx++] = pq.poll().num;
            k--;
        }
        return rst;
    }
}
