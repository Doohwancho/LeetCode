package array;

import java.util.TreeSet;

public class FindTheDistanceValueBetweenTwoArrays1385 {
	
	/*
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 3 ms, faster than 76.88% of Java online submissions for Find the Distance Value Between Two Arrays.
	//Memory Usage: 40.7 MB, less than 100.00% of Java online submissions for Find the Distance Value Between Two Arrays.
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int rst = 0;
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(Math.abs(arr1[i]-arr2[j]) <= d){
                    break;
                }
                if(j == arr2.length-1) rst++;
            }
        }
        return rst;
    }
    */
	
	/*
	//<����Ǯ��2>
	
	//arr2�� �������� �����ϰ�, binary search�� arr1�� �� element�� �뷫������ arr2�� ����� ��ġ�ϴ��� �ε����� ���� ������
	
	//�ش� �ε����� �� ���� ������ ���̸� ���� d�� ���ϸ� ���? 
	 
	//Runtime: 3 ms, faster than 76.88% of Java online submissions for Find the Distance Value Between Two Arrays.
	//Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Find the Distance Value Between Two Arrays.
	
	private static int binarySearch(int[] arr, int value) {
		int l = 0, r = arr.length-1, m = 0;
		
        while(l <= r){
        	m = l + (r-l)/2;
        	
            if(arr[m] == value){
                return m;
            }
            else if(arr[m] < value){
            	l = m+1;
            }
            else {
            	r = m-1;
            }
        }
        return l;
    }
    
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        int rst = 0;
        int cnt = 0;
        Arrays.sort(arr2); 
        
        for(int i = 0; i < arr1.length; i++) {
        	int idx = binarySearch(arr2, arr1[i]);
            
        	if (idx < arr2.length && Math.abs(arr1[i]-arr2[idx]) <= d||
                idx > 0 && Math.abs(arr1[i]-arr2[idx-1]) <= d){
                cnt ++;
            }
        }
        
        return arr1.length - cnt;
    }
    
    */
	
	
    
    //<����Ǯ�� 3 by ashish53v>
    
	//Trial01�� ���� �����ε� binary search -> treeset���� �ٲ� ��
	
	//arr1: [4,5,8] , arr2: [10,9,1,8] , d: 2	
	//n: 4 higher: 8 lower: 1
	//n: 5 higher: 8 lower: 1
	//n: 8 higher: 8 lower: 8
	
    //Runtime: 7 ms, faster than 28.96% of Java online submissions for Find the Distance Value Between Two Arrays.
	//Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Find the Distance Value Between Two Arrays.
    
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int n : arr2)
            ts.add(n);
        
        for(int n : arr1){
            Integer higher = ts.ceiling(n);
            Integer lower = ts.floor(n);
            int diff = 0;
            if(higher == null){
                diff = Math.abs(lower - n);
            }else if(lower == null){
                diff = Math.abs(higher - n);
            }else{
                diff = Math.min(higher - n, n - lower);
            }
            if(diff > d)
                res++;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] arr1 = {4,5,8};
    	int[] arr2 = {10,9,1,8};
    	int d = 2;
    	
    	System.out.println(findTheDistanceValue(arr1, arr2, d));
	}
}
