package augustChallenge;

public class PancakeSorting {

	//<����Ǯ��1>
	
	//�� �������� �� �ָ� ã�� ����, 
	
	//�¸� �� ó������ ������
	
	//�°� 4��� 0���� 4�� �־���ϴ°����� ������
	
	//�׸��� 3���� �Ű�.
	
	//�������,
	
    //3,2,4,1 ���,
    
    //ù��°�� �ϴ� 4�� ã� index0���� index2����(4���ִ°�) ������. �׷� 4�� �� ������ ���� ��.
    
	//4,2,3,1
	
	//4�� �� ������ ������, ���� 4�� �־�� �ϴ� ���̶� reverse. index0~index3����. �׷�
	
    //1,3,2,4
	
	//�̷��� ��. 4�� ���ڸ� ã�ƿ�. ���� ���� Ÿ���� 4���� �ϳ� ���� ������ 3.
    
    //3�� �ε����� 1�̴ϱ�, index0~index1���� reverse��. �׷���, 3�� �� ������ ��.
    //3,1,2,4
	
	//�̷���. �׷� �� �տ��ִ� 3�̶� ���� 3�� �־�� �� index2�� reverse
	
    //2,1,3,4
	
	//�׷� ���±��� 3�̶� 4�� �� �ڸ��� ã�Ե�. �̷���.
	
	//������ 2�� ã�� �Ȱ��� �ϸ� ��.
	
	//Runtime: 1 ms
	//Memory Usage: 39.5 MB
	
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> rst = new ArrayList<>();
        int t = A.length;
        int len = A.length;
        
        while(len > 0){
            for(int i = 0; i < len; i++){
                if(A[i] == t){
                    reverse(A, i);
                    reverse(A, len-1);
                    rst.add(i+1);
                    rst.add(len);
                    t--;
                    len--;
                    break;
                }
            }
        }
        return rst;
    }
    
    private void reverse(int[] A, int end){
        for(int i = 0, j = end; i < j; i++, j--){
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
