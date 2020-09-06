package september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageOverlap {
	
	//<Trial01>
	
	//���ο��� �� ��ִ���, ���ο��� �� ��ִ��� ���ϰ�,
	
	//a�� b�� sliding window �ϸ� �� �� �˾Ҵµ�,
	
	//[[1,1,1],
	// [1,0,0],
	// [0,1,1]]
	
	//[[1,1,0],
	// [1,1,1],
	// [1,1,0]]
	
	//�� ������ ������, ����.
	
	//[1,0,1]�� [0,1,0]�� ���غ���,
	
	//���δ� 101,010�̶� sliding-window�ؼ� ������ ���� 1�̰�,
	
	//���ε� 2,1�̶�, sliding-window�ؼ� �����°��� 1
	
	//�갡 �� ȥ�ڸ� ������ �̹���� �����ѵ�, �ٸ� ������ �ֵ��̶� ������������ �ȵǴ����.
	
    private void insert(int[][] C, int[] c, boolean row, boolean extra){
        int len = C.length;
        
        if(row){
            if(extra){
                for(int i = 0, i_ = len-1, cnt = 0; i < len; i++, i_++){
                    for(int j = 0; j < len; j++){
                        if(C[i][j] == 1) cnt++;
                    }
                    c[i_] = cnt;
                    cnt = 0;
                }
            } else {
                for(int i = 0, cnt = 0; i < len; i++){
                    for(int j = 0; j < len; j++){
                        if(C[i][j] == 1) cnt++;
                    }
                    c[i] = cnt;
                    cnt = 0;
                }
            }
        } else {
            if(extra){
                for(int i = 0, i_ = len-1, cnt = 0; i < len; i++, i_++){
                    for(int j = 0; j < len; j++){
                        if(C[j][i] == 1) cnt++;
                    }
                    c[i_] = cnt;
                    cnt = 0;
                }
            } else {
                for(int i = 0, cnt = 0; i < len; i++){
                    for(int j = 0; j < len; j++){
                        if(C[j][i] == 1) cnt++;
                    }
                    c[i] = cnt;
                    cnt = 0;
                }   
            }
        }
    }
    
    private int slidingWindow(int[] a, int[] b){
        int max = 0;
        int len = b.length;
        
        for(int i = 0, acc = 0; i < len*2-1; i++){
            for(int i_ = i, j = 0; j < len; i_++, j++){
                acc += Math.min(a[i_], b[j]);
            }
            max = Math.max(max, acc);
            acc = 0;
        }
        
        return max;
    }
    
    public int largestOverlap(int[][] A, int[][] B) {
        int[] aRow = new int[A.length*3-2];
        int[] aColumn = new int[A.length*3-2];
        int[] bRow = new int[B.length];
        int[] bColumn = new int[B.length];
        
        insert(A, aRow, true, true);
        insert(A, aColumn, false, true);
        insert(B, bRow, true, false);
        insert(B, bColumn, false, false);
        
        return Math.min(slidingWindow(aRow, bRow), slidingWindow(aColumn, bColumn));
    }
    
    
    
    //<����Ǯ��1 by lkjhlkjhasdf1>
    
    //brute-force
    
    //�׸����� : https://leetcode.com/problems/image-overlap/discuss/832126/Question-Explained-or-Java-Code
    
    //Runtime: 43 ms
    //Memory Usage: 38.7 MB
    
    public int largestOverlap(int[][] A, int[][] B) {
        int largestOverlap = 0;
        for (int row = -A.length + 1; row < A.length; row++)
            for (int col = -A[0].length + 1; col < A[0].length; col++)
                largestOverlap = Math.max(largestOverlap, overlappingOnes(A, B, row, col));
        return largestOverlap;
    }

    public int overlappingOnes(int[][] A, int[][] B, int rowOffset, int colOffset) {
        int overlapOnes = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if ((row + rowOffset < 0 || row + rowOffset >= A.length) || (col + colOffset < 0 || col + colOffset >= A.length) || (A[row][col] + B[row + rowOffset][col + colOffset] != 2))
                    continue;
                overlapOnes++;
            }
        }
        return overlapOnes;
    }
    
    
    //<����Ǯ��2 by lee215>
    
	//Assume A and B are 3 * 3 matrix.:
    
	//A:
	//1,0,1
	//1,0,0
	//1,1,1
    
	//B:
	//0,0,1
	//0,1,1
	//1,1,1
    
	//Flatten each of them to 1-D array:
	//flattened idx: 0,1,2,3,4,5,6,7,8
	//flattened A: 1,0,1,1,0,0,1,1,1 -> 0,2,3,6,7,8 : LA
	//flattened B: 0,0,1,0,1,1,1,1,1 -> 2,4,5,6,7,8 : LB
    
	//Each '1' in A can be overlapped with each '1' in B for different offset.
	//Iterate through every overlap situation for '1' (at i) in LA and '1' (at j) in LB, group by offset (i - j).
    
	//Final step is to find the largest number of overlapped '1's among all offsets.
    
    
    
    //���� 
    
    //[[1,1,0],
    // [0,1,0],
    // [0,1,0]]
    
    //[[0,0,0],
    // [0,1,1],
    // [0,0,1]]
    
    //�� ������, counts�� �Ʒ��� ���� ����
    
    //Ű : 0, �� : 1
	//Ű : -1, �� : 2
	//Ű : -100, �� : 1
	//Ű : 99, �� : 1
	//Ű : -101, �� : 3
	//Ű : 100, �� : 1
	//Ű : -102, �� : 1
	//Ű : -201, �� : 1
	//Ű : -202, �� : 1
    
    //�� �볻 �ȶ��ϳ�.
    
    //���� �Ÿ���ŭ �������ִ°� ����ѰžƳ�
    
    //Runtime: 60 ms
    //Memory Usage: 40.2 MB
    
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>(),  LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i)
            if (A[i / N][i % N] == 1)
                LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i)
            if (B[i / N][i % N] == 1)
                LB.add(i / N * 100 + i % N);
        for (int i : LA) for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1); //?
        int res = 0;
        for (int i : count.values())
            res = Math.max(res, i);
        return res;
    }
}
