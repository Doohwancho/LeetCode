package october;

public class BinarySearch {

	//<����Ǯ��1>
	
	//binary search
	
	//���� binary search�� �����ϰ� ����.
	
	//Runtime: 0 ms
	//Memory Usage: 39.8 MB
	
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = (l+r)/2;
            if(nums[m] == target){
                return m;
            }
            if(nums[m] < target){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        if(l == nums.length) return -1;
        return nums[l] == target ? l : -1;
    }
}
