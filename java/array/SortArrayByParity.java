package augustChallenge;

public class SortArrayByParity {
	
	//<����Ǯ��1>
	
	//two pointer
	
	//Runtime: 2 ms
	//Memory Usage: 46.1 MB
	
    public int[] sortArrayByParity(int[] A) {
        for(int i = 0, j = A.length-1; i < j; ){
            while(i < j && A[i]%2==0) i++;
            while(i < j && A[j]%2==1) j--;
            swap(A,i++,j--);
        }
        return A;
    }
    
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    
    //<����Ǯ��2 by lee215>
    
    //two pointer
    
    //�ε� �� �����Ѱ�ó�� �� ���ܿ��� ����� ���°� �ƴ϶�, ���ʿ������� �Ѵ� ����ϴµ�
    
    //i�� Ȧ��, j�� ¦��.
    
    //¦�� �ɸ��� Ȧ���ֶ� �ٲ���
    
    //Ȧ���� ������ �� ��� ¦���� ���´ٰ� ������ ����,
    
    //��� �� �����ζ� swap�ϰ� i�� j�Ѵ� ��ĭ ������
    
    //�׷��� Ȧ�������� i�� Ȧ���� �ְ� j�� ���� ¦�� ���Ë����� �Ѿ
    
    //�׷��� j�� ���� ¦���� �ɸ��� i�� �ٲٴ� ��
    
    //���� ¦���ۿ� ������ ��ȿ����. N�����µ� ��� �� �����ζ� �ٲٰ� �ɾ������ϱ�.
    
    //Runtime: 1 ms
    //Memory Usage: 40.6 MB
    
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
}
