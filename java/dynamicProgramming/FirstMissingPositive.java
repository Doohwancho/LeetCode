package september;

import java.util.PriorityQueue;

public class FirstMissingPositive {
	
	//<����Ǯ��1 by coderoath>
	
	//0���� �۰ų� �ʹ� ū ���ڴ� �� �ڷ� ��������. ũ�� ������� ���ڶ�.
	
	//else if�� nums[i]�� ���ڸ��� �ִ� �������� ���� ��. ���ڸ��� ������ �������ϰ� �������� �Ѿ.
	
	//���� nums[i]�� ���ڸ��� �ִ¾ְ� �ƴϸ�, else���� ���ڸ��� ��������. �׸��� �������� �Ѿ�� �ʰ�, �ٽ� ���� ���� �� i��°�� üũ.
	
	//else if�����̶� else������ sort �˰��� �� �ϳ��� ��. ASC�� ������.
	
	//[4,4,4,4,4,2,4] �̷� �ֵ�, else if�� 4�� �����ֵ��� �ɷ��� �� i++�Ǵٰ�
	
	//2�� ������ 2�� else if�� �ɷ���  i��°�� ����,
	
	//�� ���� iterate�� else���� �ɷ��� 2�� ���ڸ��� ���ư��� �Ǵ� ���.
	
	//Runtime: 0 ms
	//Memory Usage: 36.6 MB
	
    public int firstMissingPositive(int[] nums){
        int rst = 1;
        int len = nums.length;
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            if(nums[i] < 1 || nums[i] >= len){ //nums[i] >= len�� ������, ��� �ֵ��� �� len�̻��̸� ��¥�� return 1�ҰžƳ�.
                swap(nums, i, j);
                j--;
            } else if(nums[i]==nums[nums[i]-1]){ 
                i++;
            } else{
                swap(nums, i, nums[i]-1);
            }
        }
        
        for(int n : nums){
            System.out.println(n);
            if(n != rst){
                return rst;
            }
            rst++;
        }
        return rst;
    }
    void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
