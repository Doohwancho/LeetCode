package array;

public class BeautifulArrangementII667 {
	
	/*
	//<Trial01>
	
	//[1,2,3,4] k = 1
    //[1,2,4,3] k = 2
    //[1,4,2,3] k = 3
    
    //step01 - ������ ���ڸ� ����
    //step02 - arr.size-k���� ������ ���������� ��ĭ�� �δ�
    //step03 - arr.size-k��° �ε����� ������ ���ڸ� �ִ´�.
	
	//arr.size�� 5�̻���ʹ� �ȸ����� ����̳�
	//��¾�� �ʹ� ���� Ǯ�������
    public static int[] constructArray(int n, int k) { 
        int[] rst = new int[n];
        int num = 1;
        int idx = 0;
        while(idx < n){
            if(idx == n-k){
                rst[idx++] = n;
            }
            else{
                rst[idx] = num;
                idx++;
                num++;
            }
        }
        return rst;
    }
    */
	
	//<����Ǯ��1>
	
	////n = 6, k = 4
	
	//��� �����ϸ�,
	
	//���� �̷������� ���´�. [1,6,2,5,4,3] 
	
	//�ڼ��� ���� ���� ������ ���̴µ�,
	
	//1->6->2->5
	
	//���� ������, ���� ū��, �ι�°�� ������, �ι�°�� ū�� ..
	
	//�̷������� �귯����, ���� ���� +5,+4,+3 ..
	
	//�̷� ������ ������ ����.
	
	//�츮�� �� ����, index 0���� k-1���� ���ڸ� ������,ū�� ������ �ְ�,(k-1���� ���̰� Ȯ��)
	
	//������ �� �������� ���� �������� ������ ���� 1 ���̳��� ���� �޲��ָ� ��(������ 1Ȯ��)
	
	//Runtime: 1 ms, faster than 85.07% of Java online submissions for Beautiful Arrangement II.
	//Memory Usage: 40.7 MB, less than 25.00% of Java online submissions for Beautiful Arrangement II.
    public static int[] constructArray(int n, int k) {
        int[] rst = new int[n];
        boolean flag = true;

        for(int i = 0, str = 1, end = n; i < n; i++){
            if(flag){
            	if(i < k) {          //if(i<k)�� �̿��Ͽ� k��°���� ������ �ֱ�
                    rst[i] = str++;
                    flag = false;
            	}
            	else {               //else���� k-1��°���� ���� ��� ä������, ������ ���ڵ��� 1���̳��� ���ڷ� ä���
            		rst[i] = end--;
            	}
            } else {
            	if(i < k) {
                    rst[i] = end--;
                    flag = true;		
            	}
            	else {
            		rst[i] = str++;
            	}
            }
        }
        return rst;
    }
	
    public static void main(String[] args) {
		for(int i : constructArray(6,4)) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
