package julyChallenge;

public class ClimbingStairs {
	
	//<Trial01 - Time Limit Exceeded>
	
	//dfs
	
	//�� dfs�� ���ٰ�~ 
	
	//�н� �ð� �޶��~
	
    static int rst = 0;
    
    private static void helper(int n, int i){
        if(i == n) rst++;
        else if(i > n) return;
        helper(n, i+1);
        helper(n, i+2);
    }
    
    public static int climbStairs(int n) {
        helper(n, 0);
        return rst;
    }
    
    
    //<Trial02>
    
    //������ ������ �����پ˾Ҵµ� �ƴѰŰ��� ����?
    
    //1, 2, 3,  4,  5,  6,  7,  8,   9,  10
    //1, 3, 6, 11, 19, 32, 53, 87, 142, 231
    
    public int climbStairs(int n) {
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 3;
        for(int i = 2; i < n; i++){
            a[i] = (a[i-1] + a[i-2] + 2);
        }
        return a[n-1];
    }
    
    
    
    //<����Ǯ��1>
    
    //¥��!
    
    //������ �ô��� �Ǻ���ġ �����̿����ϴ�!
    
    //1, 2, 3, 4, 5,  6,  7,  8,  9, 10
    //1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    
    //Runtime: 0 ms
    //Memory Usage: 37.9 MB
    
    public int climbStairs(int n) {
        int[] a = new int[n];
        a[0] = 1;
        if(n > 1) a[1] = 2;
        for(int i = 2; i < n; i++){
            a[i] = (a[i-1] + a[i-2]);
        }
        return a[n-1];
    }
    
}
