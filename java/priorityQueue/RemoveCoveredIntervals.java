package october;

import java.util.PriorityQueue;

public class RemoveCoveredIntervals {
	
	//<Trial01>
	
	//iterate�ϸ鼭 i>j��, j�� null�� �ٲٰ�, i<j�� i=j �� j=null��Ű�� �ٽ� ó������ ���� ���.
	
	//�������� null�� ���� �ֵ��� ���� ū �����ϱ� �³׵鸸 �̴� ���
	
	//�ε� ������ input������ �ȵǳ�. � �ȳ����� �ֵ��� �н��ϴµ�..
	
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        
        for(int i = 0; i < len; i++){
            int[] I = intervals[i];
            int j = i+1;
            
            if(I != null){
                while(j < len && intervals[j] != null){
                    int[] J = intervals[j];
                    if(i == j){
                        j++;
                        continue;
                    }
                    else if(I[0] <= J[0] && J[1] <= I[1]){
                        intervals[j] = null;
                    } else if(J[0] <= I[0] && I[1] <= J[1]){
                        I[0] = J[0];
                        I[1] = J[1];
                        intervals[j] = null;
                        j = i-1;
                    }
                    j++;
                }
            }
        }
        
        
        int rst = 0;
        for(int[] inter : intervals){
            if(inter != null){
                rst++;
            }
        }
        return rst;
    }
    
    
    
    //<Trial02>
    
    //� ���� �� �Դµ� ������ while������ ������
    
    //�̰� �ȵǴ� ������ [1,2] -> [1,4]�� ��,
    
    //���ʾְ� �Ȱ����ְ� ������ else if���� �Ȱɷ��� �ϰ͵� ���ϳ�..
    
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        for(int[] inter : intervals){
            pq.offer(inter);
        }
        
        int rst = 0;
        int[] prev = null;
        
        while(pq.size() > 0){
            int[] curr = pq.poll();
            
            if(prev == null){
                prev = curr;
            }
            else if(curr[1] > prev[1] && curr[0] > prev[0]){
                prev = curr;
                rst++;
            } 
        }
        return rst;
    }
    
    
    //<����Ǯ��1 by lee215>
    
    //���� �ְ� ������������ ���ĵǼ� Ƣ���.
    
    //�̶� pq.poll()�� ������ �ְ� ������ �������� ���ʾֺ��� Ŀ�� ��.
    
    //curr[1]�� ����� �ϸ�, curr[0]�� ������ �۱� ������ �����ֿ� ���ԵǱ� ����.
    
    //�׷��� r = Math.max(curr[1], r)���ִ� ��.
    
    //if(curr[1] > r && curr[0] > l) �� if���� �ɸ��� ���ο� ������ �ְ� ���´ٴ� ���̴ϱ�,
    
    //left bound�� ������Ʈ ������
    
    //Runtime: 4 ms
    //Memory Usage: 39.8 MB
    
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        for(int[] inter : intervals){
            pq.offer(inter);
        }
        
        int rst = 0;
        int l = -1, r = -1;
        
        while(pq.size() > 0){
            int[] curr = pq.poll();
            
            if(curr[1] > r && curr[0] > l){
                l = curr[0];
                rst++;
            } 
            r = Math.max(curr[1], r);
        }
        return rst;
    }
}
