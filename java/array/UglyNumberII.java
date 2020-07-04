package julyChallenge;

public class UglyNumberII {
	
	
	//<����Ǯ��1 by syftalent>
	
	//�ȶ����
	
	//�ϳ��ϳ� �� ���� brute-force����
	
	//2,3,... ���� �������� ugly number�� ����ϴ� ���.
	
	//���� ���� �����ָ鼭 ���� ���� �ָ� ��̾Ƽ� i�� �־����
	
	//���� 6���� 2�� 3 ��ġ�°� ���Դٰ� �ص�, else-if���� �ƴ϶�, �Ѵ� index+1�ع����� ������ ������ �Ȼ���	
	
	//���� �� ��ü������
	
	//O(n)
	
	//Runtime: 3 ms
	//Memory Usage: 37.7 MB
	
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        
        for(int i = 1; i < n; i++) {
        	int min = Math.min(Math.min(factor2,factor3),factor5); //���߿� �� ������
        	ugly[i] = min;
        	
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
