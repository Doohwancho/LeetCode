package array;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget1300 {
	
	/*
	//<Trial01>
	
	//���� arr�ȿ� �ִ� ���� Ǯ���µ�, ���� ��츦 ���� ��ǰ
	
	//Input : [1547,83230,57084,93444,70879], 71237
	//Output: 14247
	//Expected: 17422
	
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int compare = 0;
        int rst = target/arr.length;
        
        for(int i = 0, rest = arr.length, total = 0, prev = Math.abs(target/arr.length*arr.length - target), curr = 0; i < arr.length; i++){
            total += arr[i];
            if(total > target){
                break;
            }
            rest--;
            curr = Math.abs(total + (rest * arr[i]) - target);
            if(curr < prev){
                compare = curr;
                rst = arr[i];
            }
            prev = curr;
            
        }
        return rst;
    }
    */
    /*
	//<Trial02>
	
	//���� �� ��������.. ������ ���� �̤̤� ����
    
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int compare = 0;
        int rst = target/arr.length;
        
        for(int i = 0, rest = arr.length, total = 0, prev = Math.abs(target/arr.length*arr.length - target), curr = 0; i < arr.length; i++){
            total += arr[i];
            if(total > target){
                if(prev <= Math.abs((total - arr[i])+(target-(total-arr[i]))/rest*rest-target)){
                    break;
                } else {
                    rst = (target-total-arr[i])/rest;
                    break;
                }
            }
            rest--;
            curr = Math.abs(total + (rest * arr[i]) - target);
            if(curr < prev){
                compare = curr;
                rst = arr[i];
            }
            prev = curr;
        }
        return Math.abs(rst % 10 * arr.length - target % 10) <= Math.abs((rst+1)%10*arr.length - target % 10) ? rst : rst+1;
    }
    */
    
    //<����Ǯ��1 by lee215>
    
	//1. Sort the array A in decreasing order.
	//2. We try to make all values in A to be the min(A) (the last element)
	//3. If target >= min(A) * n, we doesn't hit our target yet.
	//	 We should continue to try a value bigger.
	//4. So we pop the min(A) value.
	//	 Consider that it won't be affected anymore,
	//	 we can remove it from target by target -= A.pop()
	//5. We continue doing step 2-4, until the next number is too big for target.
	//6. We split the the target evenly, depending on the number of element left in A
	
	//�������� rst or rst+1��ȯ�� ���� float�� ó�� �ϴ¹� ����
	
	//if not A:  # Used all values to be close to `target`.
	//return maxA
	//if target / len(A) - target // len(A) <= 0.5:  # Fractional part is <= 0.5
	//    # Select the smaller one especially when there's two candidates (== 0.5)
	//    return target // len(A)
	//return target // len(A) + 1
    
    //Runtime: 3 ms, faster than 58.69% of Java online submissions for Sum of Mutated Array Closest to Target.
    //Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Sum of Mutated Array Closest to Target.
    public int findBestValue(int[] A, int target) {
        Arrays.sort(A);
        int n = A.length, i = 0;
        while (i < n && target > A[i] * (n - i)) {
            target -= A[i++];
        }
        if (i == n) return A[n - 1]; //arr�� ��� ���� ��, ���� ū������ ���ص� target�� ����ġ��, arr�� ���� ū �� ��ȯ
        int res = target / (n - i); 
        if (target - res * (n - i) > (res + 1) * (n - i) - target) //Math.abs()�Ⱦ��� ����ϳ�
            res++;
        return res;
    }
}
