/*
	Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.
	
	Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
	
	 
	
	Example 1:
	
	Input: [6,0,8,2,1,5]
	Output: 4
	Explanation: 
	The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
	Example 2:
	
	Input: [9,8,1,0,1,9,4,0,4,1]
	Output: 7
	Explanation: 
	The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
	 
	
	Note:
	
	2 <= A.length <= 50000
	0 <= A[i] <= 50000
	
	
	
	
	<����>
	
	[6,0,8,2,1,5]
	
	�̷��� ��̰� �����ݾ�?
	
	�ε��� i,j�� �־�.
	
	i<j ��.
	
	A[i] <= A[j]������ ������Ű�� �� �߿�
	
	j-i�� ���� ū ���� �̾�.
 */

package array;

import java.util.Stack;

public class MaximumWidthRamp962 {
	
	/*
	//<����Ǯ��1>
	
	//brute-force
	
	//� ��������
	
	//Runtime: 1195 ms, faster than 13.31% of Java online submissions for Maximum Width Ramp.
	//Memory Usage: 47.4 MB, less than 100.00% of Java online submissions for Maximum Width Ramp.
    public int maxWidthRamp(int[] A) {
        int rst = 0;
        for(int r = A.length-1; r-rst > 0; r--){ 
            for(int l = 0; r-l > rst; l++){      //r-l>rst�� ������ ��¥�� r-l�� ������ �����ͺ��� �� �۾ƹ����� loop�� �ǹ̰� ���ڳ�
                if(A[l] <= A[r]){
                    rst = Math.max(rst, r-l);
                }
            }
        }
        return rst;
    }
    */
    
	/*
    //<����Ǯ��2 by leetcode solution>
    
    //Your input : [6,0,8,2,1,5]
    
	//stdout
	//int[] B = 1 4 3 5 0 2 
    
	//ans: 0 m: 1
	//ans: 3 m: 1
	//ans: 3 m: 1
	//ans: 4 m: 1
	//ans: 4 m: 0
	//ans: 4 m: 0

    //Output : 4
	
	//Runtime: 42 ms, faster than 35.43% of Java online submissions for Maximum Width Ramp.
	//Memory Usage: 48.9 MB, less than 100.00% of Java online submissions for Maximum Width Ramp.
    public int maxWidthRamp(int[] A) {
        int len = A.length;
        Integer[] B = new Integer[len];
        for(int i = 0; i < A.length; i++){
            B[i] = i;
        }
        
        Arrays.sort(B, (i,j)-> ((Integer) A[i]).compareTo(A[j])); //.compareTo()�� IntegerŬ������ library�̹Ƿ� B����� primitive type�� int�� ���� ���ϰ� Integer�� ������. 
        
        int rst = 0;
        int m = len;
        
        for(Integer b : B){
            rst = Math.max(rst, b-m);
            m = Math.min(m, b);
        }
        return rst;
    }
    */
	
	/*
	//<����Ǯ�� 3 by aakarshmadhavan>
	
	//int[] test = {6,0,8,2,1,5};
	//map: {6=0}
	//rst: 0
	//map: {0=1, 6=0}
	//rst: 0
	//map: {0=1, 6=0}
	//rst: 2
	//map: {0=1, 6=0}
	//rst: 2
	//map: {0=1, 6=0}
	//rst: 3
	//map: {0=1, 6=0}
	//rst: 4
	
	//map���ִ� keySet�߿��� A[i]���� ���ų� ������ �� for�� ���ƾ� �� �� ������, 
	
	//�ű��ϰԵ� map.floorKey()�� A[i]���� ���ų� ������ �߿� �� ū�͸� üũ�ص� �ǳ�
	
	//Runtime: 44 ms, faster than 30.15% of Java online submissions for Maximum Width Ramp.
	//Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for Maximum Width Ramp.
    public static int maxWidthRamp(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int rst = 0;
        
        for(int i = 0; i < A.length; i++){
            if(map.floorKey(A[i]) == null){ //insert only when there is no lesser value than A[i] 
                map.put(A[i], i);
            } else {
                rst = Math.max(rst, i - map.get(map.floorKey(A[i]))); //map.floorKey() Returns: the greatest key less than or equal to key,or null if there is no such key
            }
        }
        return rst;
    }
    */
	
	//<����Ǯ��4 by lee215>
	
	//int[] test = {3,2,1,0,7,8,9};
    
	//stack : [0, 1, 2, 3]
	//i: 6 stack: [] res: 6
	//ans : 6
	
	//�ص��� ����ȭ�߳�
	
	//Runtime: 7 ms, faster than 81.91% of Java online submissions for Maximum Width Ramp.
	//Memory Usage: 47.6 MB, less than 100.00% of Java online submissions for Maximum Width Ramp.

    public static int maxWidthRamp(int[] A) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) { //�پ��� ����. stack�� �� ������������ �� Ŀ���� ��¥�� �ε����� �þ�µ� ���� Ŀ����? �׷� ������ ���� �Ǵϱ� �ʿ� ���ݾ�.
            if (s.empty() || A[s.peek()] > A[i]) { //.peek() returns object at the top of the stack
                s.add(i);
            }
        }
        System.out.println(s);
        for (int i = n - 1; i > res; --i) {
            while (!s.empty() && A[s.peek()] <= A[i]) { //
                res = Math.max(res, i - s.pop()); //.pop()���� �����ϴ� ������, i�� ��ĭ�� -1�Ǽ� ������ ��������, stack�� �ִ� index�� �����ڳ�
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] test = {3,2,1,0,7,8,9};
    	System.out.println(maxWidthRamp(test));
	}
}
