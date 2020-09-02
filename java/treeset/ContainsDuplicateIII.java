package september;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	
	
	//<����Ǯ��1>
	
	//brute-force
	
	//long��ȯ�� �߰��� �Ѱ�, Integer.MAX_VALUE�� �ʰ��ϴ� ������ ���ͼ� �׷�.
	
	//�ٸ������ ����������.
	
	//Runtime: 493 ms
	//Memory Usage: 40.1 MB
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        
        long[] lnums = new long[len];
        for(int i = 0; i < len; i++){
            lnums[i] = (long)nums[i];
        }
        
        k = k >= len ? len-1 : k;
        
        for(int i = 0, j = k; i < len; i++){
            
            for(int p = j; p > i; p--){
                if(Math.abs(lnums[p]-lnums[i]) <= t) return true;    
            }
            if(j+1 < len){ //j�� index out of bound�ȶ߰� len-1�� limit���� �� �������ش�.
                j++;
            }
        }
        return false;
    }
    
    
    //<Trial01>
    
    //nums�� �������� ���ؼ� k��° �������ִ¾ֶ� ���̰� t���ϸ� return true
    
    //�Ϲ����� input������ �Ǵµ�, accum[i]+accum[p]�� Integer.MIN-VALUE�� ���,
    
    //-2147483648 �ε�, Math.abs(2147483648)�� ������,
    
    //-2147483648 �� ���ͼ� ����.
    
    //�ֳĸ� int�� �ִ������ -2147483648���� +2147483647�����̱� ����.
    
    //�׷��� int[] accum�� long[] accum���� �ٲٸ�, Time limit exceeded�� �� �����?
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        
        int[] accum = new int[len];
        
        for(int i = 1; i < len; i++){
            accum[i] = accum[i-1]+nums[i]-nums[i-1];
        }
        
        for(int i = len-1, j = i-k; i >= 0; i--, j--){
            for(int p = j >= 0 ? j : 0; p < i; p++){
                if(Math.abs(accum[i]-accum[p]) <= t) return true;
            }
        }
        
        return false;
    }
    
    
    
    //<����Ǯ��2 by jinwu>
    
    //Treeset, O(N lg K)
    
    //Runtime: 28 ms
    //Memory Usage: 43.6 MB
    
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null && nums.length == 0 || k == 0){
            return false;
        }
        
        TreeSet<Long> ts = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++){
            //find floor, ceiling
            Long floor = ts.floor((long)nums[i]);
            Long ceiling = ts.ceiling((long)nums[i]);
            if(floor != null && nums[i]-floor <= t ||
               ceiling != null && ceiling-nums[i] <= t){
                return true;
            }
            
            //add
            ts.add((long)nums[i]);
            
            //remove prev
            if(i >= k){
                ts.remove((long)nums[i-k]);    
            }
        }
        
        return false;
    }
}
