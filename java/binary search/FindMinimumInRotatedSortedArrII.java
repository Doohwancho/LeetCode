package julyChallenge;

public class FindMinimumInRotatedSortedArrII {
	
	//<����Ǯ��1>
	
	//binary search
	
	//�� ���� �ٲ� ��.
	
	//X rotated : [1,2,3,4,5]
	//O rotated : [3,4,5,1,2] 
	
	//�ٵ� ������ m�� ����� 5�� ����ų ��, �̰� rotated������ l�� ���������� ���ܾ� �ǰ�, rotated�� �ȵ� �׳� [1,2,3,4,5]��� r�� �������� ���ܾ� �ɰ� �Ƴ�?
	
	//�װ� �����ϴ� ������ ����°� �ٽ�����?
	
	
	
	//if(nums[r] <= nums[m] && nums[l] >= nums[nums.length-1]) l++;
    
	//1) nums[r] <= nums[m] 
	
	//[3,3,1,3]����, m�� �ι�° 3�� ����Ű��������, �����ʿ� �ѱ��� ���� ��.
	
	//2) nums[l] >= nums[nums.length-1]
	
	//[1,3,3]���� ��쿡 �������� ���ܾ� �Ǵµ�, nums[r] <= nums[m]�������� ���������� ������?
	
	//�׷��� �� ���ʿ� �� l(1)�� �� �����ʿ� �ֺ��� ũ�ų� ������ ���� ������ �����ſ�.
	
	//rotated�Ǿ��� ��쿡�� ���������� ������. �ƴϸ� �������� �����.
	
	//Runtime: 0 ms
	//Memory Usage: 39.6 MB
	
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            int m = (l+r)/2;
            if(nums[r] <= nums[m] && nums[l] >= nums[nums.length-1]){
                l++;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
