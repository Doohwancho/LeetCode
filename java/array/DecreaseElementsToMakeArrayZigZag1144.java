package array;

public class DecreaseElementsToMakeArrayZigZag1144 {

	/*
	//<Trial01>
	
	//�𸣰͵���������
	
	public int movesToMakeZigzag(int[] nums) {
        
        int rst = 0;
        for(int i = 1; i < nums.length-1; i++){
            if((nums[i-1] < nums[i] && nums[i] < nums[i+1]) || (nums[i-1] > nums[i] && nums[i] > nums[i+1])){
                rst = nums[i]-Math.min(Math.abs(nums[i]-nums[i+1]),Math.abs(nums[i]-nums[i-1]))+1;
            }
        }
        return rst;
    }
	*/
	
	
	//<����Ǯ��1 by lee215>
	
	//�ؿ� ���� ������ ��. õ�鰡
	
	/*
	int movesToMakeZigzag(vector<int>& nums) {
	    if(nums.size()<3) return 0;
	    int res1=0;
	    for(int i=0;i<nums.size();i+=2){
	        int left=INT_MAX;
	        int right=INT_MAX;
	        if(i-1>=0) left=nums[i-1];
	        if(i+1<nums.size()) right=nums[i+1];
	        int target=min(left,right)-1;
	        res1+=max(0,nums[i]-target);
	    }
	    int res2=0;
	    for(int i=1;i<nums.size();i+=2){
	        int left=INT_MAX;
	        int right=INT_MAX;
	        if(i-1>=0) left=nums[i-1];
	        if(i+1<nums.size()) right=nums[i+1];
	        int target=min(left,right)-1;
	        res2+=max(0,nums[i]-target);
	    }
	    return min(res1,res2);
	}
	*/
	
	//case1)
	
	//int[] A : [9,6,1,6,2]
	
	//stdout
	//i: 0 res[0]: 4 res[1]: 0
	//i: 1 res[0]: 4 res[1]: 6
	//i: 2 res[0]: 4 res[1]: 6
	//i: 3 res[0]: 4 res[1]: 12
	//i: 4 res[0]: 4 res[1]: 12
	
	//Expected : 4
	
	
	//case2)
	
	//Input : [2,7,10,9,8,9]
	
	//stdout
	//i: 0 res[0]: 0 res[1]: 0
	//i: 1 res[0]: 0 res[1]: 6
	//i: 2 res[0]: 4 res[1]: 6
	//i: 3 res[0]: 4 res[1]: 8
	//i: 4 res[0]: 4 res[1]: 8
	//i: 5 res[0]: 4 res[1]: 10
	
	//Expected : 4
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Decrease Elements To Make Array Zigzag.
	//Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Decrease Elements To Make Array Zigzag.
	public int movesToMakeZigzag(int[] A) {
        int res[] = new int[2],  n = A.length, left, right;
        for (int i = 0; i < n; ++i) {
            left = i > 0 ? A[i - 1] : 1001;
            right = i + 1 < n ? A[i + 1] : 1001;
            res[i % 2] += Math.max(0, A[i] - Math.min(left, right) + 1); //Math.min(left, right)�� [1,2,4]�� [4,2,1]ó�� ��������� ���� �𸦶� ���. A[i] - Math.min(left, right) + 1�� ������� ��, �󸶸�ŭ A[i]���� �����ϴ����� ���� ��. ���� ���� ������ ������ ����. ��� += ���ִ� ������ ���ʸ� �ʷ��ϰ� ������ �� �����ϸ� �����Ҷ� ������ ���ؼ� ��¥�� �ѹ��ۿ� ������
        }
        return Math.min(res[0], res[1]);
    }
}
