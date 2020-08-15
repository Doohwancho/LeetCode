package augustChallenge;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	
	//<����Ǯ��1 by tankztc>
	
	//overlay�� ã��������(== ������ ������ ħ���ϴ� �ָ� ã��������) +1
	
	//Runtime: 3 ms
	//Memory Usage: 39.2 MB
	
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){ 
            public int compare(int[] a, int[] b){
                return a[1] - b[1]; //end �������� ����
            }
        });
        
        int rst = 0;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){ //���ο� ���� ������ ���� end���� �۴ٴ� ����,���� �����ȿ� overlay�Ѵٴ� ��. ��� ���ʿ�. +1.
                rst++;
            } else{
                end = intervals[i][1]; //������ ���� end�� �� ���ĺ��� �����̸� end ������ �ø�.
            }
        }
        
        return rst;
    }


}
