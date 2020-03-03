package array;

public class PreviousPermutationWithOneSwap1053 {
	
	
	//<Trial01>
	
	//�´°� ������ ��?
	
	//ã�ƺ��� test case�� �߸���ٴ� ���� ����...���θ������ �����̶�׷���
	
	//Test case 50:
	//input :
	//{1,1,9,4,9,7,7,5,3,10,4,10,2,3,4,9,4,6,5,10,7,2,9,4,10,7,10,5,10,9,5,3,6,9,3,1,2,9,1,4,5,1,3,2,10,7,9,6,9,6,9,9,1,8,7,8,9,5,9,8,6,1,10,9}
	//expected output:
	//{1,1,9,4,9,7,7,5,3,10,4,10,2,3,4,9,4,6,5,10,7,2,9,4,10,7,10,5,10,9,5,3,6,9,3,1,2,9,1,4,5,1,3,2,10,7,9,6,9,6,9,9,1,8,7,8,9,5,9,8,6,1,9,10}
	//
	//This is wrong because the expected output is bigger than input. Notice the last two numbers {10, 9} and {9, 10}.
	//{9, 10} > {10, 9}
	//
	//The right expected output should be:
	//{1,1,9,4,9,7,7,5,3,10,4,10,2,3,4,9,4,6,5,10,7,2,9,4,10,7,10,5,10,9,5,3,6,9,3,1,2,9,1,4,5,1,3,2,10,7,9,6,9,6,9,9,1,8,7,8,9,5,9,8,6,10,1,9}
	
	//logic : �� ���ڸ����� ���� ����� ���ڿ� �ѹ� ������� �״������� ���� ���ڰ� ����. ��, ������ ���� ����� ���ڰ� �� ���ڸ� index:iterate���� �� ū ���ڿ��� ��.

	private static int[] swap(int[] A, int i, int iterate) {
		int tmp = A[i];
		A[i] = A[iterate];
		A[iterate] = tmp;
		return A;
	}

	public static int[] prevPermOpt1(int[] A) {
		int iterate = A.length - 1;
		while (iterate > 0) {
			for (int i = iterate - 1; i >= 0; i--) {
				if (A[i] > A[iterate]) {
					return swap(A, i, iterate);
				} else if (A[i] == A[iterate]) {
					break;
				}
			}
			iterate--;
		}
		return A;
	}
	
	
	/*
	//<����Ǯ��1 by kylewzk>
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Previous Permutation With One Swap.
	//Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Previous Permutation With One Swap.
	
	public static int[] prevPermOpt1(int[] A) {
        for(int i = A.length - 1; i >= 0; i--) { //�� ���ڸ����� ���鼭
            if(i == A.length - 1 || A[i] <= A[i+1]) continue; //�ٷ� ��ĭ�� �� ���ڸ����� �� ū ������ �ε����� ã��. ������� ����.
            else {
                int j = A.length - 1;
                while(A[j] >= A[i] || A[j] == A[j-1]) j--; //A[j] >= A[i]�� �ڿ����ڰ� �� ũ��, �ٲ� �� ���ڰ� �� Ŀ���� �ȵǼ� �׷���, A[j] == A[j-1]�� ������ �ִ� ���ڰ� ���ٸ�, �տ��ִ°� �ٲ��ִ°� �ڿ��ִ°ſ� �ٲٴ°ͺ��� �� ū ���̹Ƿ�. 
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                break;
            }
        }
        return A;
    }
	*/
	
	
	public static void main(String[] args) {
		int[] test = new int[] {3,3,2,1,2,3};
		for(int ele : prevPermOpt1(test)) {
			System.out.print(ele+" ");
		}
	}

}
