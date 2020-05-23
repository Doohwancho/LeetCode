package mayChallenge;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	
	
	//<����Ǯ��1 bychipbk10>
	
	//intersect �޼ҵ�� a,b�� �������� ���ϵ�,
	
	//A = [[0,2],[5,10],[13,23],[24,25]], 
	//B = [[1,5],[8,12],[15,24],[25,26]]
	
	//����, ù���� [0,2]�� [1,5]�� [1,2]�� �� �尨
	
	//�������� �����Ҷ� if (a[1] <= c[1]) i++; �̰� ���µ�,
	
	//[1,2]���� 2���� [0,2]�� 2�� ���ų� ������, �̹� �����Ѵٴ� ���̴ϱ�, ���������� �Ѿ�ߵǼ� i++;
	
	//���������� [1,2]�� �־��µ�, B[0]�� [1,5]�� �񱳽� B[0][1]�̶� [1,2]�� 2�� ����.
	
	//�ٵ� ��� 5��? 2���� ũ��? ���� Ŀ�� ��������?
	
	//�׷� j�� �� ����
	
	//�׷� ���� intersect�� �� �Ķ���ʹ� [5,10]�̶� [1,5]�� �Ǵ°�.
	
	//[5,5]�� ����, 10�̶� 5�� [5,5]�� 5���� �۰ų� �����ϱ�(Ŀ���Ǵϱ�), i++,j++�ؼ� ���������� �Ѿ�°�
	
	//Runtime: 2 ms
	//Memory Usage: 40.3 MB
	
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length, n = B.length, i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        
        while (i < m && j < n) {
            int[] a = A[i], b = B[j], c = intersect(a, b);            
            if (c[1] >= c[0]) res.add(c);
            if (a[1] <= c[1]) i++;
            if (b[1] <= c[1]) j++;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
    
    private int[] intersect(int[] a, int[] b) {
        return new int[] {Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
    
}
