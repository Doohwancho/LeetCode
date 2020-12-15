package dynamicProgramming;

public class LongestIncreasingSubsequence300 {
	
	//<����Ǯ��1>
	
	//dp
	
	//O((N+1)*(N/2))
	
	//Runtime: 55 ms, faster than 28.86% of Java online submissions for Longest Increasing Subsequence.
	//Memory Usage: 39.2 MB, less than 11.69% of Java online submissions for Longest Increasing Subsequence.
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len];
        cnt[len-1] = 1;
        for(int i = len-2; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(nums[j] > nums[i]){
                    cnt[i] = Math.max(cnt[i], cnt[j]+1);
                }
            }
            if(cnt[i] == 0) cnt[i] = 1;
        }
        int rst = 0;
        for(int ele : cnt){
            rst = Math.max(rst, ele);
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by HelloWorld123456>
    
    //[4,5,6,7,1,2,3]�̶�� ������ �ִٰ� ġ��.
    
    //�׷� [4,5,6,7]������ ������ �����ٰ�, 1,2,3���ʹ� �տ� 4,5,6�� �ڸ��� ��ĭ�� ����
    
    //[1,2,3,7]������. ������ 4,5,6,7 4ĭ �޺� �̻� ���� �ʱ� ������, 3�������� ����.
    
    //�׷��� ������ 4,5,6,7 4ĭ�޺��� �������.
    
    //���� [4,5,6,7,1,2,3,0,1,2,3,4] �� �����,
    
    //0�� �ٽ� ù°ĭ���� �ڸ� ���
    
    //[0,2,3,7]
    //[0,1,3,7]
    //[0,1,2,7]
    //[0,1,2,3]
    //[0,1,2,3,4]
    
    //�̷��� �ǰ���.
    
    //binary search�� �� �� �ִ� ������, subs�� ������������ ���ĵǾ��� ����.
    
    //Runtime: 2 ms, faster than 84.56% of Java online submissions for Longest Increasing Subsequence.
    //Memory Usage: 38.8 MB, less than 25.00% of Java online submissions for Longest Increasing Subsequence.
    
    private void binarySearchReplace(int[] subs, int length, int val){
        int l = 0, r = length;
        while(l < r){
            int m = (l+r)/2;
            if(subs[m] == val){
                return;
            }
            else if(subs[m] < val){
                l = m+1;
            } else {
                r = m;
            }
        }
        subs[l] = val;
    }
    
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] subs = new int[len];
        int size = 0;
        subs[size++] = nums[0];
        for(int i = 1; i < len; i++){
            if(nums[i] > subs[size-1]){
                subs[size++] = nums[i];
            } else {
                binarySearchReplace(subs, size-1, nums[i]);
            }
        }
        return size;
    }
}
