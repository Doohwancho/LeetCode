package array;

import java.util.Arrays;

public class ThreeSumClosest16 {
	
	/*
	//<Trial01>
	
	//�������ظ� ���ʿ� ���ع��ȳ�.
	
	//�� ������ ���� target�� ���� ������ ã�ƾ� �ϴµ� ���ϴ´簡 
	
	public static int binarySearch(int[] arr, int target) {
		int mid;
        int left = 0;
        int right = arr.length - 1;
        int closest = -1;
 
        while (right >= left) {
            mid = (right + left) / 2;
 
            if (target == arr[mid]) {
            	return mid;
            }
 
            if (target < arr[mid]) {
            	closest = mid;
                right = mid - 1;
            } else {
            	closest = mid;
                left = mid + 1;
            }
 
        }
        return closest;
    }
    
	public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int rst = 0;
        int idx = binarySearch(arr,target);
        int anchor = arr[idx];
        rst += anchor;
        
        for(int l = idx-1, r = idx+1, cnt = 0; cnt < 2; cnt++){
            if(r >= arr.length){
                rst += arr[l--];
            } else if(l <= 0){       
                rst += arr[r++];
            } else if(Math.abs(anchor)-Math.abs(arr[l]) < Math.abs(anchor)-Math.abs(arr[r])){
                rst += arr[l--];
            } else {
                rst += arr[r++];
            }
        }
        return rst;
    }
	
	//<Trial02>
	
	//���� �Ⱥپ��־ �ȴٰ� ���������� ģ����
	
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int three = nums[0]+nums[1]+nums[2];
        int diff = three > target ? three-target : target-three; 
        int rst = three;
        
        for(int i = 3, tmp = three; i < nums.length; i++){
            tmp = three+nums[i]-nums[i-3];
            if(diff > (tmp > target ? tmp-target : target-tmp)){ 
                rst = tmp;    
            }
        }
        return rst;
    }
    */
	
	//<����Ǯ��1>
	
    //binary search
	
	//Runtime: 7 ms, faster than 31.05% of Java online submissions for 3Sum Closest.
	//Memory Usage: 38.7 MB, less than 6.67% of Java online submissions for 3Sum Closest.
    public static int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) { //target - (sum||result)�����ʰ� (sum||result)-target�Ѱ�, target�� �������־ -�̵� +�̵� ����
                    result = sum;
                }
            }
        }
        return result;
    }
    
    
	public static void main(String[] args) {
//		int[] nums = {-1, 2, 1, -4};
		int[] nums = {0, 2, 1, -3};
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}
}
