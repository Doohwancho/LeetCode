package mayChallenge;

public class ValidPerfectSquare {
	
	//<����Ǯ��1>
	
	//binary search
	
	//1. n�� ������ m�̶�� ����. �׷��ٸ�, n <= m/2�̴�. ����� ������ �����ͺ��� ���ų� �۾ƾ� �Ѵ�. n = 2, m = 4�϶��� �����ϰ� n == m/2�� ����,
	
	//m�� 4���� �� Ŀ����, ������ n < m/2�� �Ǳ� ����.
	
	//�׷� 1���� m/2���� �����߿�, �����ؼ� m�̵Ǵ� ���� ���ϴ� ������� binary search�� �̿��Ѵ�.
	
	//2. m*m�Ҷ�, int�� max���� ����� �������� long���� �����ߴµ�,
	
	//int�� ����ʹٸ�, m = (l+r)/2���� ��ſ�, m = l-(r-l)/2 ���� ���� ��.
	
	//�ֳ��ϸ�, m = l-(r-l)/2 = l - 2l/2 + (l+r)/2 = l - (r-l)/2 
	
	//�̱� ����.
	
	//68 / 68 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 35.7 MB

    public boolean isPerfectSquare(int num) {
        long l = 0;
        long r = num/2;
        while(l <= r){
            long m = (l+r)/2;
            if(m*m == num) return true;
            else if(m*m > num) r = m-1;
            else l = m+1;
        }
        return l*l == num;
    }
    
    //<����Ǯ��2>
    
    //Newton-Raphson method
    
    //���� �ܿ��� Ǫ�� �����̶� ���δ�.
    
    public boolean isPerfectSquare(int num) {
	    long r = num;
	    while (r*r > num)
	        r = (r + num/r) / 2;
	    return r*r == num;
    }
}
