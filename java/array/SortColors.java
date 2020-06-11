package juneChallenge;

public class SortColors {
	
	//<����Ǯ��1>
	
	//�տ� �ְ� �ڿ��ֺ��� �� ũ��, ���� swap���ְ�, cnt+1
	
	//cnt�� �ѹ��� ������������ �ݺ�
	
	//���� ������ �ַ���� �����ٵ�..
	
	//���������� ��޵Ȱ�, int[]�� map�����ſ� ���� ���ڰ� ����� �󵵼��� ���Դ��� �����ڰ�, �װ� �ٽ� nums�� ������� ������°ǵ�, �̰� ������ �ȳ�
	
	//�׸��� ��� swap�� �Ϸ�Ǿ, ������ ���ٴ°� Ȯ���ϱ� ���� for���� �ѹ� �� ��. ��ȿ��.
	
	//Runtime: 2 ms
	///Memory Usage: 37.8 MB
    public void sortColors(int[] nums) {
        boolean flag = true;
        while(flag){
            int cnt = 0;
            for(int a = 0, b = 1; b < nums.length; a++, b++){
                if(nums[a] > nums[b]){
                    int tmp = nums[a];
                    nums[a] = nums[b];
                    nums[b] = tmp;
                    cnt++;
                } 
            }
            if(cnt == 0){
                flag = false;
            }
        }
    }
    
    
    
    //<����Ǯ��2 by chase1991>
    
    //�̰� ���� �������� ������'��' ��ȿ�� �������� �����ϴٰ� ������.
    
    //ū �������� ����, �ϴ�
    
    //index 0�� zero, ������ �ε����� two, �׸��� �� ����(0���� nums.length)������ ���� count�� �ְ�
    
    //while���� 2�� �־�.
    
    //���� while���� ����, ������ �ΰ��� �ִµ�,
    
    //�ϴ� count <= two�� array out of bound error�� ���ϱ� ���ؼ� �ִ°Ű�
    
    //count >= zero�� count�� zero�� ���������� while���� ������ ���ؼ� ����.
    
    //���� while���� ������ count++;�� �ؼ� count+1�� ���ְŵ�. �׷��� count�� �׻� zero�ε������� ū ��������.
    
    //�׻��¿��� count�� ������ 0�� ������, ���ʿ� 0�̶� �ٲ��ְ�, 2�� ������ �� ���ʿ� 2�� �ٲ��ִ°ž�. 
    
    //1�� ������ ��¥�� �߰��� �־�� �ϴ¾ְ� 1�̴ϱ� �ȹٲٰ� count�� ��� +1�� �ذ��鼭 �׳� �ѱ��. 
    
    //Runtime: 0 ms
    //Memory Usage: 38 MB
    
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = 0, count = 0, two = nums.length - 1;
        while (count <= two && count >= zero) {
            while (count <= two && count >= zero) {
                if (nums[count] == 0) {
                    swap(nums, count, zero);
                    zero++;
                }
                if (nums[count] == 2) {
                    swap(nums, count, two);
                    two--;
                }
                if (nums[count] == 1) break;
            }
            count++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    //<����Ǯ��3 by Cheng_Zhang, editted by EdickCoding>
    
    //�갡 �������� ���� �����鼭 ���ɵ� ���� ���� �ƴұ�
    
    //for�� ��ť�� ���鼭 0�̸� left(starting from index 0)�� swap�ϰ�, left+1,
    
    //2�� right(starting from the end of the array)�� swap�ϰ�, right-1
    
    //�ٵ� swap�� i-1�� �������ν�, swap �Ŀ� �ٲ� i�� �ٽ��ѹ� Ȯ����.
    
    //�׷��� ����Ǯ�� 1ó�� ������ array�� iterate�� �ʿ����, �ش� �ڸ��� ���ڰ� �Ϻ����������� �� �ڸ��� ��⵹�鼭 swap���ִ°Ŷ�
    
    //�ξ� �� �ð��� �Ƴ� �� ����.
    
    //�� �� �̻����� ������ ����� �Ҹ��Ѱſ��µ�
    
    //Runtime: 0 ms
    //Memory Usage: 37.9 MB
    
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                swap(nums, i, l++);
            } else if (nums[i] == 2) {
                swap(nums, i--, r--);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
