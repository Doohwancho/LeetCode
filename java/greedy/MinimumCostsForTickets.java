package augustChallenge;

public class MinimumCostsForTickets {
	
	
	
	//<Trial01>
	
	//���Ϸ� �ɰ��� greedy
	
	//�뷫���� ������ �¾Ҵµ� �ణ �߲ٳ�
	
	
    public int mincostTickets(int[] days, int[] costs) {
        int[] d = new int[days[days.length-1]+1];
        for(int i = 1, j = 0; i < d.length; i++){
            if(i == days[j]){
                d[i] = Math.min(costs[0] + d[i-1], Math.min(i > 6 ? d[i-7]+costs[1] : Integer.MAX_VALUE, i > 29 ? d[i-30]+costs[2] : Integer.MAX_VALUE));
                j++;
            } else if(i > 0) {
                d[i] += d[i-1];
            }
        }
        return d[d.length-1];
    }
    
    
    
    //<����Ǯ��1 by sriharik>
    
    //������ ���Ⱑ �����߳�
    
    //i > 6 ? d[i-7]+costs[1] : Integer.MAX_VALUE ����
    
    //�� ����� �볻 �ȶ��ϰ� dp[Math.max(0, i-7)] + costs[1]��
    
    //�̰� �� �볻 �ȶ��ϳĸ�,
    
    //[100,100,1]���� ��쿡, ���� �� ����� 99�ϱ��� 1�� �Ȼ�.
    
    //�ٵ� �� ����� �� ����� ���� 1�� ��.
    
    //Runtime: 1 ms
    //Memory Usage: 39.6 MB
    
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        
        for(int i = 1, j = 0; i < dp.length; i++){
            if(i == days[j]){
                int one = dp[i-1] + costs[0];
                int seven = dp[Math.max(0, i-7)] + costs[1];
                int thirty = dp[Math.max(0, i-30)] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
                j++;
            } else {
                dp[i] += dp[i-1];
            }
        }
        
        return dp[dp.length-1];
    }
    
    
    
}
