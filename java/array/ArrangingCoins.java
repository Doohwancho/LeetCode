package julyChallenge;

public class ArrangingCoins {
	
	
	//<Trial01>
	
	//� ���ڰ� �볻 Ŀ���� 1���� �� ���ڱ��� �� ���ϴµ� ���ضհ� ����ű �ϱ淡
	
	//double�� �ٲٰ� helper()�� ����ȯ ���ϰ� �ϰ� ���N�µ�
	
	//���� ū���ڿ��� �� ���¿� �������ڿ��� 1�� �ȸ³�?
	
	//double������ �׷���?
	
    private double helper(double n){
        return n%2 == 0 ? (n-1) * n/2 + n : n * (n+1)/2;
    }
    
    public int arrangeCoins(int n) {
        if(n < 2) return n;
        
        double l = 0, r = n/2+1;
        
        while(l < r){
            double m = (l+r)/2;
            double t = helper(m);
            if(t >= n){
                r = m;
            } else {
                l = m+1;
            }
        }
        
        return (int)l;
    }
	
    
    //<����Ǯ��1 by larrywang2014>
    
    //�� Ǯ�̶� �ٸ��� �ִٸ� overflow�� �������� long�� ��ٴ� ���� 
    
    //���������ϰ� helper()������ �Ⱦ��� ����ϰ� m * (m + 1) <= 2 * nLong �ߴٴ°�
    
    //�׿� 1���̳��°� �޲��ִ� �̼�Ʃ��.
    
    //�ȶ���� �����Ѵ�
    
    //Runtime: 1 ms
    //Memory Usage: 37.2 MB
    
    public int arrangeCoins(int n) {   
        long nLong = (long)n, l= 0, r= nLong;

        while (l <= r){
            long m = l + (r - l) / 2;
            
            if (m * (m + 1) <= 2 * nLong){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        
        return (int)(l - 1);
    }
}
