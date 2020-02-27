package array;

public class MinimumDominoRotationsForEqualRow1007 {
	
	//<Trial01>
	
	//�����ϰ� Ǯ���µ��� ��ǰ �����
	
	/*
	public int minDominoRotations(int[] A, int[] B) {
        if(A.length == 1) return 0;
        
        int targetA = A[0] == A[1] || A[0] == B[1] ? A[0] : -1;
        int targetB = B[0] == B[1] || B[0] == A[1] ? B[0] : -1;
        
        if(targetA+targetB == -2){
            return -1;
        } else {
            int[] ab = new int[2];
            
            for(int i = 1; i < A.length; i++){
               if(A[i] == targetA){
                    continue;
               }else if(B[i] == targetA){
                   ab[0]++;
               }else{
                   ab[0] -= 20000;
                   break;
               }
            }
            
            for(int i = 1; i < A.length; i++){
               if(B[i] == targetB){
                    continue;
               }else if(A[i] == targetB){
                   ab[1]++;
               }else{
                   ab[1] -= 20000;
                   break;
               }
            }
            if(ab[0] > 0 || ab[1] > 0){
                int a = Math.min(ab[0], A.length-ab[0]);
                int b = Math.min(ab[1], A.length-ab[1]);
                
                if(a < 0){
                    return b;
                }
                else if(b < 0){
                    return a;
                }
                else {
                    return Math.min(a,b);
                }
            } else if(ab[0] == 0 || ab[1] == 0){
                return 0;
            }
            
            
            return -1;
        }
    }
    */
	
	//<����Ǯ��1 by lee215>
	
	//�� ��������ϰ� Ǫ��
	
	//Runtime: 5 ms, faster than 63.13% of Java online submissions for Minimum Domino Rotations For Equal Row.
	//Memory Usage: 45.7 MB, less than 56.25% of Java online submissions for Minimum Domino Rotations For Equal Row.
	
    public int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i])
                same[A[i]]++;
        }
        for (int i  = 1; i < 7; ++i)
            if (countA[i] + countB[i] - same[i] == n)    //Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]�� ���, �� ���� 2�ѹ� ��ġ�°͸� ���ָ� A.length�� ���̰� ����
                return n - Math.max(countA[i], countB[i]); //��ü���� - A�ٰ� B�ٿ��� �� ����� �ּ� �ű�� ��. ���� ���ÿ��� 2�� 2�� �ű⳪ 6-2�ؼ� 4���ű�� ��
        return -1;
    }
}
