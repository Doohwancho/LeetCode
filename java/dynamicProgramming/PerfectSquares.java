package juneChallenge;

public class PerfectSquares {
	
	//<Trial01>
	
	//greedy�� �ȸ����� ������?
	
	public int numSquares(int n) {
        int rst = 0;
        while(n > 0){
            int sqrt = (int)Math.sqrt(n);
            n -= sqrt * sqrt;
            rst++;
        }
        return rst;
    }
	
	
	//<����Ǯ��1>
	
	//���� �� õ���
	
	//�� �ٵ� ���� ��������
	
	//Runtime: 1070 ms
	//Memory Usage: 38.6 MB
	
    //  o     o         o                   o
    //0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18
    //1,1,2,3,1,2,3,4,2,1,2 ,3 ,3 ,2 ,3 ,4 ,1 ,2  ,2
    public int numSquares(int n) {
        int[] a = new int[n+1];
        
        for(int i = 1; i <=n; i++){
            if(Math.sqrt(i) == (int)Math.sqrt(i)){ //�������� �ٷ� 1�ھ���
                a[i] = 1;
            } else {
                int smallest = Integer.MAX_VALUE;
                for(int j = 1; j < i; j++){
                    smallest = Math.min(smallest, a[i-j] +a[j]); // 6�� �ɷ����� (1,5),(2,4),(3,3) ������ ���� ������ smallest�� �־ a[i]�� ���� ����
                }
                a[i] = smallest;
            }
        }
        return a[n];
    }
    
    
    //<����Ǯ��2 by czonzhu> 
    
    //dp
    
    //Runtime: 25 ms
    //Memory Usage: 38.6 MB
    
    //  o     o         o                   o
    //0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18
    //1,1,2,3,1,2,3,4,2,1,2 ,3 ,3 ,2 ,3 ,4 ,1 ,2  ,2
    
    public int numSquares(int n) { 
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                dp[i  + j * j] = Math.min(dp[i + j * j], dp[i] + 1); 
                //��ó�� i�� 0�϶� �������� dp[i](==0)+1�� �� 1�ھ���.
                
                //dp[i] + 1���� ��쿡�� dp[i]�� i�� ���������� �ּҴϱ�, i�� j*j�������� ���Ѱ�, +1�� ���ָ� ����. i�� ������ �ϳ� �� ���ϴ°��ݾ�
                //������� 13�� ��쿣, i�� 4�϶�, 4�� 2�� �������ϱ� dp[i]�� 1�λ��¿���, i(4)+j�� ����(3*3 = 9) = �ؼ� 13�ݾ�.
                
                //�׸��� 12�� ��쿡, dp[i]+1�κ� �Ἥ
                //i�� 3�϶� 3(3)+9(1)�ؼ� 4�� ä�����ٰ�
                //i�� 8�϶� 8(1)+4(1)�ؼ� �ٽ� 2�� Math.min()�ؼ� ������Ʈ �Ǵ°���
             }
        }
        return dp[n];
     }
	
}
