package thirtyDayChallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	
	/*
	//<Trial01>
	
	//�Ӹ������ͳ�
	
    public int lastStoneWeight(int[] stones) {
        int[] c = new int[1001];
        for(int i : stones) c[i]++;
        int rst = 0;
        int i = 1000;
        while(i > 0){
            if(c[i] > 0){
                if(c[i] % 2 == 1){
                    if(rst == 0){
                        rst = i;
                        i--;
                    } else {
                        if(rst-i >= i){
                            rst = rst-i;
                            c[i]--;
                            if(c[i] == 0) i--;
                        } else {
                            c[rst-i]++;
                            rst = 0;
                            i--;
                        }
                    }
                }
                else {
                    if(rst == 0){
                        i--;
                        continue;
                    } else {
                        if(rst-i > i){
                            rst = rst-i;
                            c[i]--;
                        } else {
                            c[rst-i]++;
                            rst = i;
                            i--;
                        }
                    }
                }
            } else {
                i--;
            }
        }
        return rst; 
    }
    */
	
    
    //<����Ǯ��1 by Olsh>
    
    //�ȶ�����
	
	//priority queue�� �̿��� �������� ���ڸ� �ְ�, ū������ �ΰ��� �̾� ���� �ٸ��� �� ���̸� priority queue�� ����ִ� ���
	
	//70 / 70 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
    //Memory Usage: 37.1 MB	
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a)); //same as Comparator.reverseOrder()
        for(int i : stones) pq.add(i);
        while(pq.size() > 1){
            int i1= pq.poll();
            int i2= pq.poll();
            if(i1!=i2) pq.add(Math.abs(i1-i2));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
