/*
 
	<����>
	
	�迭�� [2,0,2,1,1,0] �̷��� �־�����
	
	�������� �����϶�.
 
 */

package array;

public class SortColors75 {
	
	/*
	//<Trial01>
	
	//�츮 ���Խ��� �� ���� ģ���� ����
	
	//Note: You are not suppose to use the library's sort function for this problem.
	
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
    */
	
	/*
	//<����Ǯ��1>
	
	//�ܾ��� �󵵼��� �ľ��ϰ�, two pointer�̿��Ͽ� �󵵼� �ϳ��� ��鼭 ���ڸ� ������� ������Ʈ �ϴ� ���.
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
	//Memory Usage: 38.2 MB, less than 5.51% of Java online submissions for Sort Colors.
	
	public void sortColors(int[] nums) {
        int maxNum = 0;
        for(int element : nums){
            maxNum = Math.max(maxNum, element);
        }
        
        int[] container = new int[maxNum+1];
        for(int element : nums){
            container[element]++;
        }

        for(int i = 0, j = 0; i < nums.length; ){
            if(container[j] > 0){
                nums[i] = j;
                container[j]--;
                i++;
            }   
            else {
                j++;
            }
        }
    }
	*/
	
	//<����Ǯ��2 by BichengWang>
	
	//��̳� �����̱��� �ⷡ
	
	//2 1 0 0 1 2 
	//2 1 0 0 1 2 
	//1 1 0 0 2 2 
	//1 1 0 0 2 2 
	//1 1 0 0 2 2 
	//0 1 1 0 2 2 
	//0 0 1 1 2 2
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
	//Memory Usage: 38.2 MB, less than 5.51% of Java online submissions for Sort Colors.
    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        int mid = 0;

        while(mid <= end){
            if(nums[mid] == 0) swap(nums, begin++, mid++);
            else if(nums[mid] == 2) swap(nums, mid, end--);
            else mid++;
        }
    }
    
    private void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
    
    public static void main(String[] args) {
    	int[] test = {2,1,0,0,1,2};
    	SortColors75 obj = new SortColors75();
    	obj.sortColors(test);
	}
}
