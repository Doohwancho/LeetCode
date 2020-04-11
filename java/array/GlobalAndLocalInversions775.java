package array;

public class GlobalAndLocalInversions775 {

	
	//<����Ǯ��1>
	
	//��.�� �ߴٱ� ģ��
	
	//���� permutation�ذ� �ƴϱ׵�
	
	//���� �ذ͵� ���� �ϳ��� ������ ����
	
	//Example 1:
	//
	//Input: A = [1,0,2]
	//Output: true
	//Explanation: There is 1 global inversion, and 1 local inversion.
	//Example 2:
	//
	//Input: A = [1,2,0]
	//Output: false
	//Explanation: There are 2 global inversions, and 1 local inversion.
	
	//falase������ �͵��� �˴� A[i]�� ���� �װ��� �ε����� 2�̻� ���̳�
	
	//Runtime: 1 ms, faster than 95.03% of Java online submissions for Global and Local Inversions.
	//Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for Global and Local Inversions.
    public static boolean isIdealPermutation(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(Math.abs(i - A[i]) > 1) return false;
        }
        return true;
    }
}
