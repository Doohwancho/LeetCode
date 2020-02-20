package array;

public class FlipStringToMonotoneIncreasing926 {
	
	/*
	//<Trial01>
	
	//java.lang.NumberFormatException: For input string: "100000001010000"
	//  at line 68, java.base/java.lang.NumberFormatException.forInputString
	//  at line 658, java.base/java.lang.Integer.parseInt
	//  at line 776, java.base/java.lang.Integer.parseInt
	//  at line 3, Solution.minFlipsMonoIncr
	//  at line 57, __DriverSolution__.__helper__
	//  at line 85, __Driver__.main
	//Last executed input:"100000001010000"
	
	//��ģ���ڰ� ���ͼ� java.math.BigInteger�� ���� int���� long��µ���
	
	//Input : "11011011010010110011"
	//stdout : convertedNum = -7435733063699441605
	//Output : 0
	//Expected : 8
	
	//long type���� conversion�Ҷ� ����. ��Ŀ��.
	//bitmask�� �̿��ؼ� 1���ڸ��� �� ���¹� ����
	
	public int minFlipsMonoIncr(String S) {
        java.math.BigInteger num = new java.math.BigInteger(S);
        long convertedNum = num.longValue();
        int ones = 0;
		int zeroes = 0;
        
		if(convertedNum%10 == 0) {
			for(long i = 1; i < convertedNum; i*=10) {
				if(convertedNum/i%10 == 1) {
					ones++;
				}else {
					zeroes++;
				}
			}
			return ones > zeroes ? zeroes : ones;
		}
		else {
			boolean flag = false;
			for(long i = 1; i < convertedNum; i*=10) {
				if(flag && convertedNum/i%10 == 1) {
					ones++;
				}else if(convertedNum/i%10 == 0){
					zeroes++;
					flag = true;
				}
			}
			return ones > zeroes ? zeroes : ones;
		}
    }
	*/
	/*
	//<����Ǯ��1 by kylewzk>
	
	//�� �α� ������ ��� �����ϴ����� ���̴µ� �������� �����ī�� ������ڳ�
	
	//Input : "000110001"
	//stdout
	//i 0 1 -> dp[i][0]�� 1�� ��� flip�ؾ� �ϴ���, dp[i][1]�� 0�� ��� flip�ؾ� �ϴ��� ���
	//dp[i][0]�� 1�� ��� flip�ؾ� �ϴ��� �����. ���� 1�� ���ö����� +1�� ����.
	//dp[i][1]�� 0�� ��� flip�ؾ� �ϴ��� �����. �ٵ� Math.min()�� �Ἥ ���²� 1�� �� ��� flip�ؾ� �ϴ����� ����ؼ� �����. 
	
	//0 0 1
	//1 0 1
	//2 0 1
	//3 1 0
	//4 2 0
	//5 2 1
	//6 2 2
	//7 2 3
	//8 3 2
	
	//Runtime: 9 ms, faster than 17.34% of Java online submissions for Flip String to Monotone Increasing.
	//Memory Usage: 40.8 MB, less than 20.00% of Java online submissions for Flip String to Monotone Increasing.
	
	public static int minFlipsMonoIncr(String S) {
        if(S.length() == 0) return 0;
        
        int[][] dp = new int[S.length()][2];
        dp[0][0] = S.charAt(0) == '1' ? 1 : 0;
        dp[0][1] = S.charAt(0) == '0' ? 1 : 0;
        
        for(int i = 1; i < S.length(); i++) {
            if(S.charAt(i) == '1') {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
            }
            System.out.println(i+" "+dp[i][0]+" "+dp[i][1]);
        }
        
        return Math.min(dp[S.length()-1][0], dp[S.length()-1][1]);
    }
	*/
	
	/*
	//<����Ǯ�� 2 by votrubac>
	
	//���� �Ʒ� ��ũ
	
	//https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/183851/C%2B%2BJava-4-lines-O(n)-or-O(1)-DP
	
	//The basic idea is to travel from left to right. At every step i:
	//(1) flip every 1 to the left of i(including) to 0
	//(2) flip every 0 to the right of i(excluding) to 1
	//Find the minimum along the way.
	
	//Runtime: 3 ms, faster than 87.57% of Java online submissions for Flip String to Monotone Increasing.
	//Memory Usage: 38.9 MB, less than 20.00% of Java online submissions for Flip String to Monotone Increasing.
    public int minFlipsMonoIncr(String S) {
        int f0 = 0, f1 = 0;
        for (int i = 0; i < S.length(); ++i) {
            f0 += S.charAt(i) - '0';
            f1 = Math.min(f0, f1 + 1 - (S.charAt(i) - '0'));
        }
        return f1;
    }
    */
	
    //<����Ǯ��3 by yuanb10>
    
    //same as ����Ǯ��2, easier code
    
    //Runtime: 3 ms, faster than 87.57% of Java online submissions for Flip String to Monotone Increasing.
    //Memory Usage: 38.5 MB, less than 20.00% of Java online submissions for Flip String to Monotone Increasing.
    public static int minFlipsMonoIncr(String S) {
        int r0 = 0, l1 = 0;        
       for (int i = 0; i < S.length(); i++) {
           if (S.charAt(i) == '0') {
               r0++;
           } 
       }        
       int res = r0;        
       for (int j = 0; j < S.length(); j++) {
           if (S.charAt(j) == '0') {
               r0--;
           } else {
               l1++;
           }
           res = Math.min(l1 + r0, res);
       }
       return res;          
   }
	
    

	
	public static void main(String[] args) {
//		String S = "010110";
//		String S = "11011";
		String S = "000110001";
		System.out.println(minFlipsMonoIncr(S));
	}
	
	
}
