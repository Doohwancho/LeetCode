package juneChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
	
	//<Trial01>
	
	//��򸮴ϱ� �ѹ� �׷�����
	
	//[1,2,3,4,8,9]
	
	//  0,1,2,3,4,5,8,9
	//0 0
	//1   0 1 1 1 1 1 1
	//2   0 0 2 2 2 2 2
	//3   0 1 0 3 3 3 3
	//4   0 0 1 0 4 4 4 
	//5   0 1 2 1 0 5 5
	//8   0 0 2 0 3 0 8
	//9   0 1 0 1 4 1 0
	
	//[1,2,4,8] -- taken
	//[1,3,9]   -- not taken
	
	//���η� 0�� ������ ���� �����ָ� ������ �ǰڳ�?
	
	//�ٵ� 1�� ��Ģ�̴ϱ� 1���� 0�� �� ���� �������� �ε��� ���� ���ϸ� ���� ������?
	
	//�� �ȵ�~
	
	//Input: [1,2,3,4,6,24]
	//Output: [2,4,6,24,1]
	//Expected: [1,2,4,24]
	
	//0 6 4 3 2 2 1 
	//0 0 1 1 1 1 1 
	//0 0 0 2 2 2 2 
	//0 0 1 0 3 3 3 
	//0 0 0 1 0 4 4 
	//0 0 0 0 2 0 6 
	//0 0 0 0 0 0 0 
	
	//6�� �Ż縮 ����? 6�̶� 4�� ȣȯ �ȵǴ°� ���Ÿ� 
	
	//recursive�� �ϸ� �и� ��ǲ ��ģ���� �Ѱ��� �� �־ time limit��Ű�����
	
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	//��ȿ�� �˻�
        int n = nums.length;
        if(n == 0) return new ArrayList<>();
        
        //1�� ���� Ȯ��
        boolean one = false;
        for(int num : nums){
            if(num == 1){
                one = true;
                break;
            }
        }
        
        //2���� �迭�� �� ���� %�ؼ� 0�Ǵ��� Ȯ�� ��, 0�̸� �ش� ���� ���� ���κп� count+1
        int[][] a = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                a[i][j] = nums[i-1]%nums[j-1];
                if(a[i][j] == 0) a[0][j]++;
            }
        }
            
        //1�� ������ ������ �߿� ���� %�� ���� �������� �� Ȯ��
        int largestRow = 0;
        for(int p = 1, j = a[0][0]; p <= n; p++){
            if(a[0][p] > j && nums[p-1] != 1){
                largestRow = p;
                j = a[0][p];
            }
        }
        
        //����
        List<Integer> rst = new ArrayList<>(n);
        
        for(int q = 0, k = 1; q < a[0][largestRow]; q++){
            while(k <= n && a[k][largestRow] > 0){
                k++;
            }
            rst.add(nums[k++-1]);
        }
        
        //1�� ��� ���� %�� �� �����Ƿ�, 1�� �ִٸ� 1�� ����
        if(one) rst.add(1);
        
        return rst;
    }
    
    
    
    //<����Ǯ��1 by zhugejunwei>
    
    
    //input : [1,2,3,4,6,24]
    
    //i: 1 j: 0 max: 2 mi: 1
	//121111
	//000000
    
	//i: 2 j: 0 max: 2 mi: 1
	//122111
	//000000
    
	//i: 3 j: 1 max: 3 mi: 3
	//122311
	//000100
    
	//i: 4 j: 2 max: 3 mi: 3
	//122331
	//000120
    
	//i: 5 j: 4 max: 4 mi: 5
	//122334
	//000124      -- nums[5]->nums[4]->nums[2]->nums[1]������ ���
    
    //[1,3,6,24]
    
    //Runtime: 15 ms
    //Memory Usage: 39.3 MB

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> rst = new LinkedList<>();
        if(n == 0) return rst;
        Arrays.sort(nums);      //���� �������ں��� �� �������� �������ھ� �ϳ��ϳ� ���� ���̱� ������ �������� ����.
        int[] maxi = new int[n]; //�� ��� %�� ���� �� �ִ��� �������� Ȯ��
        int[] prev = new int[n]; //i%j�� �����Ѵٸ�, i�ڸ��� j�� �־������� ��, backtracking����. 
        int max = 1; //maxi�� �ִ밪. 1�� �����ϴ� ������ n==1�� ��츦 ó���ϱ� ����.
        int mi = 0;
        
        Arrays.fill(maxi, 1);
        
        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i]%nums[j] == 0 && maxi[j] >= maxi[i]){ //&& maxi[j] >= maxi[i]�� �ϴ� ������, �̰� ����, [1,2,4]���� i=2, j=1�϶� i�ڸ��� j�� �̻ڰ� ������, 1�� ������ 1�� 2���ڸ��� ����Ե�. �ٵ� �츮�� ���ϴ°� max���Ž� index�� ���������� �����ֱ� ���ϴϱ�, �߰��� ������ ����� ������.
                    maxi[i] = maxi[j]+1;
                    prev[i] = j;
                    
                    if(maxi[i] > max){
                        max = maxi[i];
                        mi = i;    
                    }
                }
            }
        }
        while(max > 0){
            rst.add(0, nums[mi]);
            mi = prev[mi];
            max--;
        }
        return rst;
    }
}
