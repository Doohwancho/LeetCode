package array;

public class FindMinimumInRotatedSortedArr153 {
	
	/*
	//<����Ǯ��1>
	
	//�̰� �� medium������? 
	
	//Runtime: 1 ms, faster than 5.26% of Java online submissions for Find Minimum in Rotated Sorted Array.
	//Memory Usage: 39.9 MB, less than 6.82% of Java online submissions for Find Minimum in Rotated Sorted Array.
    public int findMin(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }
    */
	
	/*
	//<����Ǯ��2>
	
	//1ms�Ƴ����� ������ ���� �ð��� ��°��� �𸣰�����
	
	//�ϴ� [1,2,3]ó�� ��ȸ���� arr�� ���� �������� ��ȸ���� �ȵȻ��·� �����ų� [2] �̵����� ������ ����ó�����ִ� �� if���� ����
	
	//else���� binary search�� �̿��� ��. [3,4,5,1,2]�� ��������-ish�ϰ� ���ĵ����ڳ�
	
	//�츮�� ã�°� 1�ε�, 3,4,5�� nums[m]�� �ɷ�������, nums[0]�� 3���� nums[m]�� �� ũ�ϱ�, ���������� �����
	
	//���� nums[m]�� 1�̳� 2, 2��� ���� 2�� ����������, nums[0]�� 3���� �����ϱ� �������� ����°�
	
	//�׷��ٰ� nums[m]�� nums[m-1]���� ���� ���(��ü arr���� �� �ѹ����̿�. 5,1 �̺κ�)
	
	//1�� ����
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
	//Memory Usage: 39.6 MB, less than 35.23% of Java online submissions for Find Minimum in Rotated Sorted Array.
    public static int findMin(int[] nums) {
        if(nums.length == 1 || nums[nums.length-1] > nums[0]){
            return nums[0];
        } else {
            int l = 1, r = nums.length-1;
            while(l <= r){
                int m = (l+r)/2;
                if(nums[m] < nums[m-1]){
                    return nums[m];
                }
                else{
                    if(nums[m] > nums[0]){
                        l = m+1;
                    } 
                    else {
                        r = m-1;
                    }
                }
            }
            return nums[l];
        }
    }
    */
    
    //<����Ǯ��3 by diaa>
    
    //if(nums[m] > nums[r]) l = m+1; �ϴ� �̺κ��� �Ἥ [3,4,5,1,2]�� ���ε�� [3,4,5]���� ������
    
    //else r = m; �� �Ἥ 1,2, ... ���� ���� �������� 1�� ���� ��
    
    //nums[l]�� ��ȯ�ϴ� ���.
	
	//�� ����� ���� ����Ǯ��2���� ���� ���ŷο� ����ó���� �����൵ �ȴ�.
	
	//[1]���� ��� while���� �ȵ��Ƽ� �ٷ� ��ȯ�ҰŰ�
	
	//[2,1]�� ��쵵 2�� if������ �ɷ����� 1�� else������ Ȯ����.
	
	//[1,2,3]�� ��쵵 if���� �ѹ��� �ȵ��� else���� ���Ƽ� �ᱹ ���� �������� 1�� Ȯ���� ���̱� ����.
    
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
    //Memory Usage: 39.2 MB, less than 59.09% of Java online submissions for Find Minimum in Rotated Sorted Array.
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length-1, m;
        while(l < r){
            m = (l+r)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
	
	public static void main(String[] args) {
		int[] test = {4,5,6,7,0,1,2};
		System.out.println(findMin(test));
	}
    
}
