package september;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	
	//<Trial01>
	
	//���������ϴ� �Ŷ�淡 
	
	//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
	
	//�̸�, ���ڷ� 0���� 9���� �� �׸���
	
	//0,1,1,1,1,1,1,1,1,1
	
	//�̰�, 0���� ���е� �ָ� �̰��ߴµ� [[1,8]]��ȯ�ع��� ����
	
	//������ ���Ѿ� �Ǵµ� ��...

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals[intervals.length-1][1];
        int[] canvas = new int[len+1];
        
        for(int[] interval : intervals){
            for(int i = interval[0]; i <= interval[1]; i++){
                canvas[i] = 1;
            }
        }
        for(int i = newInterval[0]; i <= newInterval[1]; i++){
            canvas[i] = 1;
        }
        
        List<int[]> container = new ArrayList<>();
        int[] tmp = new int[2];
        for(int i = 0, j = 0; i < len; i++){
            if(canvas[i] == 0){
                if(tmp[j] != 0){
                    container.add(tmp); 
                    tmp = new int[2];
                    j = 0;
                }
            } else {
                if(j == 0){
                    tmp[j] = i;
                    j++;
                } else {
                    tmp[j] = i;
                }
            }
        }
        if(tmp[1] != 0){
            container.add(tmp);
        }
        
        int[][] rst = new int[container.size()][2];
        for(int i = 0; i < container.size(); i++){
            rst[i] = container.get(i);
        }
        return rst;
    }
    
    
    //<����Ǯ��1 by lkjhlkjhasdf1>
    
    //�� �ȶ��ϴ�
    
    //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    
    //�̰� ���ε��,
    
    //if���� �ɸ��°� [1,2]. �� ��쿣 [1,2] �� ������ ��
    
    //else if���� �ɸ��°� [12,16]. �� ��쿣 �꺸�� new Interval��ü�� ������ ����ϴϱ�,
    
    //new Interval������ ��. �ٵ� �׷��� ���� iterate�Ҷ� �񱳴���� �������ϱ� [12,16]�� newInterval�� �ְ� ��� ����.
    
    //else�� �ش��ϴ� �ֵ��� [3,5],[6,7],[8,10]�� �ֵ�.
    
    //[4,8]�̶� �ָ��ϰ� �����ִ� �ֵ�. �̷��ֵ��� ������ ������� �ϴµ�,
    
    //���� �� ���� Math.min(i��° �� [0], newInterval[0]) ���ְ�,
    
    //������ ������ Math.max(i��° ��[1], newInterval[1])���ִٰ�
    
    //else if�� newInterval���� �� �����ʿ� �ִ¾ְ� ��Ÿ�Ƹ� �׶� �־���.
    
    //Runtime: 1 ms
    //Memory Usage: 41.9 MB
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                list.add(in);
            } else if (newInterval[1] < in[0]) {
                list.add(newInterval);
                newInterval = in;
            } else {
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }
        }
        list.add(newInterval);

        return list.toArray(new int[list.size()][]);
    }
}
