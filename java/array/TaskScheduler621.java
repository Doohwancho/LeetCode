package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler621 {
	
	/*
	//<Trial01>
	
	//Input
	//["A","A","A","A","A","A","B","C","D","E","F","G"], 2
	//stdout
	//7 0 7
	//1 2 10
	//1 2 13
	//1 2 16
	//1 2 19
	//1 2 22
	//Output : 20
	//Expected : 16
	
	//['A','B','A','B','A','B']
	//������ �Ǵµ� ��
	
	//���� ���ؾ� �ϴ� ���ĺ� ���ϰ�, ���� idle���� n-cnt+1�ؼ� ���ϰ�, 
	//���� loop���� '���' ���ǽ��� �Ἥ ��� �� loop���� n-cnt��ŭ ���Ѱ� ���ְ�, ��� ����־��ϴµ� �װ� ���� �𸣰��� ����
	
	public int leastInterval(char[] tasks, int n) {
        int[] alphabet = new int[26];
        int rst = 0;
        int cnt = 0;
        int adder = 0;
        
        for(char ch : tasks){
            alphabet[ch-65]++;
        }
        
        do {
            cnt = 0;
            for(int i = 0; i < 26; i++){
                if(alphabet[i] > 0){
                    alphabet[i]--;
                    cnt++;
                }
            }
            
            if(cnt == 0){
                rst -= adder;
                break;
            } 
            adder = n >= cnt ? n-cnt+1 : 0;
            rst += (cnt+adder);
            
        } while(cnt > 0);
        return rst;
    }
    */
	
	//<����Ǯ��1 by alexander>
	
	//priority queue
	
	//�𸣰Ե�..
	
	//input : {'A','A','A','A','B','C','D','E'}, 2
	
	//pq: [4, 1, 1, 1, 1]
	//i: 0 pq.poll(): 4
	//i: 1 pq.poll(): 1
	//i: 2 pq.poll(): 1
	//tmp: [4, 1, 1]
	//pq: [3, 1, 1]
	//worktime:3 alltime: 3
	
	//i: 0 pq.poll(): 3
	//i: 1 pq.poll(): 1
	//i: 2 pq.poll(): 1
	//tmp: [3, 1, 1]
	//pq: [2]
	//worktime:3 alltime: 6
	
	//i: 0 pq.poll(): 2
	//tmp: [2]
	//pq: [1]
	//worktime:1 alltime: 9
	
	//i: 0 pq.poll(): 1
	//tmp: [1]
	//pq: []
	//worktime:1 alltime: 10
	
	//Runtime: 26 ms, faster than 40.29% of Java online submissions for Task Scheduler.
	//Memory Usage: 42.7 MB, less than 5.88% of Java online submissions for Task Scheduler.
	
	public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char t : tasks) {
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.addAll(counts.values()); 

        int alltime = 0;
        int cycle = n + 1; //3
        while (!pq.isEmpty()) {
            int worktime = 0;
            List<Integer> tmp = new ArrayList<Integer>();

            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll()); 
                    worktime++;
                }
            }
            
            for (int cnt : tmp) {
                if (--cnt > 0) {
                    pq.offer(cnt);
                }
            }
            alltime += !pq.isEmpty() ? cycle : worktime; 
        }
        
        return alltime;
    }
	
	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] {'A','A','A','A','B','C','D','E'}, 2));
//		System.out.println(leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
	}
    
}
