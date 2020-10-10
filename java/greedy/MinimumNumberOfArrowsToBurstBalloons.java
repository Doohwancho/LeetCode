package october;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfArrowsToBurstBalloons {

	//<Trial01>
	
	//[[1,2],[3,4],[5,6],[7,8]]
	
	//��׵��� �����ִ°� �ƴ϶� �����ִ� �ֵ��̴ϱ� 1�� �ƴ϶� 4�� ���;� ���� ��
	
	//���Ծȵǳ� ����.....����......����!!!
	
    public int findMinArrowShots(int[][] points) {
        int[] c = new int[10001];
        
        for(int[] point : points){
            for(int i = point[0]; i <= point[1]; i++){
                c[i]++;
            }
        }
        
        int rst = 0;
        boolean flag = false;
        for(int i = 0; i < 10001; ){
            while(i < 10001 && c[i] == 0){ i++; flag = false;}
            while(i < 10001 && c[i] > 0) { i++; flag = true; }
            if(flag) { rst++; }
        }
        return rst;
    }
    
    
    
    //<Trial02>
    
    //priority queue�� point[0]�� �ֵ� ���� �������� ������ ����,
    
    //for������ pq�� �ϳ��ϳ� ���鼭
    
    //�ڵ��� ���� �ְ� �տ� �ֶ� �Ȱ�ġ��, +1�� ���ִ� ���
    
    //�����Ŷ�� �����ߴµ� 
    
    //[[10,16],[2,8],[1,6],[7,12]] ���� �����ŵ�
    
    //�� �����ĸ�, pq�� ������ 
    
    //[1,6],[2,8],[7,12],[10,16]
    
    //�̷� ���ĵ��ݾ�? point[0]���ִ� ������������
    
    //�ٵ� ��״� �� �ָ�~�ϰ� ��ģ �ֵ��װŵ�?
    
    //6�� �ѹ�, 10�� �ѹ� �� 2���� �ʿ��ѵ�, �Ʒ� �Լ� ������, �ϴ� �� ���ļ� �̾��� �ֱ� �ϴϱ�, �ϳ��� ū ����κ��� 1�� ��ȯ��.
    
    //�׷��� ���� ���̰�
    
    
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int[] point : points){
            pq.offer(point);
        }
        
        int rst = 1;
        int[] prev = pq.poll();
        
        while(pq.size() > 0){
            int[] curr = pq.poll();
            if(prev[1] < curr[0]){
                rst++;
            } 
            prev = curr;
        }
        
        return rst;
    }
    
    
    //<Trial03>
    
    //���� ���� �ٿ°Ű���
    
    //[[10,16],[2,8],[1,6],[7,12]] �긦 pq�� ������
    
    //[1,6],[2,8],[7,12],[10,16] �̷��� ���ĵ��ݾ�?
    
    //prev = [1,6], �� �������� curr = [2,8] �̶�� ��������
    
    //��� ���� ��ġ��? ��ġ���� ���δ� prev[1] < curr[0]�� �� �� ����. 2���� 6����.
    
    //��ġ��, ��ġ�� �����߿� ���� ������ �ָ� ����� �ҰžƳ�?
    
    //2~6���� ���� ������ ���� 6�� �����, �״��� [7,12]�� �� ��ġ���� ����,
    
    //��ġ�� rst+1���ϰ� �� �Ѿ��, �Ȱ�ġ�� ���ο� ȭ���� �ʿ��ϴ� ���̴ϱ� rst+1���ָ� ���ݾ�.
    
    //���� �� õ�鰡?
    
    //[[-2147483646,-2147483645],[2147483646,2147483647]]
    
    //�ٵ� �̷� ���� ������ ����
    
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int[] point : points){
            pq.offer(point);
        }
        
        int rst = 1;
        int prev = pq.poll()[1];
        
        while(pq.size() > 0){
            int[] curr = pq.poll();
            if(prev < curr[0]){
                rst++;
                prev = curr[1];
            } 
        }
        
        return rst;
    }
    
    
    //<Trial04>
    
    
    
    //int[] -> long[]���� �ٲ㼭
    
    //[[-2147483646,-2147483645],[2147483646,2147483647]] �� �ذ���
    
    //priority queue�� int�ƴϸ� �ȵ��ư�����~
    
    //�׷��� compare()�� @Override�ؼ� long�� �ǰԲ� ��
    
    //�� �ٵ�
    
    //[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
    
    //���⼭ �� ������
    
    //�̹��� ���� �����ĸ�, ���� �ָ� ���Ľ�Ű��,
    
    //prev: 0 9
	//curr: 0 6
	//curr: 2 8
	//curr: 2 9
	//curr: 3 9
	//curr: 3 9
	//curr: 3 8
	//curr: 6 8
	//curr: 7 12
	//curr: 9 10
    
    //�̷��� �ǰŵ�?
    
    //point[0]�������� ���ĵ��־��� ������, point[1]�� ������ �ȸ´� ����. �̰� ������.
    
    //[0,9] -> [0,6]�Ҷ� if(prev < curr[0]) ��⿡ �Ȱɷ��� �׳� ����ģ�� ����?
    
    //�׷� �� �����ľ� �ϴ°� �ƴ϶�, ���� ��ġ���� ���� �������� 6���� �ٲٰ� �Ѿ�߰ڳ�
    
    
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
        PriorityQueue<long[]> pq = new PriorityQueue(points.length, 
            new Comparator<long[]>(){
                public int compare(long[] a, long[] b) {
                    return Long.compare(a[0], b[0]);
                }
            }
        );
        
        for(int[] point : points){
            long[] tmp = new long[2];
            tmp[0] = (long)point[0];
            tmp[1] = (long)point[1];
            pq.offer(tmp);
        }
        
        int rst = 1;
        long prev = pq.poll()[1];
        
        while(pq.size() > 0){
            long[] curr = pq.poll();
            if(prev < curr[0]){
                rst++;
                prev = curr[1];
            } 
        }
        
        return rst;
    }
    
    
    //<����Ǯ��1>
    
    //�� �ù� ���̰� ����ͳ�
    
    //priority queue���� ���� (new Comparator<>(){ public int compare(){} })�� 
    
    //Arrays.sort()������ �Ȱ��� ���� �� �ִ�.
    
	//Arrays.sort(points, new Comparator<int[]>() {
	//	public int compare(int[] a, int[] b) {
	//		if(a[0]==b[0]) return a[1]-b[1];
	//		else return a[0]-b[0];
	//	}
	//});
    
    //�̷�������.
    
    //���ɺ��� ���� long[]���� �ٲ� �ʿ䰡 �־��� �ͳ�. Integer.MIN_VALUE�����淡  ���� �ٲ�µ�.
    
    //Runtime: 23 ms
    //Memory Usage: 43.6 MB
    
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
        PriorityQueue<long[]> pq = new PriorityQueue(points.length, 
            new Comparator<long[]>(){
                public int compare(long[] a, long[] b) {
                    return Long.compare(a[0], b[0]);
                }
            }
        );
        
        for(int[] point : points){
            long[] tmp = new long[2];
            tmp[0] = (long)point[0];
            tmp[1] = (long)point[1];
            pq.offer(tmp);
        }
        
        int rst = 1;
        long prev = pq.poll()[1];
        
        while(pq.size() > 0){
            long[] curr = pq.poll();
            if(prev < curr[0]){
                rst++;
                prev = curr[1];
            } else {
                prev = Math.min(prev, curr[1]);
            }
        }
        
        return rst;
    }
}
