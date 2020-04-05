package array;

public class RemoveDuplicatesFromSortedArrayII80 {
	
	/*
	//<����Ǯ��1>
	
	//�� �˲��� ���˷δٰ�
	
	//���� 2�� �̻� �ߺ��� ���ڴ� artificial_number�� �� ä�� ����, �״ٿ� loop���� artificial_number�� ������ �� �����͵�� �ڸ� �ٲٴ� ���
	
	//�ε� �ʹ� �� �������
	
	//Runtime: 1 ms, faster than 13.63% of Java online submissions for Remove Duplicates from Sorted Array II.
	//Memory Usage: 39.8 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II.
	public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int duplicates = 0;
        int artificialNum = -100;
        
        for(int i = 0, j = 0, dup = 0; i < nums.length; i++){
            if(nums[i] == nums[j]){
                dup++;
            } else {
                if(dup <= 2){
                    j = i;
                    dup = 1;
                } else {
                    int i_ = i-1;
                    while(dup > 2){
                        nums[i_] = artificialNum;
                        i_--;
                        dup--;
                        duplicates++;
                    }
                    j = i;
                    dup = 1;
                }
            }
            if(i == len-1 && dup > 2){
                int i_ = i-1;
                while(dup > 2){
                    nums[i_] = artificialNum;
                    i_--;
                    dup--;
                    duplicates++;
                }
            }
        }
        
        for(int i = 0; i < len-1; i++){
            if(nums[i] == artificialNum){
                int minuses = 0;
                int i_ = i;
                int j = i;
                while(j < len && nums[j] == artificialNum){
                    j++;
                    minuses++;
                }
                while(j < len && minuses > 0){
                    nums[i_] = nums[j];
                    nums[j] = artificialNum;
                    i_++;
                    j++;
                    minuses--;
                }
            }
        }
        
        return len-duplicates;
    }
    */
	
	//<����Ǯ��2 by StefanPochmann>

	//��...
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
	//Memory Usage: 39.8 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II
	public static int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums) {
	        if (i < 2 || n > nums[i-2]) {
	        	nums[i++] = n;
	        }
	    }
	            
	    return i;
	}
	
	public static void main(String[] args) {
		int[] test = {1,1,1,2,2,3,3,3};
		removeDuplicates(test);
	}
}
