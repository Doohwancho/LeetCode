package array;

public class FindPeakElement162 {
	
	/*
	//<����Ǯ��1>
	
	//�̰� �� medium����
	
	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Peak Element.
	//Memory Usage: 40.9 MB, less than 5.97% of Java online submissions for Find Peak Element.
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                idx = i;
                if(i < nums.length-1 && nums[i] > nums[i+1]) return i;
            }
        }
        return idx;
    }
    */
	
    //<����Ǯ��2>
    
    //�� i-1�� �ѹ��̶� �� ũ�ٴ°�, �װ� peak��� ���̴ϱ� �ٷ� i-1��ȯ���ָ� ����
    
    //idx�� else�� ���� �ִ밪�� �ε����� ��� ������Ʈ �����ְ�
    
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
    //Memory Usage: 40.2 MB, less than 5.97% of Java online submissions for Find Peak Element.
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for(int i = 1; i < nums.length; i++)
            if(nums[i-1] > nums[i]) return i-1;
            else idx = i;        
        return idx;
    }
}
