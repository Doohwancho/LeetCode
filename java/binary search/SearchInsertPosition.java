package juneChallenge;

public class SearchInsertPosition {
	
	//<����Ǯ��1>
	
	//binary search
	
	//EEEEEEEEEEEEZZZZZZZZZZZZZZZZZZZZZZZZZZ
	
	//target�� nums�� ������ �ε��� ��ȯ�ϰ�, ������ -1�� ��ȯ�϶�� �N����
	
	//if(nums[m] == target)�� ó���� ���� ������ return��Ű��
	
	//while�� �� ���� -1���� �����ϴ� ����� �����ٵ�,
	
	//���࿡ target�� nums�� ���ٸ�, �־���� �ϴ� �ڸ��� ��ȯ�϶�� �ؼ� ����«.
	
	//nums[m]�� target���� ���ų� ũ��, �ϴ� r�� target�� �ε����� �Ѵ���,
	
	//l�� target�� �ε������� �÷��� �ᱹ l�� ��ȯ�ϴ� ��.
	
	//
	
	//Runtime: 0 ms
	//Memory Usage: 38.8 MB
	
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int m = (l+r)/2;
            if(nums[m] >= target){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
