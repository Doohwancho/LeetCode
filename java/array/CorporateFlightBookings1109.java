package array;

public class CorporateFlightBookings1109 {
	
	/*
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 1315 ms, faster than 8.32% of online submissions for Corporate Flight Bookings.
	//Memory Usage: 56.1 MB, less than 100.00% of online submissions for Corporate Flight Bookings.
	
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] rst = new int[n];
        
        for(int[] each : bookings){
            for(int i = each[0]-1; i < each[1]; i++){
                rst[i] += each[2];
            }
        }
        
        return rst;
    }
	*/
	
	//<����Ǯ��2 by lee215>
	
	//�� ���� �������� ������
	
	//Runtime: 2 ms, faster than 100.00% of online submissions for Corporate Flight Bookings.
	//Memory Usage: 55.8 MB, less than 100.00% of online submissions for Corporate Flight Bookings.
	
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] b : bookings) {
            res[b[0] - 1] += b[2]; //������� ���������� ��� �����ؼ� ���ҰŴ�
            if (b[1] < n) res[b[1]] -= b[2]; //b[1]-1����. �ٵ� b[1]�� �Ǹ� �̹� -b[2]�̱� ������, +b[2]�ϸ� +-0�� �ȴ�. ���� ��Ʈ�ֳ�
        }
        for (int i = 1; i < n; ++i)
            res[i] += res[i - 1];
        return res;
    }
}
