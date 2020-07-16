package julyChallenge;

public class PowXN {

	//<����Ǯ��1>
	
	//�̰� �����Լ��� �Ⱦ��� ������ �ֳ�?
	
	//bitmask�� integer�� �ƴ϶� double�̸� �ϳ� �������ٵ�?
	
	//Runtime: 1 ms
	//Memory Usage: 38.6 MB
	
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
    
    
    
    //<����Ǯ��2 by dietpepsi>
    
    //bitmask
    
    //Runtime: 0 ms
    //Memory Usage: 36.8 MB
    
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) { //������ 0�̵ɶ����� ��� ������. �׸��� n�� -�ϼ��� ������ n_>0�� �ƴ϶� n_ != 0
            if ((m & 1) == 1) //bit�� �������� ans�� x�� ������.
                ans *= x;
            x *= x; //x�� ��� ��������. m >> 1�̴ϱ� 2�� �������� �����̱� ����. 
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }
}
