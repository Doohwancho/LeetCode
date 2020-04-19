package thirtyDayChallenge;

public class SearchInRotatedSortedArray {

	/*
	//<����Ǯ��1>
	
	//���Խ��� ���ô� ��

	//196 / 196 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 39.7 MB
	
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
        } 
        return -1;
    }
    */
	
	//<����Ǯ��2>
	
	//�̰Űŵ�
	
	//{3,4,5,1,2}���� 1���� �ɷη� ���� ���ص�, ��·�� �������� ���ĵǾ��ֱ� ������ binary search ���� ������
	
	//���������� Your algorithm's runtime complexity must be in the order of O(log n)
	
	//�̷��µ� O(log n)�� ��ǥ���� ���� binary search ������
	
	//�Ϲ����� binary search��
	
	//m = (l+r)/2;
    //if(nums[m] == target) return m;
	//else if(nums[m] < target) l = m+1;
    //else r = m-1;
	
	//�̰��ݾ�?
	
	//�ٵ� �� array�� �տ� ���� �� ©���� �ڿ� �پ��ݾ�?
	
	//�׷��� ���� �տ� �ݿ��� ��� �ڿ� �ݿ��� ��� ���� ���ؾ� ��.
	
	//nums[m]�� �տ��� ��ִµ� target�� �ڿ� �ְų�, �� �ݴ� ��Ȳ�̸� ���� �̻��ϰ� ���Ϳ�
	
	//else if(nums[m] >= nums[0] && target < nums[0]) l = m+1;
    //else if(target >= nums[0] && nums[m] < nums[0]) r = m-1;
	
	//�׷��� �� �κ��� �߰�����¡
	
	//196 / 196 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 38.7 MB
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m;
        while(l<r+1){
            m = (l+r)/2;
            if(nums[m] == target) return m;
            else if(nums[m] >= nums[0] && target < nums[0]) l = m+1;
            else if(target >= nums[0] && nums[m] < nums[0]) r = m-1;
            else if(nums[m] < target) l = m+1;
            else r = m-1;
        }
        return -1;
    }
}
